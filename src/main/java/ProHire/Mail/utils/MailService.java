package ProHire.Mail.utils;

import ProHire.Mail.Repo.MailDetailsRepo;
import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.entity.MailDetails;
import ProHire.Mail.entity.SenderMailDetails;
import ProHire.Mail.entity.User;
import ProHire.Mail.services.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Service
public class MailService {

    @Autowired
    private UserService userService;

    @Autowired
    private MailDetailsRepo mailDetailsRepo;

    @Autowired
    private MailTemplatesService mailTemplatesService;

    // Send mails for all users
    public ResponseEntity<HttpStatus> executeMailSendingEachUser() {
        List<User> users = userService.getUsers();
        for (User user : users) {
            try {
                processUserMail(user);
            } catch (Exception e) {
                System.err.println("❌ Failed to process mails for user " + user.getUsername() + ": " + e.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // Send mails for a single user
    public void processUserMail(User user) {
        List<SenderMailDetails> senderMailDetails = user.getSenderMailDetails();
        System.out.println("Start sending mail for " + user.getUsername());
        if (senderMailDetails == null || senderMailDetails.isEmpty()) return;

        List<MailDetails> mailDetails = user.getMailDetails();
        if (mailDetails == null || mailDetails.isEmpty()) return;

        int currentIdx = 0; // per-user

        for (MailDetails mail : mailDetails) {
            if (mail.getTotalMailSendCount() > 0) continue;

            try {
                sendMail(senderMailDetails.get(currentIdx), mail);
                currentIdx = (currentIdx + 1) % senderMailDetails.size();

//                mail.setTotalMailSendCount(mail.getTotalMailSendCount() + 1);
                mailDetailsRepo.save(mail);

            } catch (Exception e) {
                System.err.println("❌ Failed to send mail to " + mail.getMail() + ": " + e.getMessage());
            }
        }
    }

     //Send a single mail using given sender
    private  void sendMail(SenderMailDetails senderMailDetails, MailDetails mailDetails)
            throws MessagingException, IOException {

        System.out.println("Mail sent from " + senderMailDetails.getSenderMail() + " to " +mailDetails.getMail());

        JavaMailSender javaMailSender = getJavaMailSender(senderMailDetails);
        JobProfile jobProfile = mailDetails.getJobProfiles();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, false);

        // Display name fallback
        String displayName = senderMailDetails.getSenderName() != null
                ? senderMailDetails.getSenderName()
                : "ProHire Mail Service";

        helper.setFrom(senderMailDetails.getSenderMail(), displayName);
        helper.setTo(mailDetails.getMail());
        helper.setSubject(safe(jobProfile.getSubject()));

        // HTML body
        String body = mailTemplatesService.apply(jobProfile);

        helper.setText(body, true);

        // Resume attachment
//        if (jobProfile.getResumePath() != null) {
//            File resumeFile = new File(jobProfile.getResumePath());
//            if (resumeFile.exists()) {
//                String filename = safe(jobProfile.getName()) + "_" + safe(jobProfile.getRole()) + "_resume.pdf";
//                helper.addAttachment(filename, resumeFile);
//            }
//        }

        javaMailSender.send(message);
    }

    // Build mail sender dynamically from sender details
    public static JavaMailSender getJavaMailSender(SenderMailDetails senderMailDetails) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(senderMailDetails.getSenderMail());
        mailSender.setPassword(senderMailDetails.getPassword()); // Gmail App Password
        System.out.println("mail password: " + senderMailDetails.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    //Helper for null-safety
    private static String safe(String value) {
        return Objects.toString(value, "");
    }
}
