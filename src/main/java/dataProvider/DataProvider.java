package dataProvider;

import dao.UserDAOImpl;
import model.User;
import model.UserRole;

/**
 * @author chlupnoha
 */
public class DataProvider {

    public void fillDatabase() {
        User u1 = new User("email1@email.cz", "password", "saltsalt", UserRole.GUEST);

        UserDAOImpl userDAO = new UserDAOImpl();

        userDAO.add(u1);

    }

}
