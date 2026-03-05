
import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // inconsistent handling (surprise)
        if(req == null) throw new IllegalArgumentException("ExportRequest must not be null");
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
