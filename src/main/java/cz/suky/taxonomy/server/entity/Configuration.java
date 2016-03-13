package cz.suky.taxonomy.server.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by none_ on 03/13/16.
 */
@Entity
public class Configuration extends AbstractEntity {

    private Configuration() {
    }

    public Configuration(ConfigurationKey key, ConfigurationType type, String value) {
        this.key = key;
        this.type = type;
        this.value = value;
    }

    @Enumerated(EnumType.STRING)
    private ConfigurationKey key;

    @Enumerated(EnumType.STRING)
    private ConfigurationType type;

    private String value;

    public ConfigurationKey getKey() {
        return key;
    }

    public void setKey(ConfigurationKey key) {
        this.key = key;
    }

    public ConfigurationType getType() {
        return type;
    }

    public void setType(ConfigurationType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
