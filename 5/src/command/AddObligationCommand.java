package command;

import obligation.*; // Імпортуємо всі типи страхових зобов'язань
import java.util.Scanner;

public class AddObligationCommand implements Command {
    private Derivative derivative; // Посилання на Derivative
    private Scanner scanner; // Сканер для введення

    public AddObligationCommand(Derivative derivative, Scanner scanner) {
        this.derivative = derivative;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println("Введіть назву:");
        String name = scanner.next();
        System.out.println("Введіть рівень ризику:");
        double riskLevel = scanner.nextDouble();
        System.out.println("Введіть вартість:");
        double value = scanner.nextDouble();

        System.out.println("Оберіть тип: 1 - Медичне, 2 - Авто, 3 - Життя");
        int type = scanner.nextInt();
        Obligation obligation;
        switch (type) {
            case 1 -> obligation = new MedicalInsurance(name, riskLevel, value);
            case 2 -> obligation = new AutoInsurance(name, riskLevel, value);
            case 3 -> obligation = new LifeInsurance(name, riskLevel, value);
            default -> {
                System.out.println("Невірний тип!");
                return true;
            }
        }
        derivative.addObligation(obligation); // Передаємо об'єкт Obligation
        System.out.println("Страхове зобов'язання додано.");
        return true;
    }

    @Override
    public String getDesc() {
        return "Додати страхове зобов'язання";
    }

    private class Derivative {
        public void addObligation(Obligation obligation) {
        }
    }
}
