package ProHire.Mail.controller;

import ProHire.Mail.utils.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail-send")
public class MailSendController {

    @Autowired
    private MailService mailService;

    @GetMapping
    public ResponseEntity<HttpStatus> executeAllMail(){
        mailService.executeMailSendingEachUser();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
