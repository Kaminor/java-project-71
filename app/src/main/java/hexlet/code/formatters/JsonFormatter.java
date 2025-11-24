package hexlet.code.formatters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.DifferData;
import java.util.List;

public class JsonFormatter {
    public static String formatJson(List<DifferData> diff) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper.writeValueAsString(diff);
    }
}
