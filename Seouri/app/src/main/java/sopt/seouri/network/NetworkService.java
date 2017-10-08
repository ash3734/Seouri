package sopt.seouri.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import sopt.seouri.home.MainResult;
import sopt.seouri.login.LoginData;
import sopt.seouri.login.LoginResult;
import sopt.seouri.login.SignupData;
import sopt.seouri.login.SignupResult;
import sopt.seouri.search.category.SearchCategoryResult;
import sopt.seouri.search.detail.SearchDetailResult;
import sopt.seouri.search.popup.SearchPopupResult;

/**
 * Created by 김지원 on 2017-10-05.
 */

public interface NetworkService {
    /*성현이 API*/
    @POST("member")
    Call<SignupResult> getsignupResult(@Body SignupData signupData);
    @POST("member/login")
    Call<LoginResult> getLoginResult(@Body LoginData loginData);
    @GET("home")
    Call<MainResult> getMainResult();

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
}
