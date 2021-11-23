package repository;

import database.Connector;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaptisteLecat
 */
public class LeaderBoard {

    public List<entity.LeaderBoard> getLeaderBoardList(){
        List<entity.LeaderBoard> listLeaderBoard = new ArrayList<>();
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("SELECT leaderboard.id AS leaderboard_id, leaderboard.date, leaderboard.score, user.id, user.name, user.firstname, user.email FROM leaderboard, user WHERE user.id = leaderboard.user_id ORDER BY leaderboard.score DESC LIMIT 20");

            data = request.executeQuery();
            while(data.next()){
                User user = new User(data.getInt("id"), data.getNString("name").toString(), data.getNString("firstname"), data.getNString("email"));
                entity.LeaderBoard leaderBoard = new entity.LeaderBoard(data.getInt("id"), user, data.getDate("date"), data.getInt("score"));
                listLeaderBoard.add(leaderBoard);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return listLeaderBoard;
    }
}
