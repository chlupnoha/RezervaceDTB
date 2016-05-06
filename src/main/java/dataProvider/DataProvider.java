

package dataProvider;

import dao_impl.UserDAOImpl;
import model.User;
import model.UserRole;

/**
 *
 * @author chlupnoha
 */
public class DataProvider {

    public void fillDatabase(){
        User u1 = new User("email1@email.cz", "password", "saltsalt", UserRole.GUEST);
        
        UserDAO userDao = new UserDAOImpl();
        
        userDao.addUser(u1);
        
    }
    
}
