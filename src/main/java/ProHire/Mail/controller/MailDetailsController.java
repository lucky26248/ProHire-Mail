package ProHire.Mail.controller;

import ProHire.Mail.entity.MailDetails;
import ProHire.Mail.request.MailDetailsRequest;
import ProHire.Mail.services.DeleteService;
import ProHire.Mail.services.MailDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maildetails")
public class MailDetailsController {

    @Autowired
    private MailDetailsService mailDetailsService;

    @Autowired
    private DeleteService deleteService;

    @PostMapping
    public ResponseEntity<MailDetails> createMailDetails(@RequestBody MailDetailsRequest mailDetailsRequest){
        MailDetails createdMailDetails = mailDetailsService.createMailDetails(mailDetailsRequest);
        return new ResponseEntity<>(createdMailDetails , HttpStatus.CREATED);
    }

    @DeleteMapping("/{mailId}")
    public ResponseEntity<HttpStatus> deleteMailDetails(@PathVariable long mailId){
        deleteService.deleteMailDetails(mailId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
