package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.SenderMailDetailsRepo;
import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.entity.SenderMailDetails;
import ProHire.Mail.entity.User;
import ProHire.Mail.request.SenderMailRequest;
import ProHire.Mail.services.SenderMailDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderMailDetailsServiceImpl implements SenderMailDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SenderMailDetailsRepo senderMailDetailsRepo;


    @Override
    public SenderMailDetails createSenderMailDetails(SenderMailRequest senderMailRequest) {
        // Fetch the user
        User user = userRepo.findById(senderMailRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + senderMailRequest.getUserId()));

        // Build SenderMailDetails entity
        SenderMailDetails senderMailDetails = SenderMailDetails.builder()
                .senderMail(senderMailRequest.getSenderMail())
                .senderName(senderMailRequest.getSenderName())
                .password(senderMailRequest.getPassword())
                .user(user)
                .build();

        // Save and return
        return senderMailDetailsRepo.save(senderMailDetails);
    }

}
