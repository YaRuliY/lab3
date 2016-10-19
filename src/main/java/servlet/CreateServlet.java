package servlet;
import model.Car;
import db.CarService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create", urlPatterns = { "/create" })
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarService service = new CarService();

    public CreateServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        service.insertCar(new Car(0,
                req.getParameter("company"),
                req.getParameter("model"),
                Integer.parseInt(req.getParameter("price"))));
        res.sendRedirect("http://localhost:8080/index.jsp");
    }
}