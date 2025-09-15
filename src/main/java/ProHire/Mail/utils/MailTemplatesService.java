package ProHire.Mail.utils;

import ProHire.Mail.entity.JobProfile;
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

    public String loadTemplate(String filename) throws IOException {
        // Classpath resource including package structure
        ClassPathResource resource = new ClassPathResource("ProHire/Mail/templates/" + filename);
        try (var inputStream = resource.getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public String apply(JobProfile jobProfile) throws IOException {
        String template = loadTemplate("apply-template.html");
        return templateProcessor.processTemplate(template , jobProfile);
    }

}
