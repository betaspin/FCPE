package fr.imie.fcpe;

import java.util.List;

public interface ICRUD<T> {
    T findOne(Integer id);
    List<T> findAll();
    T create(T data);
    T update(T data);
    T delete(Integer id);
}
