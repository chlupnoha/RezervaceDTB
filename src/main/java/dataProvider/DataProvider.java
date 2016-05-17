package dataProvider;

import dao.CommonDAOImpl;
import dao.UserDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserRole;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @author chlupnoha
 */
public class DataProvider {

    private static final Logger LOG = Logger.getLogger(CommonDAOImpl.class.getName());
    
    public void fillDatabase() {
        fillUser(25);
    }
    
    public void fillUser(int count){
        User u1;
        String email;
        UserDAOImpl userDAO = new UserDAOImpl();
        for (int i = 0; i < count; i++) {
            email = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@" + RandomStringUtils.randomAlphanumeric(10).toLowerCase() + ".cz";
            User u = userDAO.getFirstByColumn(User.class, email, "email");
            if (u != null) {
                //cant be same email again 24^30....
                email = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + email;
            }
            u1 = new User(email,
                    RandomStringUtils.randomAlphanumeric(14).toLowerCase(),
                    UserRole.GUEST);
            userDAO.add(u1);
        }
        
    }

}
