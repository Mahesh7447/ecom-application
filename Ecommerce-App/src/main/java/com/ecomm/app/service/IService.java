package com.ecomm.app.service;

import com.ecomm.app.exception.ProductNotFoundException;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    public T findById(long id) throws ProductNotFoundException;
    public boolean save(T t);
    public boolean delete(long id) throws ProductNotFoundException;
    //public boolean update(T t,long id);
}
