package studentplatform.student_platform.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {

    @Id
    private long id;

    @NotBlank(message="name cant be empty")
    private String name;

    @Email(message="email not empty")
    private String email;

    @NotBlank(message="passowrd cant be empty")
    private String pass;

    // Getter & Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter & Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter & Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter & Setter for pass
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
