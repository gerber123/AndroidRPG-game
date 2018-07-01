package pl.marcinos.expfor2.Model;

/**
 * Created by marci on 03.04.2018.
 */

public class CurrentUser
{
    public String bohater;
    public String userName;
    public int voteScore;
    private String password;
    private String email;
    public int online;

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }


    public void setBohater(String Bohater) {
        this.bohater = Bohater;
    }

    public CurrentUser() {

    }
    public int getVoteScore() {
        return voteScore;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBohater() {
        return bohater;
    }

    public String getEmail() {
        return email;

    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }

    public CurrentUser(String userName, String password, String email) {

        this.userName = userName;
        this.voteScore = 2;
        this.password=password;
        this.email=email;
        this.online=1;

    }
}
