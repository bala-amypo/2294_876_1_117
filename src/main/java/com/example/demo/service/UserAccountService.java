import java.util.Optional;

public interface UserAccountService {
    Optional<UserAccount> findByEmail(String email);
    
    // Keep other methods as they are
}
