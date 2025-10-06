package com.fahad.Security.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @Column(nullable = false, updatable = false)
    private String userName;

    @Column
    private String userFirstName;

    @Column
    private String userLastName;

    @Column
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private Boolean enabled;

    private Boolean credentialsNonExpired;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Role> roles;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User() {}

    @PrePersist
    void createdAt() {this.dateCreated = this.lastUpdated = OffsetDateTime.now();}

    @PreUpdate
    void updatedAt() {this.lastUpdated = OffsetDateTime.now();}
}
