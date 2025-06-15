package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePath {
    public static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName);
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);

        return Files.readString(path);
    }
}
