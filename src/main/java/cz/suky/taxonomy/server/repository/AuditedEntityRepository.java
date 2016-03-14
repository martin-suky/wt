package cz.suky.taxonomy.server.repository;

import cz.suky.taxonomy.server.entity.AuditedEntity;

/**
 * Created by none_ on 03/14/16.
 */
public interface AuditedEntityRepository<Entity extends AuditedEntity> extends AbstractEntityRepository<Entity> {
}
