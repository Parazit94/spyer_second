package ru.spy.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.spy.model.base.ActiveType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(exclude = "active")
public class BaseEntity {

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @Column(name = "active", nullable = false)
    private ActiveType active;

    @PrePersist
    private void onCreate() {
        LocalDateTime current = LocalDateTime.now();
        created = current;
        modified = current;
        active = ActiveType.ENABLED;
    }

    @PreUpdate
    private void onUpdate() {
        modified = LocalDateTime.now();
    }

    @PreRemove
    private void onDelete() {
        modified = LocalDateTime.now();
        active = ActiveType.DISABLED;
    }
}