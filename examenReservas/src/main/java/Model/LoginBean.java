package Model;

import java.io.Serializable;
import java.util.List;

public class LoginBean implements Serializable {
    private String usuario;
    private String password;
    private String password2;
    private String email;

    public LoginBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
