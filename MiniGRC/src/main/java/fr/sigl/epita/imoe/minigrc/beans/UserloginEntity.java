package fr.sigl.epita.imoe.minigrc.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Chaf on 12/27/2015.
 */
@Entity
@Table(name = "userlogin", schema = "public", catalog = "minigrc")
public class UserloginEntity implements Serializable {
    private int userId;
    private String userLogin;
    private String userPassword;
    private Date userLastconnexion;
    private String userRegion;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userlogin_user_id_seq")
    @SequenceGenerator(name="userlogin_user_id_seq", sequenceName="userlogin_user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_login")
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_lastconnexion")
    public Date getUserLastconnexion() {
        return userLastconnexion;
    }

    public void setUserLastconnexion(Date userLastconnexion) {
        this.userLastconnexion = userLastconnexion;
    }

    @Basic
    @Column(name = "user_region")
    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserloginEntity that = (UserloginEntity) o;

        if (userId != that.userId) return false;
        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userLastconnexion != null ? !userLastconnexion.equals(that.userLastconnexion) : that.userLastconnexion != null)
            return false;
        if (userRegion != null ? !userRegion.equals((that.userRegion)) : that.userRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userLastconnexion != null ? userLastconnexion.hashCode() : 0);
        result = 32 * result + (userRegion != null ? userRegion.hashCode() : 0);
        return result;
    }
}
