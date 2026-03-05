public class SmsSender extends NotificationSender {
    private final SmsNormalizer normalizer;

    public SmsSender(AuditLog audit) {
         super(audit); 
         normalizer = new SmsNormalizer();
    }

    @Override
    public void send(Notification n) {
        // LSP smell: truncates silently, changing meaning
        String phone = normalizer.normalizePhone(n.phone);

        System.out.println("SMS -> to=" + phone + " body=" + n.body);
        audit.add("sms sent");
    }
}