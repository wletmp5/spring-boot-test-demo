package com;

import com.domain.Account;
import com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootTestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestDemoApplication.class, args);
    }

    //@Component
    public class DataLoader implements ApplicationRunner {

        private AccountRepository accountRepository;

        @Autowired
        public DataLoader(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }

        public void run(ApplicationArguments args) {
            accountRepository.save(new Account("TestAccount"));
        }
    }
}
