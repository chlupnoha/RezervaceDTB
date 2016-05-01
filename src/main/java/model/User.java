package model;

import dao_impl.DataClass;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 */
@Entity(name = "Users")
public class User implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    
    
    @NotNull
    @Column(unique = true)
    private String email;
    
    @NotNull
    @Size(min = 6)
    private String password;
    
    @NotNull
    @Size(min = 6)
    private String salt; 
    
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(){
        
    }

    public User(String email, String password, String salt, UserRole role) {
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    @Override
    public String toString() {
        return "id: " +  id + ", email: " + email + ", passwordHash: " + password + ", salt: " + salt;
    }
   
}
