package ProHire.Mail.utils;

import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.entity.MailTemplate;
import ProHire.Mail.services.MailTemplateService;
import ProHire.Mail.templates.TemplateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class MailTemplatesService {

    @Autowired
    private TemplateProcessor templateProcessor;

    @Autowired
    private MailTemplateService mailTemplateService;

    public String loadTemplate(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource("ProHire/Mail/templates/" + filename);
        try (var inputStream = resource.getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    // Fetch template dynamically from DB, fallback to default file
    public String loadTemplateFromDb(JobProfile jobProfile) throws IOException {
        MailTemplate mailTemplate = mailTemplateService
                .getMailTemplateById(jobProfile.getHtmlTemplateBody()) // assuming JobProfile has templateId
                .orElse(null);

        if (mailTemplate != null && mailTemplate.getHtmlTemplateBody() != null) {
            System.out.println("mail template load from DB");
            return mailTemplate.getHtmlTemplateBody();
        } else {
            System.out.println("mail template load from HTML file");
            return loadTemplate("apply-template.html");
        }
    }

    public String apply(JobProfile jobProfile) throws IOException {
        String template = loadTemplateFromDb(jobProfile);
        return templateProcessor.processTemplate(template, jobProfile);
    }

}
