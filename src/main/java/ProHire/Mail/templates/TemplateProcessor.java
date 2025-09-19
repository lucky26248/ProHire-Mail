package ProHire.Mail.templates;


import ProHire.Mail.entity.JobProfile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateProcessor {

    public String processTemplate(String template, JobProfile jobProfile) {
        Map<String, String> placeholders = new HashMap<>();
        //class field , value
        placeholders.put("{{jobTitle}}", safe(jobProfile.getJobTitle()));
        placeholders.put("{{name}}", safe(jobProfile.getName()));
        placeholders.put("{{role}}", safe(jobProfile.getRole()));
        placeholders.put("{{email}}", safe(jobProfile.getEmail()));
        placeholders.put("{{leetcode}}", safe(jobProfile.getLeetcode()));
        placeholders.put("{{github}}", safe(jobProfile.getGithub()));
        placeholders.put("{{linkedin}}", safe(jobProfile.getLinkedin()));
        placeholders.put("{{resume}}", safe(jobProfile.getResume()));
        placeholders.put("{{portfolio}}", safe(jobProfile.getPortfolio()));
        placeholders.put("{{subject}}", safe(jobProfile.getSubject()));
        placeholders.put("{{description}}", safe(jobProfile.getDescription()));
        placeholders.put("{{resume-path}}", safe(jobProfile.getResumePath()));
        placeholders.put("{{dp-link}}", safe(jobProfile.getDpLink()));


        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            template = template.replace(entry.getKey(), entry.getValue());
        }

        return template;
    }

    private static String safe(String value) {
        return value == null ? "" : value;
    }
}

