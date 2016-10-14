package ee.ut.cs.mc.and.testingapplication1311;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private ShoppingBasket basket;
    private ShoppingItem item1;
    private ShoppingItem item2;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Before
    public void initEmptyBasket(){
        //fill me
    }

    @Test
    public void itemAdding_isWorking(){
        //fill me
    }

    @Test
    public void basketTotalWithDifferentItems(){
        //fill me
    }
}