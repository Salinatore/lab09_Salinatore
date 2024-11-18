package it.unibo.mvc.view;

import it.unibo.mvc.controller.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final Controller controller = new Controller();
    private static final String TITLE = "Graphical interface with file chooser";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Crates a simpleGUI with FileChooser though JFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //North part
        final JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        final JTextField textFieldForPath = new JTextField(controller.getCurrentFilePath());
        textFieldForPath.setEditable(false);
        final JButton fileChooserButton = new JButton("Brows...");
        topPanel.add(textFieldForPath, BorderLayout.WEST);
        topPanel.add(fileChooserButton, BorderLayout.EAST);
        //Central part
        final JTextArea centralTextArea = new JTextArea("Write here");
        panel.add(centralTextArea, BorderLayout.CENTER);
        //South part
        final JButton saveButton = new JButton("Save");
        panel.add(saveButton, BorderLayout.SOUTH);
        //actions
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.write(centralTextArea.getText());
            }
        });
        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int returnVal = fileChooser.showOpenDialog(fileChooserButton);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textFieldForPath.setText(controller.getCurrentFilePath());
                }
            }
        });
        //frame setters
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
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
        new SimpleGUIWithFileChooser().display();
    }
}
