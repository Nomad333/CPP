package lab3.task2;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthDate + ")";
    }
}