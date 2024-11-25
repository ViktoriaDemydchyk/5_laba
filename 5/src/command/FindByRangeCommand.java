import java.util.Scanner;

public class FindByRangeCommand implements commands.Command {
    private Derivative derivative;
    private Scanner scanner;

    public FindByRangeCommand(Derivative derivative, Scanner scanner) {
        this.derivative = derivative;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println("Введіть мінімальний рівень ризику:");
        double minRisk = scanner.nextDouble();
        System.out.println("Введіть максимальний рівень ризику:");
        double maxRisk = scanner.nextDouble();
        System.out.println("Результати пошуку:");
        derivative.findByRange(minRisk, maxRisk).forEach(System.out::println);
        return true;
    }

    @Override
    public String getDesc() {
        return "Пошук за діапазоном параметрів";
    }
}
