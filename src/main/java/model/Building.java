package model;

import dao.DataClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity(name = "Buildings")
public class Building implements Serializable, DataClass {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "building_image", joinColumns = {
        @JoinColumn(name = "building_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "image_id",
                        nullable = false, updatable = false)})
    private Set<Image> images = new HashSet<>(0);

    public Building(){
        
    }

    public Building(String name, String phone, String email, String adress) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
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

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
    
    @Override
    public String toString() {
        return "Builidng: {id: " +  id + ", name: " + name + ", phone: " + phone +  ", adress: " + adress +", email: " + email + "}";
    }
   
}
