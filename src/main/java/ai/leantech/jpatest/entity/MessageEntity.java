package ai.leantech.jpatest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity(name = "messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageEntity {
    @Id
    private UUID uid;
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
