public class CalculateTotalValueCommand implements commands.Command {
    private Derivative derivative;

    public CalculateTotalValueCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public boolean execute() {
        System.out.println("Загальна вартість: " + derivative.calculateTotalValue());
        return true;
    }

    @Override
    public String getDesc() {
        return "Підрахунок вартості";
    }
}
