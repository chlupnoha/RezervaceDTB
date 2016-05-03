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
@Entity(name = "Buildings")
public class Building implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    
    
    @NotNull
    @Column(unique = true)
    @Size(min = 3, max = 255)
    private String name;
    
    @NotNull
    @Size(min = 9, max = 9)
    private String phone;
    
    @NotNull
    private String email; 
    
    @NotNull
    private String adress; 

    public Building(){
        
    }

    public Building(String name, String phone, String email, String adress) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    @Override
    public String toString() {
        return "Builidng: {id: " +  id + ", name: " + name + ", phone: " + phone +  ", adress: " + adress +", email: " + email + "}";
    }
   
}
