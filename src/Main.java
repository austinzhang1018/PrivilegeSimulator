import java.io.IOException;

/**
 * Created by austinzhang on 5/13/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        StartScreen startScreen = new StartScreen();

        while (!startScreen.playerSelected()) {
            Thread.sleep(50);
        }

        Player player = startScreen.getPlayer();

        //System.out.println(player.toString());

        GUI gui = new GUI(player, "EconomicStatusSelected");

        while (true) {
            while (!gui.nextSceneChosen() && !gui.isLastScene()) {
                Thread.sleep(50);
            }

            if (gui.isLastScene()) {
                break;
            }
            else {
                gui.updateScene();
            }
        }

        EndScreen endScreen = new EndScreen();

        while (endScreen.deciding()) {
            Thread.sleep(50);
        }

        if (endScreen.selectedReplay()) {
            main(null);
        }
        else {
            System.exit(0);
        }

    }
}
