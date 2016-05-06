/*
 * Copyright (C) 2015 Ondřej Skoumal <skoumal.ondra@gmail.com>
 *
 */
package dao;

/**
 * Data class stored in database with integer ID
 */
public interface DataClass {

    Long getId();

    void setId(Long id);
}