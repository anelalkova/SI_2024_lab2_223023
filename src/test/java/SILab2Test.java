import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SILab2Test {

    @Test(expected = RuntimeException.class)
    public void testEveryBranchTestCase1() {
        SILab2.checkCart(null, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testEveryBranchTestCase2() {
        List<Item> allItems = Collections.singletonList(new Item(null, null, 0, 0));
        SILab2.checkCart(allItems, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testEveryBranchTestCase3() {
        List<Item> allItems = Collections.singletonList(new Item("Item", "barcodeID", 0, 0));
        SILab2.checkCart(allItems, 0);
    }

    @Test
    public void testEveryBranchTestCase4() {
        List<Item> allItems = Collections.singletonList(new Item("Item", "012123", 350, 10));
        assertTrue(SILab2.checkCart(allItems, 4000));
    }

    @Test
    public void testEveryBranchTestCase5() {
        List<Item> allItems = Collections.singletonList(new Item("Item", "123123", 250, -10));
        assertFalse(SILab2.checkCart(allItems, 150));
    }

    @Test
    public void testMultipleConditionTestCaseTTT() {
        Item item = new Item("Item", "012312", 350, 10);
        assertTrue(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }

    @Test
    public void testMultipleConditionTestCaseTTF() {
        Item item = new Item("Item", "123123", 350, 10);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }

    @Test
    public void testMultipleConditionTestCaseTFX() {
        Item item = new Item("Item", "abcxyz", 350, 0);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }

    @Test
    public void testMultipleConditionTestCaseFXX() {
        Item item = new Item("Item", "abcxyz", 200, 0);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }
}
