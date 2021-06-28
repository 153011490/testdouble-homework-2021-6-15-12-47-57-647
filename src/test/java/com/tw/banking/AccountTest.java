package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
}