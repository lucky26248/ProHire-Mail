package ProHire.Mail.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenderMailRequest {
    private String senderMail;
    private String senderName;
    private String password;
    private String userId; //reference
}
