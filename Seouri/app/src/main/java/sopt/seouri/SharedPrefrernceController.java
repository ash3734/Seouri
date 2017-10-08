package sopt.seouri;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ash on 2017-10-07.
 */

public class SharedPrefrernceController {
    public static final String UERID = "userID";
    private static final String USER = "user";

    //일딴 제껴두자
  //  private static final String LOGIN_TYPE = "loginType";
/*
    public static void setLoginType(Context context, String loginType){
        SharedPreferences pref = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LOGIN_TYPE, loginType);
        editor.commit();
    }
    public static String getLoginType(Context context){
        SharedPreferences pref = context.getSharedPreferences(USER, context.MODE_PRIVATE);
        String loginType = pref.getString(LOGIN_TYPE,"");
        return loginType;
    }*/
    public static void setUserId(Context context,String userId){
        SharedPreferences pref = context.getSharedPreferences(USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(UERID,userId);
        editor.commit();
    }
    public static String getUserId(Context context){
        SharedPreferences pref = context.getSharedPreferences(USER, context.MODE_PRIVATE);
        return pref.getString(UERID,"");
    }

}
