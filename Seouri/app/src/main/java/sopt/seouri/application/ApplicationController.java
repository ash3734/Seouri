package sopt.seouri.application;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sopt.seouri.network.NetworkService;

/**
 * Created by 김지원 on 2017-10-05.
 */

public class ApplicationController extends Application {
    private static ApplicationController instance;
    public static ApplicationController getInstance(){
        return instance;
    }
    private static String baseUrl = "";
    private NetworkService networkService;
    public NetworkService getNetworkService(){
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 폰트 바꿀 때 주석 풀고 내용 변경할 것
//        Typekit.getInstance()
//                .addNormal(Typekit.createFromAsset(this,"NanumSquareR.ttf"))
//                .addCustom1(Typekit.createFromAsset(this,"NanumBarunGothic.ttf"))
//                .addCustom2(Typekit.createFromAsset(this,"NanumMyeongjo.ttc"))
//                .addCustom3(Typekit.createFromAsset(this,"NanumMyeongjoExtraBold.ttf"))
//                .addCustom4(Typekit.createFromAsset(this,"NanumSquareR.ttf"));

        ApplicationController.instance = this;

//        buildService();       //통신소스 완료 후 주석풀자.
    }

    public void buildService(){
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        networkService = retrofit.create(NetworkService.class);
    }

}
