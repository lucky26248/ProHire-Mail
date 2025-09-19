package ProHire.Mail.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobProfileRequest {
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
    private String description;
    private String resumePath;
    private int htmlTemplateBody;
    private String dpLink;
    private String userId;
}
