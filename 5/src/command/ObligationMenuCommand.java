package command;


public class ObligationMenuCommand extends Menu {
    public ObligationMenuCommand(ObligationManager obligation) {
        super(null, obligation);
    }

    @Override
    protected void init() {
        commandMap.put(1, new AddObligationCommand(obligation));
        commandMap.put(2, new RemoveObligationCommand(obligation));
        commandMap.put(3, new ViewObligationsCommand(obligation));
    }

    @Override
    public String getDesc() {
        return "Open Obligation Manager Menu";
    }

}
