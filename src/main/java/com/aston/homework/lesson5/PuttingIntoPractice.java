package com.aston.homework.lesson5;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();

        System.out.println("1. Транзакции за 2011 год, отсортированные по сумме:");
        transactions2011.forEach(System.out::println);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();

        System.out.println("\n2. Неповторяющиеся города, в которых работают трейдеры:");
        uniqueCities.forEach(System.out::println);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

        System.out.println("\n3. Трейдеры из Кембриджа, отсортированные по именам:");
        tradersFromCambridge.forEach(System.out::println);

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String traderNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("\n4. Все имена трейдеров, отсортированные в алфавитном порядке:");
        System.out.println(traderNames);

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean anyTraderFromMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println("\n5. Есть ли трейдеры из Милана: " + anyTraderFromMilan);

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int totalValueFromCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println("\n6. Сумма всех транзакций трейдеров из Кембриджа: " + totalValueFromCambridge);

        // 7. Какова максимальная сумма среди всех транзакций?
        OptionalInt maxTransactionValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        System.out.println("\n7. Максимальная сумма среди всех транзакций: " + maxTransactionValue.orElse(0));

        // 8. Найти транзакцию с минимальной суммой.
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));

        System.out.println("\n8. Транзакция с минимальной суммой: " + minTransaction.orElse(null));
    }
}
