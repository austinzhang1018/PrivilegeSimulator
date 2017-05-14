import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by austinzhang on 5/13/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        URL url = Main.class.getResource("/Scenes");

        File file = new File(url.getPath());

        System.out.println(file.listFiles()[0].toString().substring(file.listFiles()[0].toString().lastIndexOf("/") + 1));

        StartScreen startScreen = new StartScreen();

        while (!startScreen.playerSelected()) {
            Thread.sleep(50);
        }

        Player player = startScreen.getPlayer();

        GUI gui = new GUI(player, "SampleScene");

        while (true) {
            while (!gui.nextSceneChosen()) {
                Thread.sleep(50);
            }
            gui.updateScene();
        }




 //       BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Images/MaleFemale")));


    }
}
