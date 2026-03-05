public class SmsNormalizer {
    public String normalizePhone(String phone) {
        return phone == null ? "" : phone.replaceAll("[\\s\\-()]", "");
    }
}
