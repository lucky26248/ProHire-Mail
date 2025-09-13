package ProHire.Mail.controller;

import ProHire.Mail.entity.SenderMailDetails;
import ProHire.Mail.request.SenderMailRequest;
import ProHire.Mail.services.DeleteService;
import ProHire.Mail.services.SenderMailDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendermail")
public class SenderMailDetailsController {

    @Autowired
    private SenderMailDetailsService senderMailDetailsService;

    @Autowired
    private DeleteService deleteService;

    @PostMapping
    public ResponseEntity<SenderMailDetails> createSenderMailDetails(@RequestBody SenderMailRequest senderMailRequest){
        SenderMailDetails createdSenderMailDetails = senderMailDetailsService.createSenderMailDetails(senderMailRequest);
        return new ResponseEntity<>(createdSenderMailDetails , HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteSenderMailDetails(@RequestParam long senderMailId){
        deleteService.deleteSenderMailDetails(senderMailId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
