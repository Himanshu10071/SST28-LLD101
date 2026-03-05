public class EmailNormalizer {
    public String normalizeBody(String body) {
        if (body == null) return "";
        return body.length() > 40 ? body.substring(0, 40) : body;
    }
}
