package Mysweetsystem2024;

public class Admin {
	
	private UserRepositry userRepository;

    public Admin(UserRepositry userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String username, String email) {
        User user = new User(username, email);
        return userRepository.addUser(user);
    }

   // public User viewUser(String username) {
     //   return userRepository.getUser(username);
    //}

    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(String username) {
        return userRepository.deleteUser(username);
    }
}
