package dataProvider;

import dao.UserDAOImpl;
import model.User;
import model.UserRole;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @author chlupnoha
 */
public class DataProvider {

    public void fillDatabase() {
        User u1 = null;
        UserDAOImpl userDAO = new UserDAOImpl();
        for (int i = 0; i < 25; i++) {
            u1 = new User(RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@" + RandomStringUtils.randomAlphanumeric(10).toLowerCase() + ".cz",
                    RandomStringUtils.randomAlphanumeric(14).toLowerCase(),
                    UserRole.GUEST);
            try{
                userDAO.add(u1);
            }catch(Exception e){
                
            }
        }
    }

}
