package com.integration.account;


import com.domain.Account;
import com.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GetAccountIntegrationTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAccount() {
        accountRepository.save(new Account("TestAccount"));
        ResponseEntity<Account> response =
                restTemplate.getForEntity("/accounts/1", Account.class);
        Account account = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("TestAccount", account.getName());
    }

    @Test
    public void testGetAccountNotFound() {
        ResponseEntity<Account> response =
                restTemplate.getForEntity("/accounts/2", Account.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
