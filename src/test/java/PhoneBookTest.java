import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Инициализация экземпляра PhoneBook");
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Присваиваем null ссылку для экземпляра после каждого теста");
        phoneBook = null;
    }

    @Test
    public void test_AddNewEntity() {
        System.out.println("Проверка добавления записи в PhoneBook");
        int expected = 1;
        int result = phoneBook.add("+79260259874","СеменовАР");
        Assertions.assertEquals(expected, result);
    }
}
