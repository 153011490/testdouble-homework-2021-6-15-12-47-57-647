package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionRepositoryTest {

    @Test
    public void should_add_amount_when_transactionRepository_addDeposit_given_date_and_amount(){
        //given
        Clock clock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        String date = "28/06/2021";
        when(clock.todayAsString()).thenReturn(date);
        int amount = 1;
        //when
        transactionRepository.addDeposit(amount);
        //then
        Assertions.assertEquals(amount,transactionRepository.transactions.get(0).amount());
        Assertions.assertEquals(date,transactionRepository.transactions.get(0).date());
    }


}