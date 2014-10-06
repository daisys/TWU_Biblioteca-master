package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<String, Command> commands;
    private QuitCommand quitCommand;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> commands, QuitCommand quitCommand) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commands = commands;
        this.quitCommand = quitCommand;
    }

    public void displayOptions() {
        printStream.println("Main Menu");
        printStream.println("Select an Option");
        printStream.println("1: List Books \n" +
                "2: Checkout Book \n" +
                "3: Quit");
    }

    public void chooseOption(){

        while (quitCommand.shouldContinue() ) {
            String choice = readChoice();

            if(commands.containsKey(choice)){
                commands.get(choice).execute();
            }
            else {

                printStream.println("Select a valid option!");

            }
        }
    }

    private String readChoice() {
        String choice = "";
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }
}
