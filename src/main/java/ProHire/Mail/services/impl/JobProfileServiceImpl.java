package ProHire.Mail.services.impl;

import ProHire.Mail.Repo.JobProfileRepo;
import ProHire.Mail.Repo.UserRepo;
import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.entity.User;
import ProHire.Mail.request.JobProfileRequest;
import ProHire.Mail.services.JobProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobProfileServiceImpl implements JobProfileService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JobProfileRepo jobProfileRepo;

    @Override
    public JobProfile createJobProfile(JobProfileRequest request) {
        // Fetch the User by userId
        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

        // Build JobProfile entity
        JobProfile jobProfile = JobProfile.builder()
                .name(request.getName())
                .jobTitle(request.getJobTitle())
                .role(request.getRole())
                .email(request.getEmail())
                .leetcode(request.getLeetcode())
                .github(request.getGithub())
                .linkedin(request.getLinkedin())
                .resume(request.getResume())
                .portfolio(request.getPortfolio())
                .subject(request.getSubject())
                .description(request.getDescription())
                .resumePath(request.getResumePath())
                .user(user)
                .build();

        // Save and return
        return jobProfileRepo.save(jobProfile);
    }

}
