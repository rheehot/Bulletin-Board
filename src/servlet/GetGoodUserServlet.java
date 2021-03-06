package servlet;

import com.google.gson.Gson;
import database.SimpleDbBulletin;
import model.BulletinGoodModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetGoodUserServlet", urlPatterns = "/getGoodUserServlet")
public class GetGoodUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            SimpleDbBulletin simpleDbBulletin = new SimpleDbBulletin();
            List<BulletinGoodModel> list = simpleDbBulletin.getGoodUserList(id);

            Gson gson = new Gson();
            String jsonString = gson.toJson(list);

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(jsonString);
        }catch (Exception e){ e.printStackTrace(); }
    }
}
