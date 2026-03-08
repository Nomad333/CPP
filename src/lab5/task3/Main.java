package lab5.task3;

import lab5.task3.worker.CorpWorker;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    /*
    Завдання 3. Напишіть інформаційну систему “Корпорація”. Програма повинна забезпечувати:
    введення даних;
    редагування даних співробітника корпорації;
    видалення співробітника корпорації;
    пошук співробітника корпорації за прізвищем;
    вивід інформації про усіх співробітників(за віком; за прізвищем, що розпочинається з відповідної літери).
    Організуйте можливість збереження знайденої інформації у файл - звіт. Врахувати,
     що список співробітників зберігається у файлі. При старті програми проходить завантаження
     списку співробітників корпорації із вказаного користувачем файлу. При виході з програми –
     автоматично іде перезапис інформації у файл, якщо список співробітників був оновлений.
     У процесі виконання програми за командою користувача, може бути виконано перезапис файлу,
     що містить список співробітників.

     */
    public static void main(String[] args) {
        // TODO: Closeable
        Scanner scanner = new Scanner(System.in);
        Corporation corp = new Corporation();
        var path = "lab5-3/workers.txt";
        corp.load(path);

        while (true) {

            System.out.println("""
                    1. Додати працівника
                    2. Видалити працівника
                    3. Пошук за прізвищем
                    4. Вивід за віком
                    5. Вивід за першою літерою
                    6. Показати всіх
                    7. Зберегти
                    0. Вихід
                    """);

            int cmd = scanner.nextInt();
            scanner.nextLine();

            switch (cmd) {

                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Surname: ");
                    String surname = scanner.nextLine();

                    System.out.print("Birth year: ");
                    int year = scanner.nextInt();

                    System.out.print("Birth month: ");
                    int month = scanner.nextInt();

                    System.out.print("Birth day: ");
                    int day = scanner.nextInt();
                    scanner.nextLine();

                    corp.addWorker(
                            new CorpWorker(name, surname, LocalDate.of(year, month, day))
                    );
                }

                case 2 -> {
                    System.out.print("Surname: ");
                    String surname = scanner.nextLine();
                    var res = corp.searchWorkerBy(worker -> worker.getSurname().equals(surname));
                    corp.removeWorker(res.isEmpty() ? null : res.get(0));
                }

                case 3 -> {
                    System.out.print("Surname: ");
                    String surname = scanner.nextLine();
                    corp.searchWorkerBy(worker -> worker.getSurname().equals(surname))
                            .forEach(System.out::println);
                }

                case 4 -> {
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    corp.searchWorkerBy(worker -> worker.getAge() == age)
                            .forEach(System.out::println);
                }

                case 5 -> {
                    System.out.print("Letter: ");
                    char c = scanner.nextLine().charAt(0);
                    corp.searchWorkerBy(worker -> worker.getSurname().charAt(0) == c)
                            .forEach(System.out::println);
                }

                case 6 -> corp.getWorkers().forEach(System.out::println);

                case 7 -> corp.save(path);

                case 0 -> {
                    System.out.println("Exit");
                    corp.save(path);
                    return;
                }
            }
        }
    }
}
