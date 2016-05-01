/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.User;
import java.util.List;

/**
 * Data Acces Object 
 */
public interface UserDAO {
    
    User getUserByID(Integer userId);

    User addUser(User user);

    User updateUser(User user);

    boolean deleteUser(int userId);
    
    List<User> getAllUsers();

}
