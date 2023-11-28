
package Controller;

import Model.UserDataBase;
import View.LoginView;
import View.RegisterView;
import java.util.ArrayList;

/*
 * @author JUAN RODRIGUEZ
 */
public class LoginController {
    public static ArrayList<UserDataBase> users = new ArrayList<UserDataBase>();
    public static DataBase bd = new DataBase();
    public static LoginView login =new LoginView();
    public static RegisterView register=new RegisterView();
    public static void show(){login.setVisible(true);}
    public static void hidden(){login.setVisible(false);}
    
    
    public static String saveData(){
//        ArrayList<UserDataBase> users= new ArrayList<>();
        String username=login.getjTextField1().getText();
        return username;
        
//        String username=saveRegister().getName();
//        return username;
    }
    
    
 
    
    public static void eventLogin(){
        String username=login.getjTextField1().getText();
        String password=login.getjPasswordField1().getText();
        boolean estaR=DataBase.verificarCredenciales(username, password);
        if(estaR){
            
            hidden();
            ViewController.show();
            
        }else{
            login.getjLabel3().setText("*NO ESTA REGISTRADO*");
            
                  
        }
    }
    
    
    public static void viewRegister(){
        hidden();
        RegisterController.show();
    }
       
       
}

