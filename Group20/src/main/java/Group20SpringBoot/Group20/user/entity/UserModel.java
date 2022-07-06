package Group20SpringBoot.Group20.user.entity;

import javax.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false, length = 10)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, unique = true, length = 25)
    private String emailId;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false,length = 30 )
    private String secretKey;

    public UserModel(String firstName, String lastName, String emailId, String password, String secretKey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.secretKey = secretKey;
    }

    public UserModel(){

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecretKey(String secretKeyAns) {
        this.secretKey = secretKeyAns;
    }

    public String getSecretKey() {
        return secretKey;
    }



}
