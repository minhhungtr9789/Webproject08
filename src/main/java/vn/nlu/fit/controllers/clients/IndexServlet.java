package vn.nlu.fit.controllers.clients;


import vn.nlu.fit.models.MenuItem;
import vn.nlu.fit.models.Product;
import vn.nlu.fit.utils.DBUtils;
import vn.nlu.fit.utils.MenuDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String errorString = null;
        List<Product> list = null;
        HttpSession session = request.getSession();
        session.setAttribute("dynamicMenu", MenuDAO.getDynamicMenu());

        MenuItem item = new MenuItem();
        item.setLink("contact.jsp");
        request.setAttribute("item", item);
        try {
            list = DBUtils.queryProduct("SELECT * FROM product WHERE (CatalogId=1 OR CatalogId=5) AND `Status` = 1 AND Top = 1");
            request.setAttribute("mobileList", list);
            list = DBUtils.queryProduct("SELECT * FROM product WHERE CatalogId=3 AND `Status` = 1 AND Top = 1");
            request.setAttribute("tabletList", list);
            list = DBUtils.queryProduct("SELECT * FROM product WHERE CatalogId=2 AND `Status` = 1 AND Top = 1");
            request.setAttribute("laptopList", list);
            list = DBUtils.queryProduct("SELECT * FROM product WHERE (CatalogId=4 OR CatalogId=9 OR CatalogId=10) AND `Status` = 1 AND Top = 1");
            request.setAttribute("phukienList", list);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}