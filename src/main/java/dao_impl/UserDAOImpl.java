/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import model.User;
import org.hibernate.Session;

import java.util.logging.Logger;

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

}
