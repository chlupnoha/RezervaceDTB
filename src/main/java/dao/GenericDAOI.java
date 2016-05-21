package dao;

import java.util.List;

/**
 * Created by marek on 6.5.16.
 */
public interface GenericDAOI<T> {

    T add(T entity);

    T getById(Long Id);

    T getFirstByColumn(Class<T> clazz, String value, String columnName);

    List<T> getAllByColumn(Class<T> clazz, String value, String columnName);

    List<T> getAll();

    T update(T entity);

    boolean delete(Long Id);

}