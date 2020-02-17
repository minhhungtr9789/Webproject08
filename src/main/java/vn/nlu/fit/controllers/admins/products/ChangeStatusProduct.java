package vn.nlu.fit.controllers.admins.products;

import vn.nlu.fit.models.Product;
import vn.nlu.fit.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/product/changeStatusProduct")
public class ChangeStatusProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("id");

        Product p = null;
        try {
            p = DBUtils.findProduct(code);
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        try {
            if (p != null) {
                p.changeStatus();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

