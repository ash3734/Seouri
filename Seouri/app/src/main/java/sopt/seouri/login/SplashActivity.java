package sopt.seouri.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.MainActivity;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;
import sopt.seouri.search.popup.SearchPopupResult;
import sopt.seouri.search.popup.SearchPopupResultData;

import static sopt.seouri.application.ApplicationController.serverToken;

public class SplashActivity extends AppCompatActivity {

    public static ArrayList<SearchPopupResultData> popupDatas = new ArrayList<>();
    NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        service = ApplicationController.getInstance().getNetworkService();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM_token", token);
        AutoLogin();
        Call<SearchPopupResult> getSearchPopupResult = service.getSearchPopupResult(serverToken);
        getSearchPopupResult.enqueue(new Callback<SearchPopupResult>() {
            @Override
            public void onResponse(Call<SearchPopupResult> call, Response<SearchPopupResult> response) {
                if(response.isSuccessful()){
                    if(response.body().message.equals("Succeed in selecting total villageEnterprise")){
                        popupDatas = response.body().TotalVelist;
                    }
                } else{
                    Log.d("getSearchPopupResult", "통신 에러");
                }
            }

            @Override
            public void onFailure(Call<SearchPopupResult> call, Throwable t) {
                Log.d("getSearchPopupResult", "onFailure");
            }
        });

    }

    public void AutoLogin() {
            //// TODO: 2017-10-18 카카오가 깔려있지 않은 디바이스라면 밑에를 주석처리하고 밑에 주석을 살리면됩니다.
//        if (SharedPrefrernceController.getUserId(SplashActivity.this).equals("")) {
//
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                    finish();
//                }
//            }, 3000);
//        } else {
//            String userId = SharedPrefrernceController.getUserId(getApplicationContext());
//            String kakoToken = SharedPrefrernceController.getKakaotoken(getApplicationContext());
//            ApplicationController.serverToken = SharedPrefrernceController.getServertoken(getApplicationContext());
//            ApplicationController.memberId = userId;
//            String token = FirebaseInstanceId.getInstance().getToken();
//            Log.d("ash", "userId " + userId);
//            Log.d("ash", "kakoToken " + kakoToken);
//            Log.d("ash", "token " + token);
//
//            Call<LoginResult> loginResultCall = service.getLoginResult(new LoginData(userId, kakoToken)); //
//            loginResultCall.enqueue(new Callback<LoginResult>() {
//                @Override
//                public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
//                    if (response.isSuccessful()) {
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        ApplicationController.memberImg = response.body().userInfo.profile;
//                        ApplicationController.memberName = response.body().userInfo.name;
//                        Log.d("ash", "serverToken in login" + response.body().token);
//                        finish();
//                        startActivity(intent);
//                    } else {
//                        Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
//                        toast.show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginResult> call, Throwable t) {
//                    Toast toast = Toast.makeText(getApplicationContext(), "네트워크 상태를 확인하세요", Toast.LENGTH_LONG);
//                    toast.show();
//                }
//            });
//            //}
//        }

            String userId = "533453077";
//            String kakoToken = "532978074";
            serverToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI1MzM0NTMwNzciLCJpYXQiOjE1MDkxMDI0NzUsImV4cCI6MTUxMTY5NDQ3NX0.hKvYXKVbURvpLbvyl0qSIOw5x6nOaTtbPDKDCWckbdE";

            Call<LoginResult> loginResultCall = service.getLoginResult(new LoginData(userId)); //
            loginResultCall.enqueue(new Callback<LoginResult>() {
                @Override
                public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        ApplicationController.memberImg = response.body().userInfo.profile;
                        ApplicationController.memberName = response.body().userInfo.name;
                        finish();
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResult> call, Throwable t) {
                    Toast toast = Toast.makeText(getApplicationContext(), "네트워크 상태를 확인하세요", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
            //}

    }
}
