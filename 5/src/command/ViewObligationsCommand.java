public class ViewObligationsCommand implements commands.Command {
    private Derivative derivative;

    public ViewObligationsCommand(Derivative derivative) {
        this.derivative = derivative;
    }

    @Override
    public boolean execute() {
        System.out.println("Список страхових зобов'язань:");
        for (int i = 0; i < derivative.getObligations().size(); i++) {
            System.out.println(i + ". " + derivative.getObligations().get(i));
        }
        return true;
    }

    @Override
    public String getDesc() {
        return "Перегляд списку";
    }
}
