package hexlet.code;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        var expectedPath = DifferTest.class.getClassLoader().getResource("fixtures/" + expectedFile).getPath();
        var expectedContent = FilePath.readFixture(expectedPath);
        var resourceUrl1 = DifferTest.class.getClassLoader().getResource("fixtures/" + file1).getPath();
        var resourceUrl2 = DifferTest.class.getClassLoader().getResource("fixtures/" + file2).getPath();
        String actual = format == null
                                ? Differ.generate(resourceUrl1, resourceUrl2)
                                : Differ.generate(resourceUrl1, resourceUrl2, format);

        assertEquals(expectedContent, actual);
    }
}
