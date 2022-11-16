package MVC.mvc.Service;

import MVC.mvc.DAO.AccountDao;
import MVC.Exceptions.AppException;
import MVC.Exceptions.NoEnoughMoneyException;
import MVC.mvc.bean.Account;

public class AccountService {

    private AccountDao accountDao = new AccountDao();

    public void transfer(String fromActno, String toActno, double money) throws NoEnoughMoneyException, AppException {
        Account fromAct = accountDao.selectByActno(fromActno);

        if (fromAct.getBalance() < money) {
            throw new NoEnoughMoneyException("no enough money!");
        }

        Account toAct = accountDao.selectByActno(toActno);

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);

        if (count != 2) {
            throw new AppException("Transfer is not valid");
        }
    }


}
