
package Controller;

import static Controller.ViewController.ticket;
import View.InterfaceView;
import View.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN RODRIGUEZ
 */
public class TicketController {
    public static Ticket ticket=new Ticket();
    public static InterfaceView interfaceV =new InterfaceView();
    public static void show(){ticket.setVisible(true);}
    public static void hidden(){ticket.setVisible(false);}
    
    public static void generarTicketCar(int id,long dias,LocalDate fechaInicio, LocalDate fechaFin, String tipo,String metodoPago){
        //SELECT * FROM tabla_carros WHERE id = ?
        String sql="SELECT precio_dia FROM car WHERE id = ?";
        Connection conectar;
        PreparedStatement pst;
        double precioDia=0.0;
        int cedula=DataBase.saveUserDataBase();
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultado = pst.executeQuery();

//            int i = pst.executeUpdate();
             if (resultado.next()) {
                precioDia = resultado.getDouble("precio_dia");
                // Haz algo con el precio obtenido, por ejemplo, imprimirlo
                System.out.println("El precio por día del carro es: " + precioDia);
            } else {
                System.out.println("No se encontró ningún carro con ese ID.");
            }
         }
        catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
//            return false;
        }
        double costoTotal=dias*precioDia;
        
        
        
//        System.out.println(costoTotal);}
        ticket.getjLabel11().setText("DIAS RENTADOS: "+dias);
        ticket.getjLabel12().setText("$"+costoTotal);
        ticket.getjLabel4().setText("FECHA INICIO : "+fechaInicio);
        ticket.getjLabel5().setText("HASTA : "+fechaFin);
        ticket.getjLabel13().setText(tipo);
        ticket.getjLabel8().setText("SU METODO DE PAGO ES: "+metodoPago);
        ticket.getjLabel2().setText(""+cedula);
        
//        return costoTotal;
        
    }       

     public static void generarTicketMoto(int id,long dias,LocalDate fechaInicio, LocalDate fechaFin, String tipo,String metodoPago){
        //SELECT * FROM tabla_carros WHERE id = ?
        String sql="SELECT precio_dia FROM motorcycle WHERE id = ?";
        Connection conectar;
        PreparedStatement pst;
        double precioDia=0.0;
        int cedula=DataBase.saveUserDataBase();
        try{
            conectar = DataBase.conectar();
            pst = conectar.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultado = pst.executeQuery();

//            int i = pst.executeUpdate();
             if (resultado.next()) {
                precioDia = resultado.getDouble("precio_dia");
                // Haz algo con el precio obtenido, por ejemplo, imprimirlo
                System.out.println("El precio por día del carro es: " + precioDia);
            } else {
                System.out.println("No se encontró ningún carro con ese ID.");
            }
         }
        catch(SQLException e){            
            JOptionPane.showMessageDialog(null, e.getMessage());
//            return false;
        }
        double costoTotal=dias*precioDia;
        
        
        
//        System.out.println(costoTotal);}
        ticket.getjLabel11().setText("DIAS RENTADOS: "+dias);
        ticket.getjLabel12().setText("$"+costoTotal);
        ticket.getjLabel4().setText("FECHA INICIO : "+fechaInicio);
        ticket.getjLabel5().setText("HASTA : "+fechaFin);
        ticket.getjLabel13().setText(tipo);
        ticket.getjLabel8().setText("SU METODO DE PAGO ES: "+metodoPago);
        ticket.getjLabel2().setText(""+cedula);
        
//        return costoTotal;
        
    }       
    
}
