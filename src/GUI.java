import java.awt.*;
import java.awt.event.*;  //for ActionListener, ActionEvent
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;  //for JFrame, BoxLayout, JLabel, JTextField, JButton

public class GUI implements ActionListener {
    private JFrame frame;
    private Scene currentScene;
    private Scene nextScene;
    private Player player;
    private boolean lastScene;

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI(null, null);
    }

    public GUI(Player player, String startingSceneName) throws IOException {
        this.player = player;
        this.lastScene = false;

        //make a window
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Privilege Simulator");
        frame.setIconImage(new ImageIcon(getClass().getResource("/Images/ScalesOfJustice.png")).getImage());
        //tell window to place each new component under the previous ones
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        frame.getContentPane().setPreferredSize(new Dimension(600, 600));
        frame.setLocationRelativeTo(null);


        URL url = Main.class.getResource("/Scenes");
        File file = new File(url.getPath());
        File[] scenes = file.listFiles();

        if (scenes == null) {
            throw new RuntimeException("Scenes is null for some reason. File structure probably messed up or there's no scenes");
        }

        if (scenes.length != 0) {
            for (File scene : scenes) {
                String scenePath = scene.toString();
                String sceneName = scenePath.substring(scenePath.lastIndexOf("/") + 1, scenePath.lastIndexOf("."));
                if (startingSceneName.toLowerCase().equals(sceneName.toLowerCase())) {
                    currentScene = SceneParser.parseScene(sceneName, player);
                    break;
                }
            }
        }

        update();

    }

    public void updateScene() {
        this.currentScene = nextScene;
        this.nextScene = null;
        update();
    }


    public void update() {
        frame.getContentPane().removeAll();

        //add some text

        frame.getContentPane().add(new ResizableImage.ScalablePane(new ImageIcon(getClass().getResource("/Images/" + currentScene.getImageFileName())).getImage()));

        JLabel text = new JLabel();
        text.setText("<html>" + currentScene.message + "</html>");

        frame.getContentPane().add(text);

        for (Button button : currentScene.getButtons()) {
            //add buttons
            JButton jButton = new JButton(button.getButtonText());

            //tell button to call this object's actionPerformed method when pressed
            jButton.addActionListener(this);

            //store text in button that can be retrieved in actionPerformed method
            jButton.setActionCommand(button.getButtonText());

            frame.getContentPane().add(jButton);
        }

        if (currentScene.infoMessage != null) {
            JButton jButton = new JButton("Info");
            jButton.addActionListener(this);
            jButton.setActionCommand("Info");
            frame.getContentPane().add(jButton);
        }


        frame.pack();
        frame.repaint();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //button was pressed

        for (Button button : currentScene.getButtons()) {
            if (e.getActionCommand().equals(button.getButtonText())) {
                //we now know which button was pressed

                //END STORY
                if (button.getNextSceneName().toLowerCase().equals("EndScene".toLowerCase())) {
                    frame.dispose();
                    setLastScene(true);
                    break;
                }
                else {
                    try {
                        nextScene = SceneParser.parseScene(button.getNextSceneName(), player);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        if (e.getActionCommand().equals("Info")) {
            JOptionPane.showMessageDialog(frame, "<html>" + currentScene.infoMessage + "</html>");
        }

    }

    private void setLastScene(boolean b) {
        lastScene = b;
    }

    public boolean isLastScene() {
        return lastScene;
    }

    public boolean nextSceneChosen() {
        return nextScene != null;
    }

    //Gets the next scene
    public Scene getNextScene() {
        return nextScene;
    }
}
