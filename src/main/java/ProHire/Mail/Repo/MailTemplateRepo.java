package ProHire.Mail.Repo;

import ProHire.Mail.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailTemplateRepo extends JpaRepository<MailTemplate , Integer> {

}
