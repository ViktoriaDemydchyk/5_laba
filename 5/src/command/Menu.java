package command;

import java.util.HashMap;
import java.util.Map;
import obligation.Obligation;
import utils.Utils;

public class Menu implements Command {

    private Obligation obligation;
    private Map<Integer, Command> commandMap = new HashMap<>();

    public Menu(Obligation obligation) {
        this.obligation = obligation;
        init(); // Ініціалізуємо команди
    }

    private void init() {
        // Створюємо команди для меню
        commandMap.put(1, new ObligationMenuCommand(obligation);
        commandMap.put(2, new ViewStatisticsMenuCommand(obligation);
    }

    @Override
    public void execute() {
        while (true) {
            displayMenu(); // Відображаємо меню
            int choice = Utils.enterIntValue("Select an option: ", 0, commandMap.size());
            if (choice == 0) {
                System.out.println("Exiting...");
                return; // Завершуємо роботу
            }
            Command command = commandMap.get(choice);
            if (command != null) {
                command.execute(); // Викликаємо вибрану команду
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    @Override
    public String getDesc() {
        return "Main menu";
    }

    private void displayMenu() {
        System.out.println("MENU:");
        for (var entry : commandMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getDesc());
        }
        System.out.println("0. Exit");
    }
}
