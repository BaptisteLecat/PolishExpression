package repository;

import database.Connector;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BaptisteLecat & FxPelet
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
                entity.LeaderBoard leaderBoard = new entity.LeaderBoard(data.getInt("leaderboard_id"), user, data.getDate("date"), data.getInt("score"));
                listLeaderBoard.add(leaderBoard);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return listLeaderBoard;
    }

    public entity.LeaderBoard getLastLeaderBoardForUser(User user){
        entity.LeaderBoard leaderBoard = null;
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("SELECT leaderboard.id AS leaderboard_id, leaderboard.date, leaderboard.score FROM leaderboard, user WHERE user.id = ? AND user.id = leaderboard.user_id ORDER BY leaderboard.date DESC LIMIT 1");
            request.setInt(1, user.getId());

            data = request.executeQuery();
            while(data.next()){
                leaderBoard = new entity.LeaderBoard(data.getInt("leaderboard_id"), user, data.getDate("date"), data.getInt("score"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return leaderBoard;
    }

    public List<entity.LeaderBoard> getLeaderBoardListForUser(User user){
        List<entity.LeaderBoard> listLeaderBoard = new ArrayList<>();
        try{
            ResultSet data = null;
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("SELECT leaderboard.id AS leaderboard_id, leaderboard.date, leaderboard.score, user.id, user.name, user.firstname, user.email FROM leaderboard, user WHERE user.id = ? AND user.id = leaderboard.user_id ORDER BY leaderboard.score DESC LIMIT 20");
            request.setInt(1, user.getId());
            data = request.executeQuery();

            while(data.next()){
                entity.LeaderBoard leaderBoard = new entity.LeaderBoard(data.getInt("leaderboard_id"), user, data.getDate("date"), data.getInt("score"));
                listLeaderBoard.add(leaderBoard);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return listLeaderBoard;
    }

    public boolean insertUserLeaderBoard(int userId, int score){
        boolean success = false;
        try{
            PreparedStatement request =
                    Connector.getConnexion().prepareStatement("INSERT INTO leaderboard (user_id, score) VALUES (?, ?)");
            request.setInt(1, userId);
            request.setInt(2, score);
            request.executeUpdate();
            success = true;
        }catch (SQLException e){
            System.out.println(e);
        }

        return success;
    }
}
