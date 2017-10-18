package sopt.seouri.login;

/**
 * Created by ash on 2017-10-07.
 */

public class LoginData {
    public String userId;
    public String kakaoToken;

    public LoginData(String userId, String kakaoToken) {
        this.userId = userId;
        this.kakaoToken = kakaoToken;
    }
}
