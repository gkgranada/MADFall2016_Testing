package ee.ut.cs.mc.and.testingapplication1311;

import android.app.Application;
import android.app.Instrumentation;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedUnitTest {

    private Application app;
    private SharedPreferences prefs;

    @Before
    public void setUp(){
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        app = (Application) instrumentation.getTargetContext().getApplicationContext();
        prefs = app.getSharedPreferences(SharedPreferencesHelper.KEY_JSON_BASKET, 0);
    }

    @Test
    public void isLoadingFromPreferencesWorking(){
        // Put something in the SharedPreferences
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("Milk", 3));
        basket.addItem(new ShoppingItem("Beer", 1));
        SharedPreferencesHelper.saveToPreferences(basket, prefs);

        //actual testing
        ShoppingBasket loadedBasket = SharedPreferencesHelper.loadFromPreferences(prefs);

        assertEquals(basket.size(), loadedBasket.size());
        assertEquals(basket.get(0).name, loadedBasket.get(0).name);

    }


    @Test
    public void isSavingToPreferencesWorking(){
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("Milk", 3));

        SharedPreferencesHelper.saveToPreferences(basket, prefs);

        //We expect the saveToPreferences method to store the json representation of our basket
        String expectedResult = new Gson().toJson(basket);
        String result = prefs.getString(SharedPreferencesHelper.KEY_JSON_BASKET, null);

        assertEquals(expectedResult, result);
    }


}