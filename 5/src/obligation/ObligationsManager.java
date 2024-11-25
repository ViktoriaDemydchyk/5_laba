import obligation.Obligation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ObligationsManager {
    private final List<Obligation> obligations; // Список зобов'язань

    public ObligationsManager() {
        this.obligations = new ArrayList<>();
    }

    // Додати нове зобов'язання
    public void addObligation(Obligation obligation) {
        obligations.add(obligation);
        System.out.println("Облігація додана: " + obligation.getName());
    }

    // Видалити зобов'язання
    public boolean removeObligation(String name) {
        for (Obligation obligation : obligations) {
            if (obligation.getName().equalsIgnoreCase(name)) {
                obligations.remove(obligation);
                System.out.println("Облігація видалена: " + name);
                return true;
            }
        }
        System.out.println("Зобов'язання з назвою " + name + " не знайдено.");
        return false;
    }

    // Отримати список усіх зобов'язань
    public List<Obligation> getAllObligations() {
        return new ArrayList<>(obligations);
    }

    // Сортувати зобов'язання за рівнем ризику
    public void sortByRiskLevel() {
        obligations.sort(Comparator.comparingDouble(Obligation::getRiskLevel));
        System.out.println("Список зобов'язань відсортовано за рівнем ризику.");
    }

    // Обчислити загальну вартість зобов'язань
    public double calculateTotalValue() {
        double totalValue = obligations.stream()
                .mapToDouble(Obligation::getValue)
                .sum();
        System.out.println("Загальна вартість: " + totalValue);
        return totalValue;
    }

    // Знайти зобов'язання в діапазоні рівня ризику
    public List<Obligation> findByRiskRange(double minRisk, double maxRisk) {
        List<Obligation> result = obligations.stream()
                .filter(o -> o.getRiskLevel() >= minRisk && o.getRiskLevel() <= maxRisk)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("Не знайдено зобов'язань у діапазоні ризику " + minRisk + " - " + maxRisk);
        } else {
            System.out.println("Знайдені зобов'язання в діапазоні ризику:");
            result.forEach(o -> System.out.println("- " + o.getName() + ": ризик " + o.getRiskLevel()));
        }
        return result;
    }

    // Переглянути всі зобов'язання
    public void displayAllObligations() {
        if (obligations.isEmpty()) {
            System.out.println("Немає жодного зобов'язання.");
        } else {
            System.out.println("Список усіх зобов'язань:");
            obligations.forEach(o -> System.out.println("- " + o.getName() +
                    ": ризик " + o.getRiskLevel() +
                    ", вартість " + o.getValue()));
        }
    }
}
