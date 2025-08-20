package GestorePassword;
import java.io.Serializable;

public class dati implements Serializable {
    private String servizio;
    private String email;
    private String password;

    public dati(String servizio, String email, String password) {
        this.servizio = servizio;
        this.email = email;
        this.password = password;
    }
    
    private static final long serialVersionUID = 1L;
    
    public String getServizio() { return servizio; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}

