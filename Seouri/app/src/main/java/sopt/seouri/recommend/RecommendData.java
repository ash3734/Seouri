package sopt.seouri.recommend;

/**
 * Created by ash on 2017-10-08.
 */

public class RecommendData {
    public String commpanyName1;
    public String commpanyComment1;
    public String commpanyName2;
    public String commpanyComment2;
    public String commpanyName3;
    public String commpanyComment3;
    public String recommendName;
    public String recommendComment;
    public int recommendImg;

    public RecommendData(String commpanyName1, String commpanyComment1, String commpanyName2, String commpanyComment2, String commpanyName3, String commpanyComment3, String recommendName, String recommendComment, int recommendImg) {
        this.commpanyName1 = commpanyName1;
        this.commpanyComment1 = commpanyComment1;
        this.commpanyName2 = commpanyName2;
        this.commpanyComment2 = commpanyComment2;
        this.commpanyName3 = commpanyName3;
        this.commpanyComment3 = commpanyComment3;
        this.recommendName = recommendName;
        this.recommendComment = recommendComment;
        this.recommendImg = recommendImg;
    }
}
