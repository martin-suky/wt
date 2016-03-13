package cz.suky.taxonomy.server.service;

import cz.suky.taxonomy.server.entity.Configuration;
import cz.suky.taxonomy.server.entity.ConfigurationKey;
import cz.suky.taxonomy.server.entity.ConfigurationType;
import cz.suky.taxonomy.server.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.dom.exception.InvalidStateException;

/**
 * Created by none_ on 03/13/16.
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private ConfigurationRepository configurationRepository;

    @Autowired
    public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Override
    public String getString(ConfigurationKey configurationKey) {
        return findAndCastConfig(configurationKey, ConfigurationType.STRING);
    }

    @Override
    public boolean getBoolean(ConfigurationKey configurationKey) {
        return findAndCastConfig(configurationKey, ConfigurationType.BOOLEAN);
    }

    @Override
    public int getInteger(ConfigurationKey configurationKey) {
        return findAndCastConfig(configurationKey, ConfigurationType.INTEGER);
    }

    private <T extends Object> T findAndCastConfig(ConfigurationKey key, ConfigurationType type) {
        Configuration config = configurationRepository.findByKey(key);
        if (!type.equals(config.getType())) {
            throw new IllegalArgumentException("Invalid Type: for key=" + config.getKey() + " expected=" + type + " actual=" +config.getType());
        }

        switch (config.getType()) {
            case STRING:
                return (T) config.getValue();
            case BOOLEAN:
                return (T) Boolean.valueOf(config.getValue());
            case INTEGER:
                return (T) Integer.valueOf(config.getValue());
            default:
                throw new InvalidStateException("Type " + config.getType() + " not supported.");
        }
    }
}
