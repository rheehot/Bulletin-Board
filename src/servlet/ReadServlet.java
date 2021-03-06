package servlet;

import com.google.gson.Gson;
import database.SimpleDbBulletin;
import model.BulletinModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReadServlet", urlPatterns = "/readServlet")
public class ReadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));

            SimpleDbBulletin simpleDbBulletin = new SimpleDbBulletin();
            BulletinModel model = simpleDbBulletin.getList(id);

            Gson gson = new Gson();
            String jsonString = gson.toJson(model);

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(jsonString);
        }catch (Exception e){ e.printStackTrace(); }
    }
}
