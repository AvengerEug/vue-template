package com.eugene.sso.dao;

import java.util.List;

public interface BaseDAO<T, K> {

    T create(T entity);

    T update(T entity);

    List<T> getAll();

    T getById(K id);

    void delete(K id);
}
