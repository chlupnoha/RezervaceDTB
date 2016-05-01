/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.UserDAO;
import model.User;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class UserDAOImpl extends CommonDAOImpl<User> implements UserDAO {

    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class.getName());

    public UserDAOImpl() {
        this(null);
    }

    public UserDAOImpl(Session session) {
        super(User.class, session);
    }
    
    @Override
    public User getUserByID(Integer userId) {
        return super.getEntityById(userId);
    }

    @Override
    public User addUser(User user) {
        return super.addEntity(user);
    }

    @Override
    public User updateUser(User user) {
        return super.updateEntity(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return super.deleteEntity(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return super.getAllEntities();
    }

    
}
