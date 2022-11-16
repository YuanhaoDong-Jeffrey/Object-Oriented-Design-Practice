package MVC.mvc.DAO;

import MVC.mvc.bean.Account;

import java.util.List;

/**
 * Dao for account
 */
public class AccountDao {

    /**
     * insert account information
     * @param act
     * @return
     */
    public int insert(Account act) {
        return 0;
    }

    /**
     * delete account by id
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return 0;
    }

    /**
     * update the account
     * @param act
     * @return
     */
    public int update(Account act) {
        return 1;
    }

    public Account selectById(Long id) {
        return null;
    }

    public Account selectByActno(String actno) {
        return null;
    }

    List<Account> selectAll() {
        return null;
    }
}
