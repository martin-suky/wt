package cz.suky.taxonomy.server.repository;

import cz.suky.taxonomy.server.entity.Configuration;
import cz.suky.taxonomy.server.entity.ConfigurationKey;
import cz.suky.taxonomy.server.entity.ConfigurationType;

/**
 * Created by none_ on 03/13/16.
 */
public interface ConfigurationRepository extends AbstractEntityRepository<Configuration> {

    Configuration findByKey(ConfigurationKey key);
}
