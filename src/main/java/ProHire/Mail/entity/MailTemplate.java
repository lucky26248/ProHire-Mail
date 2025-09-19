package ProHire.Mail.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MailTemplate {

    @Id
    private int id;

    @Column(columnDefinition = "LONGTEXT")
    private String htmlTemplateBody;

}
