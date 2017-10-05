package sopt.seouri.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sopt.seouri.search.category.SearchCategoryResult;
import sopt.seouri.search.detail.SearchDetailResult;
import sopt.seouri.search.popup.SearchPopupResult;

/**
 * Created by 김지원 on 2017-10-05.
 */

public interface NetworkService {
    /*검색 API**/
    // 카테고리별 마을기업 조회
    @GET("villageEnterprise/category/{category}/{location}")
    Call<SearchCategoryResult> getSearchCategoryResult(@Path("category") String category, @Path("location") String location);

    // 특정 마을기업 조회
    @GET("villageEnterprise/detail/{villageEnterpriseId}")
    Call<SearchDetailResult> getSearchDetailResult(@Path("villageEnterpriseId") String villageEnterpriseId);

    // 검색 팝업
    @GET("villageEnterprise/{name}")
    Call<SearchPopupResult> getSearchPopupResult(@Path("name") String name);
}
