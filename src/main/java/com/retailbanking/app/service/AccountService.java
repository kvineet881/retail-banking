package com.retailbanking.app.service;

import com.retailbanking.app.dao.AccountRepository;
import com.retailbanking.app.entity.Account;
import com.retailbanking.app.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;


    public List<Account> getAllAccounts() {
        Iterable<Account> accountList = accountRepository.findAll();


        return (List<Account>) accountList;
    }


    public Account getAccountByAcNumber(Long acNumber) throws RecordNotFoundException {
        Optional<Account> account = accountRepository.findById(acNumber);

        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RecordNotFoundException("Account Does not exist on this Account Number");
        }
    }

    public Account createOrUpdateAccount(Account entity)  {
        Optional<Account> accountNumber = accountRepository.findById(entity.getAcNumber());

        if (accountNumber.isPresent()) {
            Account newEntity = accountNumber.get();
            newEntity.setAcNumber(entity.getAcNumber());
            newEntity.setAcType(entity.getAcType());
            newEntity.setAcHolderName(entity.getAcHolderName());
            newEntity.setAcBalance(entity.getAcBalance());
            newEntity.setAcOpeningDate(entity.getAcOpeningDate());
            newEntity.setAcOpeningBalance(entity.getAcOpeningBalance());
            newEntity.setAcCustomerId(entity.getAcCustomerId());
            newEntity.setAcInterest(entity.getAcInterest());

            return accountRepository.save(newEntity);
        } else {
            return accountRepository.save(entity);
        }
    }

    public void deleteAccountById(Long id) throws RecordNotFoundException
    {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isPresent())
        {
            accountRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Account Can't be Deleted,due to invalid Account Number !");
        }
    }
}

