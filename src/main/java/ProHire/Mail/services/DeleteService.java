package ProHire.Mail.services;

public interface DeleteService {
    void deleteUser(String username);
    void deleteMailDetails(Long mailId);
    void deleteSenderMailDetails(Long senderMailId);
    void deleteJobProfile(Long profileId);
}
