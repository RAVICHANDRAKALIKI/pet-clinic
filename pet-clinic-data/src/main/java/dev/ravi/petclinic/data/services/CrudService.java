package dev.ravi.petclinic.data.services;

import java.util.List;

public interface CrudService<K, V> {
    V findById(K k);

    V save(V v);

    List<V> findAll();

    void delete(V v) ;

    void deleteById(K k);
}
