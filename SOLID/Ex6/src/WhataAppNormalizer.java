public class WhataAppNormalizer {
    public boolean isValid(String phone) {
        return phone != null && phone.startsWith("+");
    }   
}
