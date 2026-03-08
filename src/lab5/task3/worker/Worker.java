package lab5.task3.worker;

import java.time.LocalDate;
import java.time.Period;

public interface Worker {
    String getName();

    String getSurname();

    LocalDate getBirthDate();

    default int getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }
}
