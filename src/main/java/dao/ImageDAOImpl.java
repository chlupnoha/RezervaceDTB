package dao;

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
