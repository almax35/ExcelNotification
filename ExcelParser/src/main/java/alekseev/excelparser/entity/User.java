package alekseev.excelparser.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    @ManyToOne
    @JoinColumn(name = "usergroup_id")
    private UserGroup userGroup;
}

