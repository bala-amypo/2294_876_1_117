public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    Optional<UserAccount> findByUsername(String username);

    List<UserAccount> getAllUsers();   
}
