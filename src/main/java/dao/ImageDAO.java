/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Image;
import java.util.List;

/**
 * Data Access Object 
 */
public interface ImageDAO {
    
    Image getImageByID(Integer imageId);

    Image addImage(Image image);

    Image updateImage(Image image);

    boolean deleteImage(int imageId);
    
    List<Image> getAllImages();

}
