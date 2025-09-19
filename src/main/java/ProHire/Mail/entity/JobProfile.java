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
public class JobProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String jobTitle;
    private String name;
    private String role;
    private String email;
    private String leetcode;
    private String github;
    private String linkedin;
    private String resume;
    private String portfolio;
    private String subject;
    private int htmlTemplateBody;
    private String dpLink;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String resumePath;

    @ManyToOne
    @JsonIgnore
    private User user;

}
