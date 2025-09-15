package ProHire.Mail.controller;

import ProHire.Mail.entity.JobProfile;
import ProHire.Mail.request.JobProfileRequest;
import ProHire.Mail.services.DeleteService;
import ProHire.Mail.services.JobProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobprofile")
public class JobProfileController {

    @Autowired
    private JobProfileService jobProfileService;

    @Autowired
    private DeleteService deleteService;

    @PostMapping
    public ResponseEntity<JobProfile> createJobProfile(@RequestBody JobProfileRequest jobProfileRequest){
        JobProfile createdJobProfile = jobProfileService.createJobProfile(jobProfileRequest);
        return new ResponseEntity<>(createdJobProfile , HttpStatus.CREATED);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<HttpStatus> deleteJobProfile(@PathVariable long profileId) {
        deleteService.deleteJobProfile(profileId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
