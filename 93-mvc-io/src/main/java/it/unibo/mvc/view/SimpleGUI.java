package it.unibo.mvc.view;

import it.unibo.mvc.api.Controller;
import it.unibo.mvc.controller.SimpleController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final Controller controller = new SimpleController();
    private static final String TITLE = "A very simple program using a graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Crates a simpleGUI.
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //NORTH
        final JTextField upperTextField = new JTextField();
        mainPanel.add(upperTextField, BorderLayout.NORTH);
        //CENTER
        final JTextArea centralTextArea = new JTextArea();
        mainPanel.add(centralTextArea, BorderLayout.CENTER);
        //SOUTH
        final JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        final JButton southShowHistoryButton = new JButton("History");
        southPanel.add(southShowHistoryButton, BorderLayout.WEST);
        final JButton southPrintButton = new JButton("Print");
        southPanel.add(southPrintButton, BorderLayout.EAST);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        //Action callers
        southPrintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextStringToPrint(upperTextField.getText());
                try {
                    controller.printStdoutCurrentString();
                } catch (IllegalStateException exception) {
                    System.out.println("No String to print...");
                }
            }
        });
        southShowHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                StringBuilder allStrings = new StringBuilder("Stings: ");
                for (var string : controller.getAllPrintedStringHistory()) {
                    allStrings.append("[");
                    allStrings.append(string);
                    allStrings.append("] ");
                }
                centralTextArea.setText(allStrings.toString());
            }
        });
        //frameSetter
        frame.setContentPane(mainPanel);
    }

    private void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
