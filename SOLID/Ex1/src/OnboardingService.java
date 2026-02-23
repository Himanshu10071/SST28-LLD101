
public class OnboardingService {
    private final FakeDb db;
    StudentRepository sr;

    public OnboardingService(FakeDb db, StudentRepository sr) {
        this.db = db;
        this.sr = sr;
    }

    public OnboardingService(FakeDb db) {
        this.db = db;
        this.sr = db;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        // Parsing the input String
        Parsing p = new Parsing(raw);
        p.Parse();  

        // Map<String,String> kv = new LinkedHashMap<>();
        // String[] parts = raw.split(";");
        // for (String p : parts) {
        // String[] t = p.split("=", 2);
        // if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        // }

        // String name = kv.getOrDefault("name", "");
        // String email = kv.getOrDefault("email", "");
        // String phone = kv.getOrDefault("phone", "");
        // String program = kv.getOrDefault("program", "");

        // validation inline, printing inline

        Validation v = new Validation(p);
        v.validate();

        // List<String> errors = new ArrayList<>();
        // if (name.isBlank()) errors.add("name is required");
        // if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        // if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit))
        // errors.add("phone is invalid");
        // if (!(program.equals("CSE") || program.equals("AI") ||
        // program.equals("SWE"))) errors.add("program is invalid");

        // if (!errors.isEmpty()) {
        // System.out.println("ERROR: cannot register");
        // for (String e : errors) System.out.println("- " + e);
        // return;

        // }

        String id = IdUtil.nextStudentId(sr.count());
        StudentRecord rec = new StudentRecord(id, p.name, p.email, p.phone, p.program);

        sr.save(rec);

       ConfirmationPrinter.printConfirmation(rec, sr.count());
    }
}
