package spring.tuto.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table (name = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "user";

    public interface createUser {};
    public interface updateUser {};

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column (name = "username", nullable = false, unique = true, length = 100)
    @NotNull (groups = createUser.class)
    @NotEmpty (groups = createUser.class)
    @Size (groups = createUser.class, min = 5, max = 100)
    private String username;

    @JsonProperty (access = Access.WRITE_ONLY)
    @Column (name = "password", nullable = false, length = 30)
    @NotNull (groups = {createUser.class, updateUser.class})
    @NotEmpty  (groups = {createUser.class, updateUser.class})
    @Size  (groups = {createUser.class, updateUser.class}, min = 8, max = 30)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Tasks> tasks = new ArrayList<Tasks>();

    public User() {
    }
    

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tasks> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;

        User other = (User) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
            
        return Objects.equals(this.id, other.id) && 
        Objects.equals(this.username, other.username) &&
        Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}