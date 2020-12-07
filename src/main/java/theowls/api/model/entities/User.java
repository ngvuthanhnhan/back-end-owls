package theowls.api.model.entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long    id;
    String  username;
    String  password;
    Long    phoneNum;
    String  email;

    public User() {}

    public User(String username, String password, Long phoneNum, String email) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}