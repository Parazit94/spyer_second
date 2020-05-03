package ru.spy.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "users",
        indexes = {
                @Index(name = "spyer_users_login", columnList = "login", unique = true),
                @Index(name = "spyer_users_email", columnList = "email", unique = true)
        }
)
@SQLDelete(sql = "UPDATE users SET active = false, modified = current_timestamp WHERE id = ?", check = ResultCheckStyle.COUNT)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSeqGenerator")
    @SequenceGenerator(name = "usersSeqGenerator", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pass", nullable = false)
    private String password;
}
