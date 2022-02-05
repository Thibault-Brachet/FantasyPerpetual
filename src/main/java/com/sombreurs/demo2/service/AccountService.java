package com.sombreurs.demo2.service;

import com.sombreurs.demo2.exception.UserNotFoundException;
import com.sombreurs.demo2.model.Account;
import com.sombreurs.demo2.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountRepo accountRepo;


    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account addAccount(Account account){
        return accountRepo.save(account);
    }

    public List<Account> findAll(){
        return accountRepo.findAll();
    }

    public Account findAccountById(Long id){
        return accountRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Account with id "+id+" was not found"));
    }

    public Account updateAccount(Account account){
        return accountRepo.save(account);
    }

    public void deleteAccount(Long id){
        accountRepo.deleteById(id);
    }

}
