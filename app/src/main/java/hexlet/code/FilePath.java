package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePath {
    public static Path getFixturePath(String fileName) throws Exception {
        String userDir = System.getProperty("user.dir");
        Path path;

        if (userDir.contains("project")) {
            path = Paths.get(userDir, "src", "test", "resources", "fixtures", fileName);
        } else {
            path = Paths.get("src", "test", "resources", "fixtures", fileName);
        }
        return path.toAbsolutePath().normalize();
    }

    public static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);

        return Files.readString(path);
    }
}
