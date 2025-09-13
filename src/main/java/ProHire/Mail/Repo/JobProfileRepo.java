package ProHire.Mail.Repo;

import ProHire.Mail.entity.JobProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobProfileRepo extends JpaRepository<JobProfile , Long> {
}
