package fr.eni.encheres.dal;

import java.util.List;

public interface DAO<T> {

    void insert(T object);

    T selectById(int id);

    List<T> selectAll();

    void update(T object);

    void delete(T object);
}
