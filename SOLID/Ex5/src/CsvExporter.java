
import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        if(req == null) throw new IllegalArgumentException("ExportRequest must not be null");
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        // LSP issue: changes meaning by lossy conversion
        body = body.replace("\n", " ").replace(",", " ");
        
        String csv = "title,body\n" + req.title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
