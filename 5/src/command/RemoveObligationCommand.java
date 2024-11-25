import java.util.Scanner;

public class RemoveObligationCommand implements Command {
    private Scanner scanner;

    public RemoveObligationCommand(Derivative derivative, Scanner scanner) {
        this.derivative = derivative;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println("Оберіть номер страхового зобов'язання для видалення:");
        int index = scanner.nextInt();
        if (index >= 0 && index < derivative.getObligations().size()) {
            derivative.removeObligation(derivative.getObligations().get(index));
            System.out.println("Зобов'язання видалено.");
        } else {
            System.out.println("Невірний номер.");
        }
        return true;
    }

    @Override
    public String getDesc() {
        return "Видалити страхове зобов'язання";
    }
}
