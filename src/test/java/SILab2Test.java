import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void testEveryBranch() {
        System.out.println("Test allItems == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));

        System.out.println("Test name == null, barcode == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Item", null, 300, 0)), 100));

        System.out.println("Testing if barcode has invalid character");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Item", "123b23", 100, 0)), 100));

        System.out.println("Test discount > 0, price >= 300, barcode[0] == '0', sum >= payment");
        assertTrue(SILab2.checkCart(List.of(new Item("Item", "012123", 350, 0.25F)), 100));

        System.out.println("Test sum < payment, discount < 0");
        assertFalse(SILab2.checkCart(List.of(new Item("Item", "012123", 100, 0)), 50));

    }

    @Test
    public void testMultipleCondition() {
        Item item = new Item(null, null, 0, 0);
        // Test Case TTT
        item.setPrice(350);
        item.setDiscount(0.1F);
        item.setBarcode("012123");
        assertTrue(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case TTF
        item.setBarcode("123123");
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case TFX
        item.setDiscount(0);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case FXX
        item.setPrice(200);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }
}
