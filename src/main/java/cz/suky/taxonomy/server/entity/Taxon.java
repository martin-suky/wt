package cz.suky.taxonomy.server.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by none_ on 03/13/16.
 */
@Entity
public class Taxon extends AuditedEntity {

    private String name;

    @ManyToOne
    private Taxon parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Taxon getParent() {
        return parent;
    }

    public void setParent(Taxon parent) {
        this.parent = parent;
    }
}
