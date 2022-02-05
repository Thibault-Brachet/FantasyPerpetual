package com.sombreurs.demo2.repo;

import com.sombreurs.demo2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {


}
