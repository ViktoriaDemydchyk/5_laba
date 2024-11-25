public class SortObligationsCommand implements commands.Command {
    private Derivative derivative;

    public SortObligationsCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public boolean execute() {
        derivative.sortByRiskLevel();
        System.out.println("Сортування завершено.");
        return true;
    }

    @Override
    public String getDesc() {
        return "Сортування за рівнем ризику";
    }
}
