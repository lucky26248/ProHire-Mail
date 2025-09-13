package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.JobProfileRepo;
import ProHire.Mail.Repo.MailDetailsRepo;
import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.entity.MailDetails;
import ProHire.Mail.entity.User;
import ProHire.Mail.request.MailDetailsRequest;
import ProHire.Mail.services.MailDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailDetailsServiceImpl implements MailDetailsService {

    @Autowired
    private MailDetailsRepo mailDetailsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JobProfileRepo jobProfileRepo;

    @Override
    public MailDetails createMailDetails(MailDetailsRequest request) {
        // Fetch user
        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + request.getUserId()));

        // Fetch job profile
        JobProfile jobProfile = jobProfileRepo.findById(request.getJobProfileId())
                .orElseThrow(() -> new RuntimeException("JobProfile not found with id " + request.getJobProfileId()));

        // Create MailDetails object
        MailDetails mailDetails = new MailDetails();
        mailDetails.setMail(request.getMail());
        mailDetails.setTotalMailSendCount(0); // start with 0
        mailDetails.setUser(user);
        mailDetails.setJobProfiles(jobProfile);

        // Save and return
        return mailDetailsRepo.save(mailDetails);
    }

}
