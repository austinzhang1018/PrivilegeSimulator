import PlayerAttributes.Characteristic;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by austinzhang on 5/13/17.
 */
public class SceneParser {

    public static Scene parseScene(String sceneName, Player player) throws IOException {
        InputStream file = SceneParser.class.getResource("/Scenes/" + sceneName + ".txt").openStream();

        return parseScene(file, player, sceneName);
    }

    private static Scene parseScene(InputStream file, Player player, String currentSceneName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String imageName = reader.readLine();
        String message = reader.readLine();
        HashSet<Button> buttons = new HashSet<Button>();
        String infoText = null;

        String text = reader.readLine();
        while (text != null) {
            if (text.contains("|Button|")) {
                String buttonText;
                HashMap<String, Integer> nextScenes = new HashMap<String, Integer>();
                text = reader.readLine();
                buttonText = text;
                text = reader.readLine();

                while (!text.contains("|ButtonEnd|")) {
                    if (text.contains("|Scene|")) {
                        String sceneName;
                        int sceneBaseFrequency;
                        text = reader.readLine();
                        sceneName = text;
                        text = reader.readLine();
                        System.out.println(text);
                        sceneBaseFrequency = Integer.parseInt(text);
                        text = reader.readLine();
                        while (!text.contains("|SceneEnd|")) {
                            Scanner scanner = new Scanner(text);
                            String characteristic = scanner.next();
                            int probabilityModifier = Integer.parseInt(scanner.next());
                            if (hasCharacteristic(characteristic, player)) {
                                sceneBaseFrequency = sceneBaseFrequency + probabilityModifier;
                            }
                            text = reader.readLine();
                        }
                        nextScenes.put(sceneName, sceneBaseFrequency);
                    }
                    text = reader.readLine();
                }

                buttons.add(new Button(buttonText, nextScenes));
            } else if (text.contains("|Info|")) {
                text = reader.readLine();
                infoText = text;
                text = reader.readLine();
            } else {
                throw new RuntimeException("Invalid Scene Input: " + file.toString());
            }

            text = reader.readLine();
        }
        return new Scene(currentSceneName, imageName, message, buttons, infoText);
    }

    private static boolean hasCharacteristic(String characteristic, Player player) {
        Characteristic playerCharacteristic;

        if (characteristic.toLowerCase().equals("male")) {
            playerCharacteristic = Characteristic.MALE;
        } else if (characteristic.toLowerCase().equals("female")) {
            playerCharacteristic = Characteristic.FEMALE;
        } else if (characteristic.toLowerCase().equals("white")) {
            playerCharacteristic = Characteristic.WHITE;
        } else if (characteristic.toLowerCase().equals("black")) {
            playerCharacteristic = Characteristic.BLACK;
        } else if (characteristic.toLowerCase().equals("middleeastern")) {
            playerCharacteristic = Characteristic.MIDDLE_EASTERN;
        } else if (characteristic.toLowerCase().equals("asian")) {
            playerCharacteristic = Characteristic.ASIAN;
        } else if (characteristic.toLowerCase().equals("hispanic")) {
            playerCharacteristic = Characteristic.HISPANIC;
        } else if (characteristic.toLowerCase().equals("poor")) {
            playerCharacteristic = Characteristic.POOR;
        } else if (characteristic.toLowerCase().equals("lowermiddle")) {
            playerCharacteristic = Characteristic.LOWER_MIDDLE;
        } else if (characteristic.toLowerCase().equals("middle")) {
            playerCharacteristic = Characteristic.MIDDLE;
        } else if (characteristic.toLowerCase().equals("uppermiddle")) {
            playerCharacteristic = Characteristic.UPPER_MIDDLE;
        } else if (characteristic.toLowerCase().equals("rich")) {
            playerCharacteristic = Characteristic.RICH;
        } else if (characteristic.toLowerCase().equals("christian")) {
            playerCharacteristic = Characteristic.CHRISTIAN;
        } else if (characteristic.toLowerCase().equals("muslim")) {
            playerCharacteristic = Characteristic.MUSLIM;
        } else if (characteristic.toLowerCase().equals("jewish")) {
            playerCharacteristic = Characteristic.JEWISH;
        } else if (characteristic.toLowerCase().equals("buddhist")) {
            playerCharacteristic = Characteristic.BUDDHIST;
        } else if (characteristic.toLowerCase().equals("hindu")) {
            playerCharacteristic = Characteristic.HINDU;
        } else if (characteristic.toLowerCase().equals("secular")) {
            playerCharacteristic = Characteristic.SECULAR;
        } else {
            throw new RuntimeException("Unrecognized Characteristic: " + characteristic.toLowerCase());
        }

        return player.hasCharacteristic(playerCharacteristic);
    }


}
