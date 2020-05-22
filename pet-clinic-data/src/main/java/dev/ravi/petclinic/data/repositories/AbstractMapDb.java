package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapDb<Long, Entity> implements CrudService<Long, Entity> {

    private final Map<Long,Entity> map = new HashMap<>();

    public List<Entity> findAll() {
        List<Entity> valueSet = new ArrayList<>();
        valueSet.addAll(map.values());
        return valueSet;
    }

    public Entity findById(Long key) {
        return  map.get(key);
    }

    public Entity save(Entity entity) {
        BaseEntity baseEntity = (BaseEntity) entity;
        map.put((Long) baseEntity.getId(), entity);
        return entity;
    }

    public void delete(Entity entity) {
        BaseEntity baseEntity = (BaseEntity) entity;
        map.keySet().removeIf(k -> baseEntity.getId().equals(k)) ;
    }

    public void deleteById(Long id) {
        map.remove(id);
    }

}
