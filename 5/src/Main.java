import command.Menu;
import Derivative;

public class Main {
    public static void main(String[] args) {
        Derivative derivative = new Derivative();
        Menu menu = new Menu(derivative);
        menu.execute(); // Запускаємо головне меню
    }
}
