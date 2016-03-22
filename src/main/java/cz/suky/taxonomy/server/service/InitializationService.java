package cz.suky.taxonomy.server.service;

import cz.suky.taxonomy.server.entity.*;
import cz.suky.taxonomy.server.repository.ConfigurationRepository;
import cz.suky.taxonomy.server.repository.TaxonRepository;
import cz.suky.taxonomy.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * Created by none_ on 03/13/16.
 */
@Service
public class InitializationService {

    private ConfigurationService configurationService;
    private ConfigurationRepository configurationRepository;
    private UserRepository userRepository;
    private TaxonRepository taxonRepository;

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

    @Autowired
    public void setTaxonService(TaxonRepository taxonRepository) {
        this.taxonRepository = taxonRepository;
    }

    @PostConstruct
    public void initApp() {
        if (isInitialized()) {
            return;
        }

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(Role.ADMIN);

        admin = userRepository.save(admin);

        final Taxon life = new Taxon();
        life.setName("Life");
        life.setCreated(LocalDateTime.now());
        life.setUpdated(LocalDateTime.now());
        life.setCreatedBy(admin);
        life.setUpdatedBy(admin);
        taxonRepository.save(life);

        Configuration initializedConfig = getInitializedConfig();
        initializedConfig.setValue(Boolean.TRUE.toString());
        configurationRepository.saveAndFlush(initializedConfig);
    }

    private boolean isInitialized() {
        try {
            return configurationService.getBoolean(ConfigurationKey.DB_INITIALIZED);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private Configuration getInitializedConfig() {
        Configuration config = configurationRepository.findByKey(ConfigurationKey.DB_INITIALIZED);
        return config != null ? config : new Configuration(ConfigurationKey.DB_INITIALIZED, ConfigurationType.BOOLEAN, Boolean.FALSE.toString());
    }
}
