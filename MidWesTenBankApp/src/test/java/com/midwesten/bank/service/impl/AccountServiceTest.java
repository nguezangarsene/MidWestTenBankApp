package com.midwesten.bank.service.impl;

import com.midwesten.bank.repository.IAccountRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService ;


    @Before
    public void setUp() throws Exception {
        this.accountService = new AccountService();
    }

    @After
    public void tearDown() throws Exception {
        this.accountService = null;
    }


    @Test
    public void computeNetLiquidity() {
        double actual = accountService.computeNetLiquidity();
        double expected = 184596.21;
        assertEquals(expected,actual,0.01);

    }
}