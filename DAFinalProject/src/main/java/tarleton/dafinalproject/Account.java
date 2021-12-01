package tarleton.dafinalproject;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Joe Meier
 */
@XmlRootElement
public class Account {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String tier;

    public Account() {
    }

    public Account(String username, String password, String fname, String lname, String email, String tier) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.tier = tier;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
