import obligation.Obligation;

import java.util.ArrayList;
import java.util.List;

public class Derivative {
    private List<Obligation> obligations;

    public Derivative() {
        obligations = new ArrayList<>();
    }

    public void addObligation(Obligation obligation) {
        obligations.add(obligation);
    }

    public void removeObligation(Obligation obligation) {
        obligations.remove(obligation);
    }

    public List<Obligation> getObligations() {
        return obligations;
    }

    public double calculateTotalValue() {
        return obligations.stream().mapToDouble(Obligation::getValue).sum();
    }

    public void sortByRiskLevel() {
        obligations.sort((o1, o2) -> Double.compare(o1.getRiskLevel(), o2.getRiskLevel()));
    }

    public List<Obligation> findByRange(double minRisk, double maxRisk) {
        List<Obligation> result = new ArrayList<>();
        for (Obligation obligation : obligations) {
            if (obligation.getRiskLevel() >= minRisk && obligation.getRiskLevel() <= maxRisk) {
                result.add(obligation);
            }
        }
        return result;
    }

// Методи для збереження та завантаження з файлу
}