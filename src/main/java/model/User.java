package model;


import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

import static model.User.TABLE_NAME;
import static model.User.USER_ENUM_NAME;

@Entity
@Table(name = TABLE_NAME)
@TypeDef(
        name = USER_ENUM_NAME,
        typeClass = EnumType.class
)
public class User {

    public enum UserRole{
        USER, ADMIN
    }

    public static final String TABLE_NAME = "users";
    public static final String USER_ENUM_NAME = "user_type";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String LOGIN_COLUMN = "login";
    private static final String PASSWORD_COLUMN = "password";
    private static final String EMAIL_COLUMN = "email";
    private static final String PROTO_URL_COLUMN = "photo_path";
    private static final String ROLE_COLUMN = "role";
    private static final String IS_ACTIVE_COLUMN = "is_active";
    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGHT = 15;

    @Id
    @NotNull
    @Column(name = ID_COLUMN, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;

    @Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGHT)
    @Column(name = NAME_COLUMN)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10)
    @Column(name = LOGIN_COLUMN, unique = true)
    private String login;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 17)
    @Column(name = PASSWORD_COLUMN)
    private String password;

    @NotNull
    @Email
    @Column(name = EMAIL_COLUMN)
    private String email;

    @Column(name = PROTO_URL_COLUMN)
    private String photoURL;

    @NotNull
    @Column(name = ROLE_COLUMN)
    @Enumerated(EnumType.STRING)
    @Type(type = USER_ENUM_NAME)
    private UserRole role;

    @Column(name = IS_ACTIVE_COLUMN)
    private boolean active;

//    @OneToMany
//    @JoinColumn
//    private List<Post> posts;

    public User() {
    }

    public User(@Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGHT) String name, @NotNull @NotBlank @Size(min = 3, max = 10) String login, @NotNull @NotBlank @Size(min = 6, max = 17) String password, @NotNull @Email String email, String photoURL, @NotNull UserRole role, boolean active) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.photoURL = photoURL;
        this.role = role;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
