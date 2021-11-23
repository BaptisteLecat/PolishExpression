package repository;

import database.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by BaptisteLecat
 */
public class Auth {

    public Object login(String email, String password){
        Object idUser = null;
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            request.setString(1, email);
            request.setString(2, password);

            data = request.executeQuery();
            while(data.next()){
                idUser = data.getObject("id");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return idUser;
    }
}
