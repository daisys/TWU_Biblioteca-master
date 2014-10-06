package com.twu.biblioteca;



import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private BufferedReader bufferedReader;
    private QuitCommand quitCommand;
    private Map<String, Command> commandMap;
    private Command command;

    @Before
    public void setUp() {

        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        quitCommand = mock(QuitCommand.class);

        command = mock(Command.class);
        commandMap = new HashMap<String, Command>();
        commandMap.put("1",command);
        commandMap.put("2", quitCommand);


        menu = new Menu(printStream, bufferedReader, commandMap, quitCommand);
    }

    @Test
    public void shouldDisplayOptions() throws IOException {
        menu.displayOptions();

        verify(printStream).println("1: List Books \n2: Checkout Book \n3: Quit");
    }

    @Test
    public void shouldExecuteCommandWhenUserEntersOneThenQuits() throws IOException {

        when(bufferedReader.readLine()).thenReturn("1");
        when(quitCommand.shouldContinue()).thenReturn(true, false);

        menu.chooseOption();

        verify(commandMap.get("1")).execute();

    }


    @Test
    public void shouldNotifyUserWhenInvalidChoiceIsSelected() throws IOException {

        Map<String, Command> map = mock(Map.class);
        menu = new Menu(printStream, bufferedReader, map, quitCommand);

        when(map.containsKey(anyString())).thenReturn(false);
        when(quitCommand.shouldContinue()).thenReturn(true, false);

        menu.chooseOption();

        verify(printStream).println("Select a valid option!");
    }



}