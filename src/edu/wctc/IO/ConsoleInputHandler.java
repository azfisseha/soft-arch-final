package edu.wctc.IO;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    private Scanner keyboard;

    public ConsoleInputHandler() {
        this.keyboard = new Scanner(System.in);
    }

    @Override
    public String next() {
        return keyboard.next();
    }

    @Override
    public String nextLine() {
        return keyboard.nextLine();
    }

    @Override
    public int nextInt(){
        return keyboard.nextInt();
    }

    @Override
    public boolean hasNextInt() {
        return keyboard.hasNextInt();
    }
}
