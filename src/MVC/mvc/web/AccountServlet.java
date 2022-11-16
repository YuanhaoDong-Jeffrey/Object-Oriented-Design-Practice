package MVC.mvc.web;

import MVC.Exceptions.AppException;
import MVC.Exceptions.NoEnoughMoneyException;
import MVC.mvc.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccountServlet extends HttpServlet {

    private AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // data
        String fromAct = request.getParameter("fromAct");
        String toAct = request.getParameter("toAct");
        double money = Double.parseDouble(request.getParameter("money"));

        // Service
        try {
            accountService.transfer(fromAct, toAct, money);

            response.sendRedirect(request.getContextPath() + "success.jsp");
        } catch (NoEnoughMoneyException e) {
            //
            response.sendRedirect(request.getContextPath() + "/moneyNotEnough.jsp");
        } catch (AppException e) {
            response.sendRedirect(request.getContextPath() + "error.jsp");
        }
    }
}
