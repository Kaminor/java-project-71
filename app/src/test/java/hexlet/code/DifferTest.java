package hexlet.code;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {

    static Arguments[] provideTestCases() {
        return new Arguments[] {
                Arguments.of("value1.json", "value2.json", null, "expected_default_format.txt"),
                Arguments.of("value1.json", "value2.json", "stylish", "expected_stylish_format.txt"),
                Arguments.of("value1.json", "value2.json", "plain", "expected_plain_format.txt"),
                Arguments.of("value1.json", "value2.json", "json", "expected_json_format.txt"),
                Arguments.of("value1.yml", "value2.yml", null, "expected_default_format.txt"),
                Arguments.of("value1.yml", "value2.yml", "stylish", "expected_stylish_format.txt"),
                Arguments.of("value1.yml", "value2.yml", "plain", "expected_plain_format.txt"),
                Arguments.of("value1.yml", "value2.yml", "json", "expected_json_format.txt"),
        };
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testGenerate(String file1, String file2, String format, String expectedFile) throws Exception {
        String expected = readFixture(expectedFile);
        var content1 = readFixture(file1);
        var content2 = readFixture(file2);
        String actual = format == null
                                ? generate(content1, content2)
                                : generate(content1, content2, format);

        assertEquals(expected, actual);
    }


    public static Path getFixturePath(String fileName) throws Exception {
        var resourceUrl = DifferTest.class.getClassLoader().getResource("fixtures/" + fileName);

        if (resourceUrl == null) {
            throw new IllegalArgumentException("Not found: " + resourceUrl);
        }

        return Paths.get(resourceUrl.toURI());
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path);
    }

    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        var data1 = Parser.parse(filepath1);
        var data2 = Parser.parse(filepath2);

        var diffs = DifferUtil.buildDiff(data1, data2);

        return Formatter.formatGenerate(diffs, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
