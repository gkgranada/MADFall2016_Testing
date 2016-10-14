package ee.ut.cs.mc.and.testingapplication1311;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPreferencesHelper {
    public static final String KEY_JSON_BASKET = "BASKET";

    public static void saveToPreferences(ShoppingBasket basket, SharedPreferences sharedPrefs){
        String json =  new Gson().toJson(basket);

        sharedPrefs.edit()
                .putString( KEY_JSON_BASKET, json)
                .apply();
    }

    public static ShoppingBasket loadFromPreferences(SharedPreferences sharedPrefs){
        String storedBasketJson = sharedPrefs.getString(KEY_JSON_BASKET, null);
        if (storedBasketJson == null){
            return null;
        } else {
            ShoppingBasket loadedBasket = new Gson().fromJson(storedBasketJson, ShoppingBasket.class);
            return loadedBasket;
        }
    }
}
