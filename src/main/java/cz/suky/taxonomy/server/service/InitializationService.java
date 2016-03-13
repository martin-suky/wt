package cz.suky.taxonomy.server.service;

import cz.suky.taxonomy.server.entity.*;
import cz.suky.taxonomy.server.repository.ConfigurationRepository;
import cz.suky.taxonomy.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

/**
 * Created by none_ on 03/13/16.
 */
@Service
public class InitializationService {

    private ConfigurationService configurationService;
    private ConfigurationRepository configurationRepository;
    private UserRepository userRepository;

    @Autowired
    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @Autowired
    public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initApp() {
         if (isInitialized()) {
             return;
         }

        final User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(Role.ADMIN);

        userRepository.save(admin);

        Configuration initializedConfig = getInitializedConfig();
        initializedConfig.setValue(Boolean.TRUE.toString());
        configurationRepository.saveAndFlush(initializedConfig);
    }

    private boolean isInitialized() {
        try {
            return configurationService.getBoolean(ConfigurationKey.DB_INITIALIZED);
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    private Configuration getInitializedConfig() {
        try {
            return configurationRepository.findByKey(ConfigurationKey.DB_INITIALIZED);
        } catch (EntityNotFoundException e) {
            return new Configuration(ConfigurationKey.DB_INITIALIZED, ConfigurationType.BOOLEAN, Boolean.FALSE.toString());
        }
    }
}
