import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Character;
import model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JacksonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jacksonTest() throws IOException {
        File file = new File("src/test/resources/character.json");

        Character character = objectMapper.readValue(file, Character.class);
        Assertions.assertEquals("Harry", character.getFirstName());
    }

    @Test
    void jacksonTest1() throws IOException {
        File file = new File("src/test/resources/person.json");
        List<Person> personList = objectMapper.readValue(file, new TypeReference<>(){});
        System.out.println(personList.get(0).toString());
        Assertions.assertEquals("MALE", personList.get(0).getData().getGender());
    }

}
