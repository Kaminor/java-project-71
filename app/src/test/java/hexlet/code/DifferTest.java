package hexlet.code;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testCorrectionEquals() throws Exception {
        String expected = "{\n  - proxy: 123.234.53.22"
                        + "\n    host: hexlet.io"
                        +  "\n  - follow: false"
                        +  "\n  - timeout: 50"
                        +  "\n  + timeout: 20"
                        +  "\n  + verbose: true "
                        +  "\n}";

        Map<String, Object> data1 = JsonParser.parseJson("file1.json");
        Map<String, Object> data2 = JsonParser.parseJson("file2.json");
        String actual = Differ.generate(data1, data2);

        assertEquals(expected, actual);
    }
}
