package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testJson() throws Exception {
        String expected = Parser.readFixture("expected_flat_output.txt");

        Map<String, Object> data1 = Parser.parse("file1.json");
        Map<String, Object> data2 = Parser.parse("file2.json");
        List<Differ> diffs = DifferUtil.buildDiff(data1, data2);
        String actual = StylishGenerator.generateStylish(diffs);

        assertEquals(expected, actual);
    }

    @Test
    public void testYaml() throws Exception {
        String expected = Parser.readFixture("expected_flat_output.txt");

        Map<String, Object> data1 = Parser.parse("file1.yml");
        Map<String, Object> data2 = Parser.parse("file2.yml");
        List<Differ> diffs = DifferUtil.buildDiff(data1, data2);
        String actual = StylishGenerator.generateStylish(diffs);

        assertEquals(expected, actual);
    }

    @Test
    public void testNestedYaml() throws Exception {
        String expected = Parser.readFixture("expected_nested_output.txt");

        Map<String, Object> data1 = Parser.parse("nested1.yml");
        Map<String, Object> data2 = Parser.parse("nested2.yml");
        List<Differ> diffs = DifferUtil.buildDiff(data1, data2);
        String actual = StylishGenerator.generateStylish(diffs);

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormat() throws Exception {
        String expected = Parser.readFixture("expected_plain_format");

        Map<String, Object> data1 = Parser.parse("nested1.yml");
        Map<String, Object> data2 = Parser.parse("nested2.yml");
        List<Differ> diffs = DifferUtil.buildDiff(data1, data2);
        String actual = PlainGenerator.generatePlain(diffs);

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFormat() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String expectedJson = Parser.readFixture("expected_json_output.json");
        List<JsonDiffer> expected = mapper.readValue(expectedJson, new TypeReference<List<JsonDiffer>>() { });

        Map<String, Object> data1 = Parser.parse("file1.json");
        Map<String, Object> data2 = Parser.parse("file2.json");
        List<Differ> diffs = DifferUtil.buildDiff(data1, data2);
        List<JsonDiffer> actual = JsonGenerator.generateJson(diffs);

        assertEquals(expected, actual);
    }
}
