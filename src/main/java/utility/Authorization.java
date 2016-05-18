package utility;

import dao.UserDAOImpl;
import model.User;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class Authorization {

    private static User userByEmail;


    private Authorization() {
    }


    public static User getUser() {
        return userByEmail;
    }

    public static User login(String email, String password) throws Exception {
        UserDAOImpl userDAO = new UserDAOImpl();
        User userByEmail = userDAO.getFirstByColumn(User.class, email, "email");
        if (userByEmail == null) {
            try {
                throw new Exception("Email not found.");
            } catch (Exception ex) {
                Logger.getLogger(Authorization.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String hashedPassword = SSHHashing.createHash(userByEmail.getSalt() + password);
        if (!hashedPassword.equals(userByEmail.getPassword())) {
            throw new Exception("Incorrect password");
        }
        Authorization.userByEmail = userByEmail;
        return userByEmail;
    }

    public static void updateUser(User user) {
        Authorization.userByEmail = user;
    }

    public static User refreshUser() {
        return Authorization.userByEmail = new UserDAOImpl().getById(userByEmail.getId());
    }

}
