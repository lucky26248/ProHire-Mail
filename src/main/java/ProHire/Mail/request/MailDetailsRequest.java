package ProHire.Mail.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MailDetailsRequest {
    private String mail;
    private int totalMailSendCount;
    private Date lastSendDate;
    private String userId;       // reference to User
    private Long jobProfileId;   // reference to JobProfile
}
