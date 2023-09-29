public class RegistryOffice {

    public static void main(String[] args) {

        Person donald = new Person("Donald", "Duck", Gender.MALE, "16.04.2000");
        Person daisy = new Person("Daisy", "Queen", Gender.FEMALE, "10.02.2000");
        Person peter = new Person("Peter", "Tschofen", Gender.MALE, "10.02.2000");
        Person selina = new Person("Selina", "Bömer", Gender.FEMALE, "10.02.2000");

        System.out.println(donald.birthdayToString());
        System.out.println(daisy.birthdayToString());

        System.out.println(donald.showProfile());

        donald.marry(daisy, peter, selina);

        System.out.println(daisy.showProfile());

        daisy.divorce("Streit um Tochter");

    }
}