package servlet;
import db.Car;
import db.DataBase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "edit", urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DataBase dataBase = new DataBase();
        dataBase.updateCar(
                new Car(Integer.parseInt(req.getParameter("id")),
                        req.getParameter("company"),
                        req.getParameter("model"),
                        Integer.parseInt(req.getParameter("price"))));
        res.sendRedirect("http://localhost:8080/index.jsp");
    }
}