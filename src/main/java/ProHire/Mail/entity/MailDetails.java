package ProHire.Mail.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MailDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mailId;
    private String mail;

    private int totalMailSendCount;
    private Date lastSendDate;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private JobProfile jobProfiles;
}
