package lab3.task3;

import lab3.task3.banknote.Banknote;
import lab3.task3.banknote.BanknoteBuilder;
import lab3.task3.exeptions.NominalExeption;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<ATM> atms;
    private final int atmCount;
    private final BanknoteBuilder builder;

    public Bank(int atmCount, BanknoteBuilder builder, int[] nominals, List<Banknote> banknotesPerATM) throws NominalExeption {
        this.atmCount = atmCount;
        this.atms = new ArrayList<>(atmCount);
        this.builder = builder;
        initATMs(nominals, banknotesPerATM);
    }

    private void initATMs(int[] nominals, List<Banknote> banknotesPerATM) throws NominalExeption {
        for (int i = 0; i < atmCount; i++) {
            ATM atm = new ATM(nominals, builder);
            for (var banknote : banknotesPerATM) {
                atm.deposit(banknote.getNominal(), 1);
            }
            atms.add(atm);
        }
    }

    public void loadCash(int atmIndex, int nominal, int count) throws NominalExeption {
        atms.get(atmIndex).deposit(nominal, count);
    }

    public int getTotalMoney() {
        return atms.stream().mapToInt(ATM::getTotalMoney).sum();
    }

    public List<ATM> getAtms() {
        return atms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bank:[\n");
        sb.append("ATM count: ").append(atmCount);
        for (var atm : atms) {
            sb.append("\nATM total :").append(atm.getTotalMoney()).append(builder.getSymbol());
        }
        sb.append("\nTotal: ").append(getTotalMoney()).append(builder.getSymbol()).append("]");
        return sb.toString();
    }
}