package ai.leantech.jpatest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleEntity {
    @Id
    private UUID uid;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "roles_uid"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<UserEntity> users;
}
