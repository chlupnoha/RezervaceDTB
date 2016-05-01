/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao_impl;

/**
 * Data class stored in database with integer ID
 *
 */
public interface DataClass {

    Integer getId();

    void setId(Integer id);
}
