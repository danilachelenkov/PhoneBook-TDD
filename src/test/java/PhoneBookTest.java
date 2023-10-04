import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Инициализация экземпляра PhoneBook");
        phoneBook = new PhoneBook();
        phoneBook.add( "+79260110101","ИвановИИ");
        phoneBook.add( "+74952001321","ФедоровСА");
        phoneBook.add( "+71112001121","ПетровСС");
        phoneBook.add( "+85641238795","СуренАА");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Присваиваем null ссылку для экземпляра после каждого теста");
        phoneBook = null;
    }

    @Test
    public void test_AddNewEntity() {
        System.out.println("Проверка добавления записи в PhoneBook");
        int expected = 5;
        int result = phoneBook.add("+79260259874","СеменовАР");
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("test_AddNewEntityParams")
    public void test_FindByName(String expected, String fio) {

        String searchValue = fio;
        String result = phoneBook.findByName(searchValue);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_SortingCollectionForPrint(){
        List<String> expectedList = new LinkedList<>();
        expectedList.add("ИвановИИ");
        expectedList.add("ПетровСС");
        expectedList.add("СуренАА");
        expectedList.add("ФедоровСА");

        List<String> resultList = phoneBook.getSortedNames();

        Assertions.assertEquals(expectedList,resultList);
    }

    @ParameterizedTest
    @MethodSource("test_AddNewEntityParams")
    public void test_FindByNumber(String phoneNumber, String expected) {
        String searchValue = phoneNumber;
        String result = phoneBook.findByNumber(searchValue);
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> test_AddNewEntityParams() {
        return Stream.of(
                Arguments.of("+79260110101", "ИвановИИ"),
                Arguments.of("+85641238795", "СуренАА"),
                Arguments.of("+74952001321", "ФедоровСА")
        );
    }

}
