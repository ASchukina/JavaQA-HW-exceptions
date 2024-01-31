import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Футболка", 1500);
    Product product2 = new Product(2, "Джинсы", 3000);
    Product product3 = new Product(3, "Пиджак", 4000);

    @Test
    public void successDeleting() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(3);

        Product[] expected = {product1, product2};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void NotFoundExceptionTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }
}
