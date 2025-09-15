package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.JobProfileRepo;
import ProHire.Mail.Repo.MailDetailsRepo;
import ProHire.Mail.Repo.SenderMailDetailsRepo;
import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.services.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    private MailDetailsRepo mailDetailsRepo;

    @Autowired
    private SenderMailDetailsRepo senderMailDetailsRepo;

    @Autowired
    private JobProfileRepo jobProfileRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void deleteUser(String username) {
        userRepo.deleteById(username);
    }

    @Override
    public void deleteMailDetails(Long mailId) {
        mailDetailsRepo.deleteById(mailId);
    }

    @Override
    public void deleteSenderMailDetails(Long senderMailId) {
        senderMailDetailsRepo.deleteById(senderMailId);
    }

    @Override
    public void deleteJobProfile(Long profileId) {
        jobProfileRepo.deleteById(profileId);
    }
}
