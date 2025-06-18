package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

public class App {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Gendiff()).execute(args);
        System.exit(exitCode);
    }

    @Command(name = "gendiff", description = "Compares two configuration files and shows a difference.")
    static class Gendiff implements Callable<Integer> {
        @Parameters(paramLabel = "filepath1", description = "path to first file")
        private String file1;

        @Parameters(paramLabel = "filepath2", description = "path to second file")
        private String file2;

        @Option(names = { "-f", "--format" }, paramLabel = "format", defaultValue = "stylish",
                description = "output format [default: stylish]")
        private String format;

        @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
        private boolean helpRequested;

        @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
        private boolean versionRequested;

        @Override
        public Integer call() throws Exception {
            var content1 = FilePath.readFixture(file1);
            var content2 = FilePath.readFixture(file2);
            var result = Differ.generate(content1, content2, format);
            System.out.println(result);
            return 0;
        }
    }
}
