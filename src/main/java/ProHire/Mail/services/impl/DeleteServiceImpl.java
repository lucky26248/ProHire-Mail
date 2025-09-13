package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.JobProfileRepo;
import ProHire.Mail.Repo.MailDetailsRepo;
import ProHire.Mail.Repo.SenderMailDetailsRepo;
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
