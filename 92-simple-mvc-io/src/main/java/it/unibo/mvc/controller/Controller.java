package it.unibo.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    /**
     * Constructor with String in input.
     *
     * @param stringPath is the path used to open the file
     */
    public Controller(final String stringPath) {
        currentFile = new File(stringPath);
    }

    /**
     * Constructor with zero element.
     */
    public Controller() {
        this(System.getProperty("user.home") + File.separator + "output.txt");
    }

    /**
     * Set Current File.
     *
     * @param currentFile will be set as the current file
     */
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * @return current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * @return current file path as a String
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Write in the current file the input given.
     *
     * @param input will be written in the current file
     * @return true if the operation as been successful
     */
    public boolean write(final String input) {
        try (PrintStream ps = new PrintStream(this.getCurrentFilePath(), StandardCharsets.UTF_8)) {
            ps.print(input);
            return true;
        } catch (IOException ioException) {
            return false;
        }
    }
}
