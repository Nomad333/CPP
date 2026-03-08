package lab5.task3.worker;

import java.time.LocalDate;
import java.util.Objects;

public class CorpWorker implements Worker {
    private String name;
    private String surname;
    private LocalDate birthDate;

    public CorpWorker() {
        name = "";
        surname = "";
        birthDate = LocalDate.now();
    }

    public CorpWorker(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CorpWorker that)) return false;
        return Objects.equals(name, that.name)
                && Objects.equals(surname, that.surname)
                && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    @Override
    public String toString() {
        return "[name=" + name + "," +
                "surname=" + surname + "," +
                "birthDate=" + birthDate + ']';
    }
}
