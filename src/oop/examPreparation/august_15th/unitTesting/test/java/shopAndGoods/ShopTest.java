package oop.examPreparation.august_15th.unitTesting.test.java.shopAndGoods;


import oop.examPreparation.august_15th.unitTesting.main.java.shopAndGoods.Goods;
import oop.examPreparation.august_15th.unitTesting.main.java.shopAndGoods.Shop;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
    }

    @Test
    public void test_CreateShop_Successfully() {
        int expectedSize = 12;

        assertEquals(expectedSize, shop.getShelves().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddGoods_ShelfDoesntExists_ShouldThrow() throws OperationNotSupportedException {
        shop.addGoods("Invalid_shelf", new Goods("some", "2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddGoods_ShelfIsAlreadyTaken_ShouldThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", new Goods("good1", "1"));
        shop.addGoods("Shelves1", new Goods("good2", "2"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddGoods_GoodsAlreadyInShelf_ShouldThrow() throws OperationNotSupportedException {
        Goods goods = new Goods("good", "1");

        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void test_AddGoods_Successfully() throws OperationNotSupportedException {
        String actual = shop.addGoods("Shelves1", new Goods("test_good", "test_code"));
        String expected = "Goods: test_code is placed successfully!";
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveGoods_ShelfDoesntExists_ShouldThrow() {
        shop.removeGoods("Invalid shelf", new Goods("good", "1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveGoods_GoodsDoesntExistInThisShelf_ShouldThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", new Goods("first", "1"));

        shop.removeGoods("Shelves1", new Goods("invalid", "1"));
    }

    @Test
    public void test_RemoveGoods_Successfully() throws OperationNotSupportedException {
        Goods toRemove = new Goods("first", "1");
        shop.addGoods("Shelves1", toRemove);

        shop.removeGoods("Shelves1", toRemove);
        assertNull(shop.getShelves().get("Shelves1"));

    }

    @Test
    public void test_RemoveGoods_Successfully_Returns() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String actual = shop.removeGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";

        assertEquals(expected, actual);

    }
}