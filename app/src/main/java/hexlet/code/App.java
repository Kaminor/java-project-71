package hexlet.code;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
            var data1 = Parser.parse(file1);
            var data2 = Parser.parse(file2);

            var diffs = DifferUtil.buildDiff(data1, data2);
            var result = Formatter.callFormatType(diffs, format);

            if (format.equals("json")) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);

                String jsonOutput = mapper.writeValueAsString(result);
                System.out.println(jsonOutput);
            } else {
                System.out.println(result);
            }

            return 0;
        }
    }
}
