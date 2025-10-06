package com.fahad.Security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @Column(nullable = false, updatable = false)
    private String roleName;

    @Column
    private String roleDescription;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column
    private OffsetDateTime lastUpdated;
}
