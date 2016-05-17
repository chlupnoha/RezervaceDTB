/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.User;
import org.hibernate.Session;

import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import utility.SSHHashing;

/**
 * @author chlupnoha
 */
public class UserDAOImpl extends CommonDAOImpl<User> {

    private static final Logger LOG = Logger.getLogger(UserDAOImpl.class.getName());

    public UserDAOImpl() {
        this(null);
    }

    public UserDAOImpl(Session session) {
        super(User.class, session);
    }
    
    @Override
    public User add(User user){
        String salt = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        user.setSalt(salt);
        user.setPassword(SSHHashing.createHash(user.getPassword()+salt));
        return super.add(user);
    }    
}
