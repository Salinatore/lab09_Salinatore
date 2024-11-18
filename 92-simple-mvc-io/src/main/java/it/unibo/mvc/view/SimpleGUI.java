package it.unibo.mvc.view;

import it.unibo.mvc.controller.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final Controller controller = new Controller();
    private static final String TITLE = "A very simple program using a graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Crates a simpleGUI.
     */
    public SimpleGUI() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                var hasSucceed = controller.write(textArea.getText());
            }
        });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
