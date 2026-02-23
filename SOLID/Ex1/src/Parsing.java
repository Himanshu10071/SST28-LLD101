import java.util.*;

public class Parsing {
    String raw;
    public String name;
    public String email;
    public String phone;
    public String program;

    public Parsing(String raw) {
        this.raw = raw;
    }

    public void Parse() {
        Map<String,String> kv = new LinkedHashMap<>();
        String[] parts = this.raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }

        this.name = kv.getOrDefault("name", "");
        this.email = kv.getOrDefault("email", "");
        this.phone = kv.getOrDefault("phone", "");
        this.program = kv.getOrDefault("program", "");
    }
}