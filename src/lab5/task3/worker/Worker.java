package lab5.task3.worker;

import java.time.LocalDate;

public interface Worker {
    String getName();

    String getSurname();

    LocalDate getBirthDate();

    int getAge();
}
