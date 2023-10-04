import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> memoryBook;

    public PhoneBook() {
        this.memoryBook = new HashMap<>();
    }

    public int add(String phoneNumber,String fio) {
        memoryBook.put(phoneNumber,fio);
        return memoryBook.size();
    }

    public String findByNumber(String phoneNumber) {
        return memoryBook.get(phoneNumber);
    }
}
