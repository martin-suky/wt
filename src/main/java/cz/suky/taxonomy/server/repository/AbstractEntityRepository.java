package cz.suky.taxonomy.server.repository;

import cz.suky.taxonomy.server.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by none_ on 03/13/16.
 */
public interface AbstractEntityRepository<Entity extends AbstractEntity> extends JpaRepository<Entity, Long> {
}
