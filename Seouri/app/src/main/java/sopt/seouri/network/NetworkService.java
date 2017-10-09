package sopt.seouri.network;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import sopt.seouri.community.BulletinAddCommentData;
import sopt.seouri.community.BulletinAddCommentResult;
import sopt.seouri.community.BulletinAddPostResult;
import sopt.seouri.community.FindBulletinDetailResult;
import sopt.seouri.community.FindBulletinResult;
import sopt.seouri.search.category.SearchCategoryResult;
import sopt.seouri.search.detail.SearchDetailResult;
import sopt.seouri.search.popup.SearchPopupResult;

/**
 * Created by 김지원 on 2017-10-05.
 */

public interface NetworkService {
    /*검색 API**/
    // 카테고리별 마을기업 조회
    @GET("villageEnterprise/list/{location}")
    Call<SearchCategoryResult> getSearchCategoryResult(@Path("location") String location);

    // 특정 마을기업 조회
    @GET("villageEnterprise/detail/{villageEnterpriseId}")
    Call<SearchDetailResult> getSearchDetailResult(@Path("villageEnterpriseId") String villageEnterpriseId);

    // 검색 팝업
    @GET("villageEnterprise/{name}")
    Call<SearchPopupResult> getSearchPopupResult(@Path("name") String name);


    /////////////////////////////////////////  커뮤니티

    // 게시글 조회
    @GET("community/list/{location}")
    Call<FindBulletinResult> getFindBulletinResult(@Path("location") String location);

    //게시글 상세 조회
    @GET("community/{postId}")
    Call<FindBulletinDetailResult> getFindBulletinDetailResult(@Path("postId") String postId);

    //게시글 작성
    @Multipart
    @POST("community")
    Call<BulletinAddPostResult> getBulletinAddPostResult(@Part("userId") RequestBody userId,
                                                         @Part("title") RequestBody title,
                                                         @Part("content") RequestBody content,
                                                         @Part("location") RequestBody location,
                                                         @Part MultipartBody.Part images);

//    Call<BulletinAddPostResult> getBulletinAddPostResult(@Body BulletinAddPostData bulletinAddPostData);

    //댓글 작성
    @POST("community/comment")
    Call<BulletinAddCommentResult> getBulletinAddCommentResult(@Body BulletinAddCommentData bulletinAddCommentData);

    //게시글 검색

}
