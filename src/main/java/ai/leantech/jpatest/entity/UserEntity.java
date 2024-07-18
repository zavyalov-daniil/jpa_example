package ai.leantech.jpatest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    private Integer id;
    private String name;
    private LocalDateTime birth;
    private Instant expiration;
    @OneToMany(mappedBy = "user")
    private Set<MessageEntity> messages;
    @ManyToMany(mappedBy = "users")
    private Set<RoleEntity> roles = new HashSet<>();
}