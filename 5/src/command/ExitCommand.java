public class ExitCommand implements commands.Command {
    @Override
    public boolean execute() {
        System.out.println("До побачення!");
        return false;
    }

    @Override
    public String getDesc() {
        return "Вихід";
    }
}
