/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Tag;
import org.hibernate.Session;

import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class TagDAOImpl extends CommonDAOImpl<Tag> {

    private static final Logger LOG = Logger.getLogger(TagDAOImpl.class.getName());

    public TagDAOImpl() {
        this(null);
    }

    public TagDAOImpl(Session session) {
        super(Tag.class, session);
    }


}
