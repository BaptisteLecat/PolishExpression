package repository;

import database.Connector;
import entity.User;

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
                idUser = data.getInt("id");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return idUser;
    }

    public boolean register(String name, String firstname, String email, String password){
        boolean success = false;
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("INSERT INTO user (name, firstname, email, password) VALUES (?, ?, ?, ?)");
            request.setString(1, name);
            request.setString(2, firstname);
            request.setString(3, email);
            request.setString(4, password);
            success = true;
        }catch (SQLException e){
            System.out.println(e);
        }

        return success;
    }

    public User whoAmI(int userId){
        User user = null;
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("SELECT * FROM user WHERE id = ?");
            request.setInt(1, userId);

            data = request.executeQuery();
            while(data.next()){
                user = new User(data.getInt("id"), data.getNString("name"), data.getNString("firstname"), data.getNString("email"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return user;
    }
}
