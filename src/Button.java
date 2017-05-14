import java.util.HashMap;
import java.util.zip.CRC32;

/**
 * Created by austinzhang on 5/13/17.
 */
public class Button {
    private String buttonText;
    //Stores each next scene and their respective probabilities of occurring
    private HashMap<String, Integer> nextScenes;

    public Button(String buttonText, HashMap<String, Integer> nextScenes) {
        this.buttonText = buttonText;
        this.nextScenes = nextScenes;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getNextSceneName() {
        int totalValue = 0;
        for (String scene : nextScenes.keySet()) {
            totalValue = totalValue + nextScenes.get(scene);
        }

        int choiceNum = (int) (Math.random() * totalValue);

        for (String scene : nextScenes.keySet()) {
            for (int i = 0; i < nextScenes.get(scene); i++) {
                choiceNum--;
            }
            if (choiceNum < 0) {
                return scene;
            }
        }

        throw new RuntimeException("BUTTON GET NEXT SCENE METHOD IS BROKEN");
    }

    @Override
    public boolean equals(Object other) {
        return buttonText.equals(((Button)other).buttonText);
    }

    @Override
    public int hashCode() {
        CRC32 hashCode = new CRC32();
        hashCode.update(buttonText.getBytes());
        return (int) hashCode.getValue();
    }

}
