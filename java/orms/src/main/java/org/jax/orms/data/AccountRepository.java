package org.jax.orms.data;

import org.jax.orms.data.entities.Account;

import java.util.List;

public interface AccountRepository {

    Account insertAccount(Account account);

    List<Account> insertAccount(List<Account> accounts);

    Account delete(Account account);

    void delete();

    Account find(int id);

    Account find(String word, String column);

}
