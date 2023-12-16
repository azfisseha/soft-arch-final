package edu.wctc.IO;

public class ConsoleOutputHandler implements OutputHandler{

    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}
