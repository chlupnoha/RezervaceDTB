/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import model.Image;
import org.hibernate.Session;

import java.util.logging.Logger;

/**
 * @author chlupnoha
 */
public class ImageDAOImpl extends CommonDAOImpl<Image> {

    private static final Logger LOG = Logger.getLogger(ImageDAOImpl.class.getName());

    public ImageDAOImpl() {
        this(null);
    }

    public ImageDAOImpl(Session session) {
        super(Image.class, session);
    }


}
