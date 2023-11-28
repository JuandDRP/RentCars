
package Model;

/**
 *
 * @author JUAN RODRIGUEZ
 */
public class UserDataBase {
        String username;
        String name;
        String password;
        int contacNumber;
        int cedula;

    public UserDataBase(String username, String name, String password, int contacNumber, int cedula) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.contacNumber = contacNumber;
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContacNumber() {
        return contacNumber;
    }

    public void setContacNumber(int contacNumber) {
        this.contacNumber = contacNumber;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "UserDataBase{" + "username=" + username + ", name=" + name + ", password=" + password + ", contacNumber=" + contacNumber + ", cedula=" + cedula + '}';
    }
        
        
        
}
