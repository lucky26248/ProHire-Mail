package ProHire.Mail.utils;

import ProHire.Mail.entity.JobProfile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class MailTemplatesService {

    public String loadTemplate(String filename) throws IOException {
        // Classpath resource including package structure
        ClassPathResource resource = new ClassPathResource("ProHire/Mail/templates/" + filename);
        try (var inputStream = resource.getInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public String apply(JobProfile jobProfile) throws IOException {
        String template = loadTemplate("apply-template.html");

        return template
                .replace("{{name}}", safe(jobProfile.getName()))
                .replace("{{email}}", safe(jobProfile.getEmail()))
                .replace("{{github}}", safe(jobProfile.getGithub()))
                .replace("{{leetcode}}", safe(jobProfile.getLeetcode()))
                .replace("{{linkedin}}", safe(jobProfile.getLinkedin()))
                .replace("{{portfolio}}", safe(jobProfile.getPortfolio()))
                .replace("{{resume}}", safe(jobProfile.getResume()))
                .replace("{{description}}", safe(jobProfile.getDescription()));
    }

    private String safe(String value) {
        return Objects.toString(value, "");
    }
}
