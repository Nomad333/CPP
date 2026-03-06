package lab3.task3.banknote;

import java.util.List;

public interface BanknoteBuilder extends Builder<List<Banknote>> {
    BanknoteBuilder put(int nominal, int count);

    char getSymbol();
}