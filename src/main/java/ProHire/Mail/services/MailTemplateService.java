package ProHire.Mail.services;

import ProHire.Mail.entity.MailTemplate;

import java.util.Optional;

public interface MailTemplateService {
    Optional<MailTemplate> getMailTemplateById(int mailTemplateId);
}
