import PlayerAttributes.Characteristic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen implements ActionListener {
    private JFrame frame;
    private JButton replay;
    private JButton quit;
    private int decision;

    public EndScreen() {
        this.decision = 0;

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
        text.setText("<html>" + "This is the end of the Privilege Simulator. We hope that this game has helped you experience the different ways our race and sex can affect our lives." + "</html>");
        frame.getContentPane().add(text);
        this.replay = new JButton("Replay With Different Attributes.");
        this.quit = new JButton("Quit");
        replay.addActionListener(this);
        quit.addActionListener(this);
        replay.setActionCommand("replay");
        quit.setActionCommand("quit");
        frame.getContentPane().add(replay);
        frame.getContentPane().add(quit);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //button was pressed
        if (e.getActionCommand().equals("replay")) {
            decision = 1;
        }
        else if (e.getActionCommand().equals("quit")) {
            decision = -1;
        }
        else {
            throw new RuntimeException("Unknown Action");
        }
        frame.dispose();
    }

    public boolean deciding() {
        return decision == 0;
    }

    public boolean selectedReplay() {
        return decision == 1;
    }
}
