package hexlet.code;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testJson() throws Exception {
        String expected = Parser.readFixture("expected_flat_output.txt");

        Map<String, Object> data1 = Parser.parseJson("file1.json");
        Map<String, Object> data2 = Parser.parseJson("file2.json");
        String actual = Differ.generate(data1, data2);

        assertEquals(expected, actual);
    }

    @Test
    public void testYaml() throws Exception {
        String expected = Parser.readFixture("expected_flat_output.txt");

        Map<String, Object> data1 = Parser.parseYaml("file1.yml");
        Map<String, Object> data2 = Parser.parseYaml("file2.yml");
        String actual = Differ.generate(data1, data2);

        assertEquals(expected, actual);
    }

    @Test
    public void testNestedYaml() throws Exception {
        String expected = Parser.readFixture("expected_nested_output.txt");

        Map<String, Object> data1 = Parser.parseYaml("nested1.yml");
        Map<String, Object> data2 = Parser.parseYaml("nested2.yml");
        String actual = Differ.generate(data1, data2);

        assertEquals(expected, actual);
    }
}
