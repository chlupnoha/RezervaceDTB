package utility;

import dao.UserDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author chlupnoha
 */
public class Authorization {

    public User authorization(String email, String password) throws Exception {
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
        if(hashedPassword != userByEmail.getPassword()){
            throw new Exception("Incorrect password");
        }
        return userByEmail;
    }

}
