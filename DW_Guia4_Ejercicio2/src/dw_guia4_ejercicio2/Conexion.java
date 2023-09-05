
package dw_guia4_ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private String url, bd, usuario,pass,driver;
    private Connection cx;

    public Conexion(String db) {
        this.bd = db;
        url = "jdbc:mariadb://localhost:3306/";
        usuario = "root";
        pass = "";
        driver = "org.mariadb.jdbc.Driver";
    }
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,usuario,pass);
            System.out.println("Conexión exitosa a la base"+bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexión"+ex); // si tenemos botones le ponemos JOption Pane
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String [] args){
        Conexion con = new Conexion("guia4_ejercicio2");// nombre de la base de datos que me quiero conectar
        con.conectar();
    }
}
