public class WhatsAppSender extends NotificationSender {
    private final WhataAppNormalizer normalizer;

    public WhatsAppSender(AuditLog audit) {
         super(audit); 
         normalizer = new WhataAppNormalizer();
    }

    @Override
    public void send(Notification n) {
        if (!normalizer.isValid(n.phone)) {
            System.out.println("WA ERROR: phone must start with + and country code");
            audit.add("WA failed");
            return;
        }
        
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}