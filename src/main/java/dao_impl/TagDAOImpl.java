/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.TagDAO;
import java.util.List;
import java.util.logging.Logger;
import model.Tag;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class TagDAOImpl extends CommonDAOImpl<Tag> implements TagDAO {

    private static final Logger LOG = Logger.getLogger(TagDAOImpl.class.getName());

    public TagDAOImpl() {
        this(null);
    }

    public TagDAOImpl(Session session) {
        super(Tag.class, session);
    }

    @Override
    public Tag getTagByID(Integer tagId) {
        return super.getEntityById(tagId);
    }

    @Override
    public Tag addTag(Tag tag) {
        return super.addEntity(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        return super.updateEntity(tag);
    }

    @Override
    public boolean deleteTag(int tagId) {
        return super.deleteEntity(tagId);
    }

    @Override
    public List<Tag> getAllTags() {
        return super.getAllEntities();
    }
    

    
}
