import java.util.*;

public class Validation {
    Parsing p;
    
    public Validation(Parsing p) {
        this.p = p;
    }

    public void validate() {

        List<String> errors = new ArrayList<>();
        if (p.name.isBlank()) errors.add("name is required");
        if (p.email.isBlank() || !p.email.contains("@")) errors.add("email is invalid");
        if (p.phone.isBlank() || !p.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(p.program.equals("CSE") || p.program.equals("AI") || p.program.equals("SWE"))) errors.add("program is invalid");

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }
        
    }

}
