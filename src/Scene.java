import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by austinzhang on 5/13/17.
 */
public class Scene {
    String sceneName;
    String imageFileName;
    String message;
    HashSet<Button> buttons;
    String infoMessage;

    public Scene(String sceneName, String imageFileName, String message, HashSet<Button> buttons, String infoMessage) {
        this.sceneName = sceneName;
        this.imageFileName = imageFileName;
        this.message = message;
        this.buttons = buttons;
        this.infoMessage = infoMessage;
    }

    public Scene(String sceneName, String imageFileName, String message, HashSet<Button> buttons) {
        this.sceneName = sceneName;
        this.imageFileName = imageFileName;
        this.message = message;
        this.buttons = buttons;
        this.infoMessage = null;
    }

    public String getSceneName() {
        return sceneName;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String getMessage() {
        return message;
    }

    public HashSet<Button> getButtons() {
        return buttons;
    }

    public String getInfoMessage() {
        return infoMessage;
    }
}
