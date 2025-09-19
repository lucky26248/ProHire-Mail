package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.MailTemplateRepo;
import ProHire.Mail.entity.MailTemplate;
import ProHire.Mail.services.MailTemplateService;
import ProHire.Mail.utils.MailTemplatesService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MailTemplateServiceImpl implements MailTemplateService {

    @Autowired
    private MailTemplateRepo mailTemplateRepo;

    @Override
    public Optional<MailTemplate> getMailTemplateById(int mailTemplateId) {
        return mailTemplateRepo.findById(mailTemplateId);
    }
}
