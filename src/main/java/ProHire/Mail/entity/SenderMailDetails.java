package ProHire.Mail.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SenderMailDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long senderMailId;

    private String senderMail;
    private String senderName;
    private String password;

    @ManyToOne
    @JsonIgnore
    private User user;
}
