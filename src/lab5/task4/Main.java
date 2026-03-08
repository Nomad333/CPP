package lab5.task4;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    /*
    Завдання 4. Користувач вводить шлях до каталогу з файлами.
    Створіть програмний код, що дозволить створити копію файлів
    з каталогу та записати їх у новостворений каталог за шляхом,
    що вказує користувач. (Можна замінити введення даних користувачем
    на зчитування шляхів до каталогів з файлу – на розсуд студента).
     */
    public static void main(String[] args) {
        System.out.print("Enter directory: ");
        File fromDir = getDirectoryFromConsole();
        System.out.print("Enter directory path for backup copy: ");
        File toDir = getDirectoryFromConsole();
        copyDirectory(fromDir, toDir);
    }

    public static void copyDirectory(File fromDir, File toDir) {
        if (!toDir.exists()) {
            toDir.mkdirs();
        }
        File[] files = fromDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    copyDirectory(file, new File(toDir, file.getName()));
                } else {
                    try {
                        Files.copy(file.toPath(), new File(toDir, file.getName()).toPath());
                    } catch (java.io.IOException e) {
                        System.out.println("Error copying file: " + file.getName());
                    }
                }
            }
        }
    }

    public static File getDirectoryFromConsole() {
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextLine()) {
                String path = scanner.nextLine();
                File dir = new File(path);
                if (dir.exists() && dir.isDirectory()) {
                    return dir;
                } else {
                    System.out.println("Invalid path. Please try again.");
                }
            } else {
                System.out.println("No input detected. Please try again.");
                scanner.next(); // Clear the invalid input
            }
        } while (true);
    }
}
