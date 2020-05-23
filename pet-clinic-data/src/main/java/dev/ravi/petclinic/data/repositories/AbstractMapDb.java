package dev.ravi.petclinic.data.repositories;

import dev.ravi.petclinic.data.models.BaseEntity;
import java.util.*;

public abstract class AbstractMapDb<Key extends Long, Entity extends BaseEntity> {

    private final Map<Key,Entity> map = new HashMap<>();
    private Long maxKeyAssigned = Long.valueOf(0L);

    public List<Entity> findAll() {
        List<Entity> valueSet = new ArrayList<>();
        valueSet.addAll(map.values());
        return valueSet;
    }

    public Entity findById(Key key) {
        if (map.keySet().contains(key))
            return  map.get(key);
        else {
            throw new RuntimeException("Key Not Found");
        }
    }

    public Entity save(Entity entity) {
        Long nextId = (Long) maxKeyAssigned + 1L;
        if (entity.getId() == null) {
            entity.setId(nextId);
        }
        map.put((Key) entity.getId(), entity);
        maxKeyAssigned = entity.getId();
        return entity;
    }

    public void delete(Entity entity) {
        map.keySet().removeIf(k -> entity.getId().equals(k)) ;
    }

    public void deleteById(Long id) {
        map.remove(id);
    }

}
