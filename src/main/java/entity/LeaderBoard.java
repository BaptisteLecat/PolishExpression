package entity;

import java.util.Date;

public class LeaderBoard {
    private int id;
    private User user;
    private Date date;
    private int score;

    public LeaderBoard(int id, User user, Date date, int score) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

}
