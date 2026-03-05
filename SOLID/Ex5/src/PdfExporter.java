import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // LSP violation: tightens precondition arbitrarily
        if(req == null) throw new IllegalArgumentException("ExportRequest must not be null");
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        if (req.body != null && req.body.length() > 20) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }

        String fakePdf = "PDF(" + title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}