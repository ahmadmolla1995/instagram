package instagram.repository;

import instagram.model.Account;


public class AccountRepository extends CrudRepository<Account, Long> {
    private static AccountRepository accountRepository;

    private AccountRepository() {}

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }

    public static AccountRepository getInstance() {
        if (accountRepository == null)
            accountRepository = new AccountRepository();
        return accountRepository;
    }
}