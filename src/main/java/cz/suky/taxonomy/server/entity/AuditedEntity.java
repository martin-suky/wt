package cz.suky.taxonomy.server.entity;

import java.time.LocalDateTime;

/**
 * Created by none_ on 03/13/16.
 */
public class AuditedEntity extends AbstractEntity {
    private User createdBy;

    private User updatedBy;

    private LocalDateTime created;

    private LocalDateTime updated;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
