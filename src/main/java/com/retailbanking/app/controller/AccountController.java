package com.retailbanking.app.controller;

import com.retailbanking.app.entity.Account;
import com.retailbanking.app.exception.RecordNotFoundException;
import com.retailbanking.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = accountService.getAllAccounts();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/createAccount")
    public ResponseEntity<Account> createOrUpdateEmployee(@RequestBody Account account) {

        Account updated = accountService.createOrUpdateAccount(account);
        return new ResponseEntity(updated, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/getAccountByAcNumber")
    public Account getEmployeeById(@RequestParam("acNumber") Long acNumber) throws RecordNotFoundException
    {
        return accountService.getAccountByAcNumber(acNumber);
    }
    @DeleteMapping("/deleteAcById")
    public String deleteAccountById(@RequestParam("acNumber") Long id) throws RecordNotFoundException {
            accountService.deleteAccountById(id);
        return "Account Deleted Successfully !";
    }

}