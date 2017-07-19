package by.itacad.dao.common;

import by.itacad.entities.BaseEntity;

import java.util.List;

/**
 * Created by Radion on 20.06.2017.
 */
public interface BaseDao <T extends BaseEntity> {

    Long save(T entity);

    T findById(Long id);

    void deleteById(Long id);

    void delete(T entity);

    List<T> findAll();

    Long update(T entity);

}
