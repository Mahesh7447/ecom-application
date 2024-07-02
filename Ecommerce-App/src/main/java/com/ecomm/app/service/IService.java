package com.ecomm.app.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    public T findById(long id);
    public boolean save(T t);
    public boolean delete(long id);
    //public boolean update(T t,long id);
}
