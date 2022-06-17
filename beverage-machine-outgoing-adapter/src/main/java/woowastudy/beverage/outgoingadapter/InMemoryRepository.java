package woowastudy.beverage.outgoingadapter;

import woowastudy.beverage.domain.entity.NumberIdentifiableEntity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class InMemoryRepository<E extends NumberIdentifiableEntity<ID>, ID extends Number> {
    protected final List<E> entities = new ArrayList<>();
    protected final Map<ID, E> entitiesLookUpMap = new HashMap<>();

    protected final void saveInMemory(E entity) {
        entities.add(entity);
        entitiesLookUpMap.put(entity.getId(), entity);
    }

    protected final Optional<E> findByIdInMemory(ID id) {
        if(isNotExistByIdInMemory(id)) {
            return Optional.empty();
        }

        return Optional.of(entitiesLookUpMap.get(id));
    }

    protected final List<E> findAllInMemory() {
        return entities;
    }

    protected final List<E> findAllByIdsInMemory(Collection<ID> ids) {
        return ids.stream()
                .map(this::findByIdInMemory)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    protected final boolean isNotExistByIdInMemory(ID id) {
        return !entitiesLookUpMap.containsKey(id);
    }
}
