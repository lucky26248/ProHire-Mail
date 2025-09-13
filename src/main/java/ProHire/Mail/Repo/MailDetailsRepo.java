package ProHire.Mail.Repo;

import ProHire.Mail.entity.MailDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDetailsRepo extends JpaRepository<MailDetails , Long> {
}
