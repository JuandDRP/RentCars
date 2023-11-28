
package Controller;

import Model.Car;
import Model.Motorcycle;
import View.InterfaceView;
import View.LoginView;
import View.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * @author JUAN RODRIGUEZ
 */
public class ViewController {
    public static LoginView  login = new LoginView(); //static
    public static InterfaceView view =new InterfaceView();
    public static Ticket ticket =new Ticket();
    public static ArrayList<Car> cars = new ArrayList<Car>();
    public static ArrayList<Motorcycle> motos = new ArrayList<Motorcycle>();
    public static DataBase bd = new DataBase();
    public static void show(){view.setVisible(true);}
    public static void hidden(){view.setVisible(false);}
    
    
    public static void mostrarUser(){
        String username= LoginController.saveData();
        
        view.getjLabel12().setText(""+username);
        
    }
    
 
    public static void llenarJTableCar(){
        //llenar la tabla con todos los clientes        
        DefaultTableModel datos = (DefaultTableModel) view.getjTable1().getModel(); 
        datos.setNumRows(0); //para limpiar el modelo 
        //usar la base de datos para conectar y recibir los clientes en una lista (lista clientes)
        bd.obtenerCar();
        //luego usar la lista para llenar la tabla, deben traer todos los atributos para poder 
        //construir el objeto
        
       
        for (Car c: cars){
            Object[] fila = new Object[9];  
            fila[0]=c.getCilindraje();
            fila[1]=c.getCapacidad();
            fila[2]=c.getPrecio_dia();
            fila[3]=c.getId();
            fila[4]=c.getMarca();    
            fila[5]=c.getModelo();
            fila[6]=c.getAño();
            fila[7]=c.getTipo();
            fila[8]=c.getDisponible();
            datos.addRow(fila);
        }
    }
    
    public static void llenarJTableMoto(){
        //llenar la tabla con todos los clientes        
        DefaultTableModel datos = (DefaultTableModel) view.getjTable1().getModel(); 
        datos.setNumRows(0); //para limpiar el modelo 
       //usar la base de datos para conectar y recibir los clientes en una lista (lista clientes)
        bd.obtenerCar();
       //luego usar la lista para llenar la tabla, deben traer todos los atributos para poder 
       //construir el objeto
       
       
        for (Motorcycle c: motos){
            Object[] fila = new Object[9];  
            fila[0]=c.getCilindraje();
            fila[1]=c.getCapacidad();
            fila[2]=c.getPrecio_dia();
            fila[3]=c.getId();
            fila[4]=c.getMarca();    
            fila[5]=c.getModelo();
            fila[6]=c.getAño();
            fila[7]=c.getTipo();
            fila[8]=c.getDisponible();
            datos.addRow(fila);
        }
               
        
     
    }
        
        
        
    public static void backLogin(){
        hidden();
        LoginController.show();
    }
    

    
    
    public static boolean reservarCar(int id,String nuevoEstado){
        String sql="UPDATE car SET disponible=? WHERE id=?";
        Connection conectar;
        PreparedStatement pst;
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setString(1,nuevoEstado);
            pst.setInt(2, id);
            int i = pst.executeUpdate();
            if (i != 0){
                JOptionPane.showMessageDialog(null,"SE REALIZO LA RESERVA");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                return false;
            }
         }
        catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
      }
    
        public static boolean QuitareservarCar(int id,String nuevoEstado){
        String sql="UPDATE car SET disponible=? WHERE id=?";
        Connection conectar;
        PreparedStatement pst;
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setString(1,nuevoEstado);
            pst.setInt(2, id);
            int i = pst.executeUpdate();
            if (i != 0){
                JOptionPane.showMessageDialog(null,"SE QUITO LA RESERVA");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                return false;
            }
         }
        catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
        
        

        
    public static void conectarCarro(){
        cars=bd.obtenerCar();
        llenarJTableCar();
    }
    
    public static void conectarMoto(){
        motos=bd.obtenerMoto();
        llenarJTableMoto();
    }
    
    
     public static boolean reservarMotorcycle(int id,String nuevoEstado){
        String sql="UPDATE motorcycle SET disponible=? WHERE id=?";
        Connection conectar;
        PreparedStatement pst;
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setString(1,nuevoEstado);
            pst.setInt(2, id);
            int i = pst.executeUpdate();
            if (i != 0){
                JOptionPane.showMessageDialog(null,"SE REALIZO LA RESERVA");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                return false;
            }
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
     }
    
     
     public static boolean QuitareservarMotorcycle(int id,String nuevoEstado){
        String sql="UPDATE motorcycle SET disponible=? WHERE id=?";
        Connection conectar;
        PreparedStatement pst;
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setString(1,nuevoEstado);
            pst.setInt(2, id);
            int i = pst.executeUpdate();
            if (i != 0){
                JOptionPane.showMessageDialog(null,"SE QUITO LA RESERVA");
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Error en la transaccion");
                return false;
            }
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
     }
    
    
    
    
    
    
    
    
    
}
