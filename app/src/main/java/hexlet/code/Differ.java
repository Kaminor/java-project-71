package hexlet.code;


public class Differ {
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
