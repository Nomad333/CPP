package lab6.task3;

import java.time.LocalDate;

public class Main {
    /*
    Завдання 3. Створіть додаток, що емулює чергу у популярне кафе.
    Відвідувачі кафе приходять та потрапляють у чергу, якщо немає вільного місця.
    Коли столик в кафе стає вільним, перший відвідувач з черги займає його.
    Якщо приходить відвідувач, який резервував столик на певний час,
    він отримує зарезервований столик позачергово.
     */
    public static void main(String[] args) throws InterruptedException {
        Cafe cafe = new Cafe(3);

        Visitor visitor1 = new Visitor("Alice");
        Visitor visitor2 = new Visitor("Bob");
        Visitor visitor3 = new Visitor("Charlie");
        Visitor visitor4 = new Visitor("Diana");

        cafe.addVisitor(visitor1);
        cafe.addVisitor(visitor2);
        cafe.addVisitor(visitor3);
        cafe.addVisitor(visitor4);

        cafe.addReservation(visitor4, LocalDate.now().plusDays(1));

        Object lock = new Object();

        var th1 = new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            synchronized (lock) {
                                cafe.freeFirstTableAndCheckQueue();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

        var th2 = new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(3000);
                            synchronized (lock) {
                                cafe.addVisitor(visitor1);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

        var th3 = new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(3000);
                            synchronized (lock) {
                                System.out.println("-".repeat(10));
                                System.out.println("Current queue size: " + cafe.getQueue().size());
                                System.out.println("-".repeat(10));
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

        th3.start();
        th1.start();
        th2.start();

        th1.join();
        th2.join();
        th3.join();
    }
}
