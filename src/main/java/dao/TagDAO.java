/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

import model.Tag;
import java.util.List;

/**
 * Data Acces Object 
 */
public interface TagDAO {
    
    Tag getTagByID(Integer tagId);

    Tag addTag(Tag tag);

    Tag updateTag(Tag tag);

    boolean deleteTag(int tagId);
    
    List<Tag> getAllTags();

}
