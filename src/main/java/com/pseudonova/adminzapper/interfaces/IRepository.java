package com.pseudonova.adminzapper.interfaces;

public interface IRepository<K, V>{

    void addOrUpdate(K key, V value);
    void remove(K key);
    V get(K key);
    boolean exists(K key);

}
