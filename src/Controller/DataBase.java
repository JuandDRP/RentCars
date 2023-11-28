
package Controller;

import Model.Car;
import Model.Motorcycle;
import Model.UserDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author JUAN RODRIGUEZ
 */
public class DataBase {
   
    private static Connection con;
    private static boolean conectado = false;
    public static Connection conectar(){ 
        Connection con = null;
        
        String bd = "vehicle";
        String url = "jdbc:mysql://localhost:3306/"+bd;
        String user = "root";
        String pass = "1234";
        
        try {
            if (conectado == false){               
                Class.forName("org.gjt.mm.mysql.Driver");
                con = (Connection)DriverManager.getConnection(url, user, pass);
                System.out.println("CONEXION ESTABLECIDA");
                System.out.println("HECHO POR JUAN RODRIGUEZ");
            }
            return con; 
        }catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al crear la conexión "+e.getMessage());
            throw new RuntimeException("Error al crear la conexión");
        }
    }
    
    
    //metodo agregarUser
    public static boolean agregarUser(UserDataBase uD){
            String sql = "INSERT INTO usertable (user, password,name,contactNumber,cedula) VALUES (?,?,?,?,?)";
            PreparedStatement pst;
            Connection conectar;
            try{ 
                conectar=DataBase.conectar();
                pst=conectar.prepareStatement(sql);
                pst.setString(1, uD.getUsername());
                pst.setString(2, uD.getPassword());
                pst.setString(3,uD.getName());
                pst.setInt(4,uD.getContacNumber());
                pst.setInt(5,uD.getCedula());
                pst.executeUpdate(); 
                System.out.println("SE HA AGREGADO EL USUARIO: "+uD.getUsername()+" A LA DATABASE");
                System.out.println("HECHO POR KRS");
                return true;
            }catch(Exception e){
                System.out.println(e.getMessage());  
                return false;
            }
    }
    
    public static boolean verificarCredenciales(String username, String password) {
        String bd = "vehicle";
        String url = "jdbc:mysql://localhost:3306/"+bd;
        String user = "root";
        String pass = "1234";
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Consulta SQL para verificar la autenticación
            String sql = "SELECT * FROM usertable WHERE user = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Devuelve true si hay resultados, es decir, si el usuario existe con la contraseña dada
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Manejo de errores, devuelve false en caso de excepción
        }
    }
        
        
        public ArrayList<Motorcycle> obtenerMoto(){
        ArrayList<Motorcycle> lista = new ArrayList<>();
        String sql = "SELECT * FROM motorcycle";
        PreparedStatement pst;
        Connection conectar;
         try{
            conectar=DataBase.conectar();
            pst=conectar.prepareStatement(sql);
             
             
            ResultSet r= pst.executeQuery(sql); 
            
            while(r.next()){
                Motorcycle c = new Motorcycle(r.getDouble("cilindraje"),
                                        r.getInt("capacidad"),
                                        r.getDouble("precio_dia"),
                                        r.getInt("id"),
                                        r.getString("marca"),
                                        r.getString("modelo"),
                                        r.getInt("año"),
                                        r.getString("tipo"),
                                        r.getString("disponible")
                                        );      
                lista.add(c);
            }
            
         
         }catch(Exception e){
                System.out.println(e.getMessage());   
            }  
        
        return lista;
    }

    public static int saveUserDataBase(){
        ArrayList<UserDataBase> users = new ArrayList<>();
        String sql = "SELECT * FROM usertable WHERE user=?";
        String user=LoginController.saveData();
        PreparedStatement pst;
        Connection conectar;
        int cedula=0;
         try{
            conectar=DataBase.conectar();
            pst=conectar.prepareStatement(sql);
            pst.setString(1,user);
            ResultSet r= pst.executeQuery(); 
            while(r.next()){
                UserDataBase c = new UserDataBase(        r.getString("user"),
                                        r.getString("name"),
                                        r.getString("password"),
                                        r.getInt("contactNumber"),
                                        r.getInt("cedula")
                                        );      
                UserDataBase persona=users.get(0);
                cedula=persona.getCedula();
                users.add(c);
                
            }
            
         
         }catch(Exception e){
                System.out.println(e.getMessage());   
            }  
        
        return cedula;
       
    }

        
        public ArrayList<Car> obtenerCar(){
        ArrayList<Car> lista = new ArrayList<>();
        String sql = "SELECT * FROM car";
        PreparedStatement pst;
        Connection conectar;
         try{
            conectar=DataBase.conectar();
            pst=conectar.prepareStatement(sql);
            ResultSet r= pst.executeQuery(sql); 
            while(r.next()){
                Car c = new Car(        r.getDouble("cilindraje"),
                                        r.getInt("capacidad"),
                                        r.getDouble("precio_dia"),
                                        r.getInt("id"),
                                        r.getString("marca"),
                                        r.getString("modelo"),
                                        r.getInt("año"),
                                        r.getString("tipo"),
                                        r.getString("disponible")
                                        );      
                lista.add(c);
                
            }
            
         
         }catch(Exception e){
                System.out.println(e.getMessage());   
            }  
        
        return lista;
    }

} 

