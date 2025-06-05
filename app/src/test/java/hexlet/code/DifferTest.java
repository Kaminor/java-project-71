package hexlet.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testJsonDefaultFormat() throws Exception {
        String expected = Parser.readFixture("expected_default_format.txt");
        String actual = Differ.generate("file1.json", "file2.json");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonStylishFormat() throws Exception {
        String expected = Parser.readFixture("expected_stylish_format.txt");
        String actual = Differ.generate("file1.json", "file2.json", "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonPlainFormat() throws Exception {
        String expected = Parser.readFixture("expected_plain_format.txt");
        String actual = Differ.generate("file1.json", "file2.json", "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFileFormatJson() throws Exception {
        String expected = Parser.readFixture("expected_json_format.txt");
        String actual = Differ.generate("file1.json", "file2.json", "json");

        assertEquals(expected, actual);
    }

    @Test
    public void testYmlDefaultFormat() throws Exception {
        String expected = Parser.readFixture("expected_default_format.txt");
        String actual = Differ.generate("file1.yml", "file2.yml");

        assertEquals(expected, actual);
    }

    @Test
    public void testYmlStylishFormat() throws Exception {
        String expected = Parser.readFixture("expected_stylish_format.txt");
        String actual = Differ.generate("file1.yml", "file2.yml", "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testYmlPlainFormat() throws Exception {
        String expected = Parser.readFixture("expected_plain_format.txt");
        String actual = Differ.generate("file1.yml", "file2.yml", "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testYmlFileFormatJson() throws Exception {
        String expected = Parser.readFixture("expected_json_format.txt");
        String actual = Differ.generate("file1.yml", "file2.yml", "json");

        assertEquals(expected, actual);
    }
}
