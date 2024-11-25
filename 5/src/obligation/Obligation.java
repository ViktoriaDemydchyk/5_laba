package obligation;

public abstract class Obligation {
    protected String name;
    protected double riskLevel;
    protected double value;

    public Obligation(String name, double riskLevel, double value) {
        this.name = name;
        this.riskLevel = riskLevel;
        this.value = value;
    }

    public double getRiskLevel() {
        return riskLevel;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Obligation{" +
                "name='" + name + '\'' +
                ", riskLevel=" + riskLevel +
                ", value=" + value +
                '}';
    }

}
