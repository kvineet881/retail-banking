package com.retailbanking.app.dao;

import com.retailbanking.app.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
