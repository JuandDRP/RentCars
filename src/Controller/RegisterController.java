
package Controller;


import static Controller.LoginController.login;
import static Controller.LoginController.users;
import Model.UserDataBase;
import View.RegisterView;
import java.util.ArrayList;

/**
 *
 * @author Krsna Gutierrez
 */
public class RegisterController {
    public static RegisterView register =new RegisterView();
    public static ArrayList<UserDataBase> users = new ArrayList<UserDataBase>();
    public static void show(){register.setVisible(true);}
    public static void hidden(){register.setVisible(false);}
    
    
    
    public static void addUser(){
        String username=register.getjTextField1().getText();
        String password=register.getjPasswordField1().getText();
        String name=register.getjTextField5().getText();
        int contactNumber=Integer.parseInt(register.getjTextField3().getText());
        int cedula=Integer.parseInt(register.getjTextField4().getText());
        
        if(username.length()>0 && password.length()>0 && name.length()>0 && contactNumber !=0 && cedula !=0){
            UserDataBase uD=new UserDataBase(username,name,password, contactNumber,cedula);
//            User u=new User(username,password);
            users.add(uD);
            boolean add=DataBase.agregarUser(uD);
        if(add){
            hidden();
            LoginController.show();
            
            
        }
        
    }else{
            login.getjLabel3().setText("*NO SE AÑADIO USUARIO*");
        }
    }
    
}
