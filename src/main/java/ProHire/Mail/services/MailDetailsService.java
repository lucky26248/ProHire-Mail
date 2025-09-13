package ProHire.Mail.services;

import ProHire.Mail.entity.MailDetails;
import ProHire.Mail.request.MailDetailsRequest;

public interface MailDetailsService {
    MailDetails createMailDetails(MailDetailsRequest mailDetailsRequest);
}
