package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.tw.banking.Printer.STATEMENT_HEADER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrinterTest {

    @Test
    public void should_console_printLine_be_called_when_printer_print(){
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        List<Transaction> transactions = new ArrayList<>();

        printer.print(transactions);

        verify(console,times(1)).printLine(STATEMENT_HEADER);
    }

    @Test
    public void should_console_printLine_be_called_when_printer_printStatementLines() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        Transaction transaction = new Transaction("28/06/2021",1);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        Class<? extends Printer> clazz = printer.getClass();

        Method method = clazz.getDeclaredMethod("printStatementLines", List.class);
        method.setAccessible(true);
        method.invoke(printer,transactions);

        verify(console,times(1)).printLine(anyString());
    }

}