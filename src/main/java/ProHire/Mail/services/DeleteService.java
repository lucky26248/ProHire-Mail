package ProHire.Mail.services;

public interface DeleteService {
    void deleteMailDetails(Long mailId);
    void deleteSenderMailDetails(Long senderMailId);
    void deleteJobProfile(Long profileId);
}
