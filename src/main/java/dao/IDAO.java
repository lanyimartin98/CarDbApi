package dao;

import exceptions.AnotherFound;
import exceptions.NotFound;

import java.util.Collection;

public interface IDAO<T> {
    void addData(T data) throws AnotherFound, NotFound;
    T getDataByID(java.lang.String id) throws NotFound;
    Collection<T> getAllData();
    void deleteByID(java.lang.String id);
}
