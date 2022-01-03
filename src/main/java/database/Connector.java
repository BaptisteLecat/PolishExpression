package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by BaptisteLecat
 */
public class Connector {

    public static Connection getConnexion(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/polish_bdd","root","");
        } catch (SQLException e) {
            //traitement de l'exception
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return con;
    }
}
