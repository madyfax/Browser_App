package browser.demo.mbrowserapp;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MyApp extends Application {

    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences= getSharedPreferences("my",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }



    public static void setlink(String link) {
        editor.putString("s", link).commit();
    }

    public static String getlink() {
        return sharedPreferences.getString("s", "");
    }


    public static void setMyList(ArrayList<AppItem> appItems) {
        Gson gson = new Gson();
        String arraydata = gson.toJson(appItems);
        editor.putString("getMyList", arraydata).commit();
    }

    public static ArrayList<AppItem> getMyList() {
        String ardata = sharedPreferences.getString("getMyList", "");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<AppItem>>() {}.getType();
        ArrayList<AppItem> appItems = gson.fromJson(ardata, type);
        return appItems;
    }

    public static void setmypos(int pos) {
        editor.putInt("pos", pos).commit();
    }

    public static int getmypos() {
        return sharedPreferences.getInt("pos", 0);
    }


}
