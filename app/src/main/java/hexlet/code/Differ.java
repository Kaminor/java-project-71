package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        //var content1 = FilePath.readFixture(filepath1);
        //var content2 = FilePath.readFixture(filepath2);

        String content1 = Files.readString(Paths.get(filepath1));
        String content2 = Files.readString(Paths.get(filepath2));

        var data1 = Parser.parse(content1);
        var data2 = Parser.parse(content2);

        var diffs = DifferUtil.buildDiff(data1, data2);

        return Formatter.formatGenerate(diffs, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
