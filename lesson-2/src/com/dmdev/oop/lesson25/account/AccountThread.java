package com.dmdev.oop.lesson25.account;

public class AccountThread extends Thread {
    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2_000; i++) {
            lockAccounts();
            try {
                if (accountFrom.takeOOF(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }

        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountFrom.getLock().tryLock();

            if(fromLockResult && toLockResult) {
                break;
            }

            if(fromLockResult) {
                accountFrom.getLock().unlock();
            }

            if(toLockResult) {
                accountTo.getLock().unlock();
            }
        }
    }
}
