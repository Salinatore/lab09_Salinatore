package it.unibo.mvc.api;

import java.util.List;

/**
 * Model a simple controller responsible for I/O access.
 * It considers only the standard output,
 * and it is able to print on it.
 */
public interface Controller {

    /**
     * Set the next String to be outputted in stdout.
     * @param nextStringToPrint will be set as the next outputted string
     */
    void setNextStringToPrint(String nextStringToPrint);

    /**
     * Peeks at the current string to be printed in stdout.
     * @return the next string to be printed
     */
    String getNextStringToPrint();

    /**
     * Gets the history of the printed strings.
     * @return all printed strings
     */
    List<String> getAllPrintedStringHistory();

    /**
     * Prints in stdout the current string.
     * @throws IllegalStateException if the current string is unset
     */
    void printStdoutCurrentString() throws IllegalStateException;

}
