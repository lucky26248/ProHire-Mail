package ProHire.Mail.Repo;

import ProHire.Mail.entity.SenderMailDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderMailDetailsRepo extends JpaRepository<SenderMailDetails , Long> {
}
