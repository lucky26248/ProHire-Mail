package ProHire.Mail.services;

import ProHire.Mail.entity.SenderMailDetails;
import ProHire.Mail.request.SenderMailRequest;

public interface SenderMailDetailsService {
    SenderMailDetails createSenderMailDetails(SenderMailRequest senderMailRequest);
}
