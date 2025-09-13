package ProHire.Mail.services;

import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.request.JobProfileRequest;

public interface JobProfileService {
    JobProfile createJobProfile(JobProfileRequest jobProfileRequest);
}
