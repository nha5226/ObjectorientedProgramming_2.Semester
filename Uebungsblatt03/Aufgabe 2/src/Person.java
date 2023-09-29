import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;

public class Person {
    private final String _firstName;
    private String _lastName;
    private String _maidenName;
    private Gender _gender;
    private final LocalDate _birthday;
    private Person _partner = null;
    private Person[] _witnesses = new Person[2];
    private final HashMap<String,String> _divorceReasons = new HashMap<>(); // stores former partners + resp. reasons for divorce

    Person(String firstName, String lastName, Gender gender, String birthday) {
        _firstName = firstName;
        _lastName = lastName;
        _gender = gender;

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        _birthday = LocalDate.parse(birthday, dateFormat);
    }


    public String getFirstName() {
        return _firstName;
    }


    public String getLastName() {
        return _lastName;
    }

    // returns the birthday as a String in the local "long format" (e.g. 10. Februar 1986)
    public String birthdayToString() {

        return _birthday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }


    public int age() {

        return _birthday.until(LocalDate.now()).getYears();
    }


    public Boolean isMarried() {

        return _partner != null;
    }


    public void marry(Person partner, Person witness1, Person witness2) {

        marry(partner, witness1, witness2, true);
    }

    public void marry(Person partner, Person witness1, Person witness2, Boolean loop) {

        if (isMarried()) {
            throw new IllegalCallerException(this + " is already married to " + _partner + "!");
        }

        if (age() < 18) {
            throw new IllegalCallerException(this + " is too young to get married! (age 18 required, currently " + age() + " y/o)");
        }

        if (_gender.equals(partner._gender)) {
            throw new IllegalCallerException("Cannot marry " + this + " to " + partner + " as they are of the same gender (" + _gender + ")");
        }

        // also change state of the partner but not in an infinite loop
        if (loop) { partner.marry(this, witness1, witness2, false); }

        _partner = partner;
        _witnesses[0] = witness1;
        _witnesses[1] = witness2;

        if (_gender == Gender.FEMALE) {
            _maidenName = _lastName;
            _lastName = partner._lastName;
        }
    }


    public void divorce(String reason) {
        divorce(reason, true);
    }

    public void divorce(String reason, Boolean loop) {

        if (_partner == null) {
            throw new IllegalCallerException(this + " cannot divorce because he/she was not married before");
        }

        // also change state of the partner but not in an infinite loop
        if (loop) { _partner.divorce(reason, false); }

        // add the name of the now former partner plus the reason for the divorce to a hashmap
        String formerPartner = _partner._firstName + " " + _partner._lastName;
        // if it's not the first time they divorce, call the key "firstName lastName (1)" and so on
        for (int i = 1; _divorceReasons.containsKey(formerPartner); i++) {
            formerPartner += " (" + i + ")";
        }
        _divorceReasons.put(formerPartner, reason);

        _partner = null;
        _witnesses = new Person[2];

        if (_gender == Gender.FEMALE) {
            _lastName = _maidenName;
            _maidenName = null;
        }
    }

    // let's try to be modern at least in some sense
    public void changeGender(Gender newGender) {
        _gender = newGender;
    }

    public String toString() {
        return _firstName + " " + _lastName.charAt(0) + ".";
    }

    public String showProfile() {
        String fullName = _firstName + " " + _lastName;
        String maidenNameString = _maidenName != null ? (", born " + _maidenName) : "";
        String relationshipStatus = isMarried() ? "married" : "unmarried";
        String marriageLine = isMarried()
                ? "\n\t -> partner: " + _partner + " | witnesses: " + _witnesses[0] + ", " + _witnesses[1] + "\n"
                : "";

        return (fullName + maidenNameString + " (*" + birthdayToString() + "): " + relationshipStatus + marriageLine);
    }

}