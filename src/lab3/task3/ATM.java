package lab3.task3;

import lab3.task3.banknote.Banknote;
import lab3.task3.banknote.BanknoteBuilder;
import lab3.task3.exeptions.BalanceException;
import lab3.task3.exeptions.BanknoteAmountExeption;
import lab3.task3.exeptions.NominalExeption;
import lab3.task3.exeptions.WithdrawException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ATM {
    private final List<Banknote> banknotes = new ArrayList<>();
    private final int[] availableNominals;
    private final BanknoteBuilder builder;
    private int maxWithdrawalAmount;
    private int maxBanknotesPerWithdrawal;

    public ATM(int[] availableNominals, BanknoteBuilder builder) {
        this.availableNominals = availableNominals;
        this.builder = builder;
        maxWithdrawalAmount = 5000;
        maxBanknotesPerWithdrawal = 20;
    }

    public ATM(int[] availableNominals, BanknoteBuilder builder, int maxBanknotesPerWithdrawal, int maxWithdrawalAmount) {
        this(availableNominals, builder);
        this.maxWithdrawalAmount = maxWithdrawalAmount;
        this.maxBanknotesPerWithdrawal = maxBanknotesPerWithdrawal;
    }

    private void checkNominal(int nominal) throws NominalExeption {
        var isFound = Arrays.stream(availableNominals).anyMatch(el -> el == nominal);
        if (!isFound) throw new NominalExeption("nominal: " + nominal);
    }

    public void deposit(int nominal, int count) throws NominalExeption {
        checkNominal(nominal);
        banknotes.addAll(
                builder.put(nominal, count).build()
        );
    }

    public List<Banknote> withdraw(int amount) throws BalanceException, WithdrawException, BanknoteAmountExeption {
        if (amount > maxWithdrawalAmount) throw new WithdrawException("maxWithdrawalAmount: " + maxWithdrawalAmount);

        List<Banknote> result = new ArrayList<>();

        // сортируем
        banknotes.sort(Comparator.comparingInt(Banknote::getNominal).reversed());

        int remaining = amount;

        for (Banknote b : banknotes) {

            if (b.getNominal() <= remaining) {
                result.add(b);
                remaining -= b.getNominal();
            }

            if (remaining == 0) break;
        }

        if (remaining != 0) {
            throw new BalanceException("remaining: " + remaining);
        }
        if (result.size() > maxBanknotesPerWithdrawal)
            throw new BanknoteAmountExeption("maxBanknotesPerWithdrawal: " + maxBanknotesPerWithdrawal);

        banknotes.removeAll(result);

        return result;
    }

    public int getTotalMoney() {
        return banknotes.stream().mapToInt(Banknote::getNominal).sum();
    }

    public int getMaxBanknotesPerWithdrawal() {
        return maxBanknotesPerWithdrawal;
    }

    public int getMaxWithdrawalAmount() {
        return maxWithdrawalAmount;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "banknotes=" + banknotes +
                '}';
    }
}
