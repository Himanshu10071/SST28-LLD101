public class EmailSender extends NotificationSender {
    private final EmailNormalizer normalizer;

    public EmailSender(AuditLog audit) { 
        super(audit); 
        normalizer = new EmailNormalizer();
    }

    @Override
    public void send(Notification n) {
        // LSP smell: truncates silently, changing meaning
        String body = normalizer.normalizeBody(n.body);
        
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}