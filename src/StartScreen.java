import PlayerAttributes.Characteristic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen implements ActionListener {
    private JFrame frame;
    private Player player;
    private Characteristic race;
    private Characteristic sex;
    private JButton sexButton;
    private JButton raceButton;

    public static void main(String[] args) {
        StartScreen screen = new StartScreen();
    }

    public StartScreen() {
        //make a window
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Privilege Simulator");
        frame.setIconImage(new ImageIcon(getClass().getResource("/Images/ScalesOfJustice.png")).getImage());
        //tell window to place each new component under the previous ones
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.getContentPane().setPreferredSize(new Dimension(600, 600));
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(new ResizableImage.ScalablePane(new ImageIcon(getClass().getResource("/Images/ScalesOfJustice.png")).getImage()));


        JLabel text = new JLabel();
        text.setText("<html>" + "Welcome to the Privilege Simulator. In this simulation, your race and sex will directly affect the outcome of your decisions and your life. Begin by selecting your race and sex. When you're ready, click begin." + "</html>");
        frame.getContentPane().add(text);
        this.raceButton = new JButton("Click to Select Race");
        this.sexButton = new JButton("Click to Select Sex");
        raceButton.addActionListener(this);
        sexButton.addActionListener(this);
        raceButton.setActionCommand("race");
        sexButton.setActionCommand("sex");
        JButton readyButton = new JButton("Begin");
        readyButton.addActionListener(this);
        readyButton.setActionCommand("ready");
        frame.getContentPane().add(raceButton);
        frame.getContentPane().add(sexButton);
        frame.getContentPane().add(readyButton);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //button was pressed

        if (e.getActionCommand().equals("race")) {
            if (raceButton.getText().equals("Black")) {
                raceButton.setText("Middle Eastern");
                race = Characteristic.MIDDLE_EASTERN;
            }
            else if(raceButton.getText().equals("Middle Eastern")) {
                raceButton.setText("Hispanic");
                race = Characteristic.HISPANIC;
            }
            else if(raceButton.getText().equals("Hispanic")) {
                raceButton.setText("Asian");
                race = Characteristic.ASIAN;
            }
            else if(raceButton.getText().equals("Asian")) {
                raceButton.setText("White");
                race = Characteristic.WHITE;
            }
            else if(raceButton.getText().equals("White")) {
                raceButton.setText("Black");
                race = Characteristic.BLACK;
            }
            else {
                raceButton.setText("White");
                race = Characteristic.WHITE;
            }
        }
        else if (e.getActionCommand().equals("sex")) {
            if (sexButton.getText().equals("Male")) {
                sexButton.setText("Female");
                sex = Characteristic.FEMALE;
            }
            else if (sexButton.getText().equals("Female")) {
                sexButton.setText("Male");
                sex = Characteristic.MALE;
            }
            else {
                sexButton.setText("Male");
                sex = Characteristic.MALE;
            }
        }
        else if (e.getActionCommand().equals("ready")) {
            if (race == null || sex == null) {
                JOptionPane.showMessageDialog(frame, "Select a race and sex before continuing.");
            }
            else {
                this.player = new Player(race, sex);
                frame.dispose();
            }
        }

    }

    public boolean playerSelected() {
        return player != null;
    }

    public Player getPlayer() {
        return player;
    }
}
