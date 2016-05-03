/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

import dao.EquipmentDAO;
import dao.ImageDAO;
import java.util.List;
import java.util.logging.Logger;
import model.Equipment;
import model.Image;
import org.hibernate.Session;

/**
 *
 * @author chlupnoha
 */
public class ImageDAOImpl extends CommonDAOImpl<Image> implements ImageDAO {

    private static final Logger LOG = Logger.getLogger(ImageDAOImpl.class.getName());

    public ImageDAOImpl() {
        this(null);
    }

    public ImageDAOImpl(Session session) {
        super(Image.class, session);
    }

    @Override
    public Image getImageByID(Integer imageId) {
        return super.getEntityById(imageId);
    }

    @Override
    public Image addImage(Image image) {
        return super.addEntity(image);
    }

    @Override
    public Image updateImage(Image image) {
        return super.updateEntity(image);
    }

    @Override
    public boolean deleteImage(int imageId) {
        return super.deleteEntity(imageId);
    }

    @Override
    public List<Image> getAllImages() {
        return super.getAllEntities();
    }
    
    
    
}
