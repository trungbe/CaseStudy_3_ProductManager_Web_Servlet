package service;

import java.util.List;

public interface IGenericService<T> {
    List<T>findAll();
    T save (T t);
    boolean edit(T t);
    T findById(int id);
    boolean delete(int id);
}
