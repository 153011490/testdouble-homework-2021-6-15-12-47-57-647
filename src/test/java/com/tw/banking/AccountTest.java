package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class AccountTest {
    @Test
    public void should_transactionRepository_addDeposit_be_called_when_account_deposit_given_amount(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        int amount = 1;
        //when
        account.deposit(amount);
        //then
        verify(transactionRepository,times(1)).addDeposit(amount);
    }

    @Test
    public void should_transactionRepository_addWithdraw_be_called_when_account_withdraw_given_amount(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        int amount = 1;
        //when
        account.withdraw(amount);
        //then
        verify(transactionRepository,times(1)).addWithdraw(amount);
    }


    @Test
    public void should_transactionRepository_allTransactions_and_printer_print_be_called_when_account_printStatement(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        List<Transaction> transactionList = mock(List.class);
        when(transactionRepository.allTransactions()).thenReturn(transactionList);
        //when
        account.printStatement();
        //then
        verify(printer,times(1)).print(transactionList);
        verify(transactionRepository,times(1)).allTransactions();
    }
}