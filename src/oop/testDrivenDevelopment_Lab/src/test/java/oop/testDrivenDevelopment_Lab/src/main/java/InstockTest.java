package oop.testDrivenDevelopment_Lab.src.main.java;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private Instock instock;

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    private Product[] addProductsToInstock(int count) {
        Product[] products = new Product[count];
        for (int i = 1; i <= count; i++) {
            Product toAdd = new Product("product_" + i, 10.00 + i, i);
            this.instock.add(toAdd);
            products[i - 1] = toAdd;
        }
        return products;
    }

    @Test
    public void test_Count_ShouldBeZero_When_InstockEmpty() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_ShouldBeFive_When_InstockHas_FiveProducts() {
        addProductsToInstock(5);

        int expected = 5;
        int actual = instock.getCount();

        assertEquals(expected, actual);
    }

    @Test
    public void test_Contains_ReturnsFalse_WhenProduct_IsNotPresent() {
        Product productToSearch = new Product("product_4", 10.00, 1);

        addProductsToInstock(3);

        assertFalse(instock.contains(productToSearch));
    }

    @Test
    public void test_Contains_ReturnsTrue_WhenProduct_IsPresent() {
        Product productToSearch = new Product("product_1", 10.00, 1);

        addProductsToInstock(3);

        assertTrue(instock.contains(productToSearch));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Find_WithInvalidIndex_ShouldThrow() {
        addProductsToInstock(2);

        instock.find(3);
    }

    @Test
    public void test_Find_ReturnTheProduct_OnValidIndex() {
        Product expected = addProductsToInstock(3)[2];

        Product actual = instock.find(2);

        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeQuantity_ProductIsNotInStock_ShouldThrow() {
        addProductsToInstock(10);

        instock.changeQuantity("product_11", 3);
    }

    @Test
    public void test_ChangeQuantity_Successfully() {
        Product product = addProductsToInstock(10)[3];
        int expected = 10;
        instock.changeQuantity("product_4", expected);
        int actual = product.getQuantity();

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindByLabel_NoSuchProduct_InStock_ShouldThrow() {
        addProductsToInstock(10);
        instock.findByLabel("product_13");
    }

    @Test
    public void test_FindByLabel_Returns_CorrectProduct() {
        Product expectedProduct = addProductsToInstock(10)[6];
        Product actualProduct = instock.findByLabel("product_7");
        assertEquals(expectedProduct.getLabel(), actualProduct.getLabel());
    }

    @Test
    public void test_FindFirst_ByAlphabeticalOrder_Returns_EmptyCollection_IfCountIsGreater_ThanCollectionSize() {
        addProductsToInstock(4);

        Iterable<Product> actualProducts = instock.findFirstByAlphabeticalOrder(5);
        assertEquals(new ArrayList<>(), actualProducts);
    }

    @Test
    public void test_FindFirst_ByAlphabeticalOrder_Returns_First_N_ProductsInStock() {
        int productsToTake = 10;

        List<Product> expected = Arrays.stream(addProductsToInstock(20))
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(productsToTake)
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(productsToTake);

        List<Product> actual = assertNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    private List<Product> assertNotNullAndConvertToList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        List<Product> products = new ArrayList<>();

        iterable.forEach(products::add);

        return products;
    }

    @Test
    public void test_FindAllProducts_InPriceRange_Returns_EmptyCollection_IfNoSuchProducts() {
        addProductsToInstock(10);
        Iterable<Product> actualProducts = instock.findAllInRange(20.00, 30.00);

        assertEquals(new ArrayList<>(), actualProducts);
    }

    @Test
    public void test_FindAllProducts_InPriceRange_Returns_SortedCollection_InDescendingOrder() {
        int productsToTake = 10;
        double low = 16.00;
        double high = 20.00;

        List<Product> expected = Arrays.stream(addProductsToInstock(productsToTake))
                .filter(p -> p.getPrice() > low && p.getPrice() <= high)
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findAllInRange(low, high);

        List<Product> actual = assertNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    @Test
    public void test_FindAllProducts_ByPrice_Returns_EmptyCollection_IfNoSuchProducts() {
        addProductsToInstock(5);
        Iterable<Product> products = instock.findAllByPrice(20.00);

        assertEquals(new ArrayList<>(), products);
    }

    @Test
    public void test_FindAllProducts_ByPrice_Returns_AllPresentProducts() {
        int productToTake = 10;
        double expectedPrice = 20;

        List<Product> expected = Arrays.stream(addProductsToInstock(productToTake))
                .filter(p -> p.getPrice() == expectedPrice)
                .toList();

        Iterable<Product> iterable = instock.findAllByPrice(expectedPrice);

        List<Product> actual = assertNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindFirst_MostExpensiveProducts_ReturnsLessThanExpected_ShouldThrow() {
        addProductsToInstock(10);
        instock.findFirstMostExpensiveProducts(11);
    }

    @Test
    public void test_FindFirst_MostExpensiveProducts_Successfully() {
        int productToTake = 10;
        int toFind = 5;

        List<Product> expected = Arrays.stream(addProductsToInstock(productToTake))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .limit(toFind)
                .toList();

        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(toFind);

        List<Product> actual = assertNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    @Test
    public void test_FindAll_ByQuantity_Returns_EmptyCollection_IfNoSuchProducts() {
        addProductsToInstock(10);
        Iterable<Product> iterable = instock.findAllByQuantity(15);

        assertEquals(new ArrayList<>(), iterable);
    }

    @Test
    public void test_FindAll_ByQuantity_Returns_AllProducts_WithTheGivenQuantity() {
        int productsToTake = 10;
        int expectedQuantity = 5;

        List<Product> expected = Arrays.stream(addProductsToInstock(productsToTake))
                .filter(p -> p.getQuantity() == expectedQuantity)
                .toList();

        Iterable<Product> iterable = instock.findAllByQuantity(expectedQuantity);

        List<Product> actual = assertNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    @Test
    public void test_Iterator_ShouldReturn_EmptyIterator() {
        Iterator<Product> iterator = instock.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void test_Iterator_ReturnAllProducts_InStock() {
        addProductsToInstock(10);

        Iterator<Product> iterator = instock.iterator();

        int index = 0;
        while (iterator.hasNext()) {
            Product expected = iterator.next();
            Product actual = instock.find(index);
            assertEquals(expected, actual);
            index++;
        }
    }
}