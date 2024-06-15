package spring.tuto.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table (name = Tasks.TABLE_NAME)
public class Tasks {
    public static final String TABLE_NAME = "tasks";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Integer id;
    
    @ManyToOne
    @JoinColumn (name = "user_id", updatable = false)
    private User user;

    @Column (name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size (max = 255)
    private String description;


    public Tasks() {
    }


    public Tasks(Integer id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Tasks))
            return false;

        Tasks other = (Tasks) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
            
        return Objects.equals(this.id, other.id) && 
        Objects.equals(this.user, other.user) &&
        Objects.equals(this.description, other.description);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    
}