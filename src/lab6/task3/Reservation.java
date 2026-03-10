package lab6.task3;

import java.time.LocalDate;

public record Reservation(Table table, Visitor visitor, LocalDate expDate) {
}
