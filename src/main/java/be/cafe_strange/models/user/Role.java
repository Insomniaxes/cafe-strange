package be.cafe_strange.models.user;

import be.cafe_strange.enums.AuthorizationRole;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "role")
    private AuthorizationRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorizationRole getRole() {
        return role;
    }

    public void setRole(AuthorizationRole role) {
        this.role = role;
    }
}
