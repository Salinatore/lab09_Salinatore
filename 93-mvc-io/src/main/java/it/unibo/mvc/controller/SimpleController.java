package it.unibo.mvc.controller;

import it.unibo.mvc.api.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> allAllPrintedStringHistory = new ArrayList<>();

    @Override
    public void setNextStringToPrint(final String nextStringToPrint) {
        this.currentString = nextStringToPrint;
    }

    @Override
    public String getNextStringToPrint() {
        return this.currentString;
    }

    @Override
    public List<String> getAllPrintedStringHistory() {
        return List.copyOf(this.allAllPrintedStringHistory);
    }

    @Override
    public void printStdoutCurrentString() {
        if (Objects.isNull(this.currentString)) {
            throw new IllegalStateException("String must be not null");
        } else {
            System.out.println(this.currentString); // NOPMD: is just an exercise
            allAllPrintedStringHistory.add(this.currentString);
            this.currentString = null;
        }
    }
}
