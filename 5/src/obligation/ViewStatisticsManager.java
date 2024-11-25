import obligation.Obligation;
import java.util.List;

public class ViewStatisticsManager {
    private final List<Obligation> obligations; // Список зобов'язань

    public ViewStatisticsManager(List<Obligation> obligations) {
        this.obligations = obligations;
    }

    // Переглянути загальну кількість зобов'язань
    public void viewTotalCount() {
        System.out.println("Загальна кількість зобов'язань: " + obligations.size());
    }

    // Переглянути загальну вартість зобов'язань
    public void viewTotalValue() {
        double totalValue = obligations.stream()
                .mapToDouble(Obligation::getValue)
                .sum();
        System.out.println("Загальна вартість зобов'язань: " + totalValue);
    }

    // Переглянути середній рівень ризику
    public void viewAverageRisk() {
        if (obligations.isEmpty()) {
            System.out.println("Немає зобов'язань для обчислення середнього рівня ризику.");
            return;
        }
        double averageRisk = obligations.stream()
                .mapToDouble(Obligation::getRiskLevel)
                .average()
                .orElse(0.0);
        System.out.println("Середній рівень ризику: " + averageRisk);
    }

    // Переглянути зобов'язання з максимальним рівнем ризику
    public void viewMaxRiskObligation() {
        obligations.stream()
                .max((o1, o2) -> Double.compare(o1.getRiskLevel(), o2.getRiskLevel()))
                .ifPresentOrElse(
                        o -> System.out.println("Зобов'язання з максимальним ризиком: " + o.getName() +
                                ", ризик: " + o.getRiskLevel()),
                        () -> System.out.println("Немає зобов'язань.")
                );
    }

    // Переглянути зобов'язання з мінімальним рівнем ризику
    public void viewMinRiskObligation() {
        obligations.stream()
                .min((o1, o2) -> Double.compare(o1.getRiskLevel(), o2.getRiskLevel()))
                .ifPresentOrElse(
                        o -> System.out.println("Зобов'язання з мінімальним ризиком: " + o.getName() +
                                ", ризик: " + o.getRiskLevel()),
                        () -> System.out.println("Немає зобов'язань.")
                );
    }

    // Загальна статистика зобов'язань
    public void displayStatistics() {
        System.out.println("==== Статистика зобов'язань ====");
        viewTotalCount();
        viewTotalValue();
        viewAverageRisk();
        viewMaxRiskObligation();
        viewMinRiskObligation();
        System.out.println("================================");
    }
}
