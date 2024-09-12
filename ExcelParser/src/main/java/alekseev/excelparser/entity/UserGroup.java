package alekseev.excelparser.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usergroup")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @OneToMany
    private List<User> users;

}
