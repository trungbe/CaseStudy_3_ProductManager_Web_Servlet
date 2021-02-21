package service;

import java.util.List;

public interface IGenericService<T> {
    List<T>findAll();
    T save (T t);
    T edit(int id,T t);
    T findById(int id);
    void delete(int id);
}
