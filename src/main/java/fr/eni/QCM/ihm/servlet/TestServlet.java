package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.TestsManager;
import bo.Epreuves;
import bo.Utilisateurs;
import com.sun.deploy.association.utility.AppConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name="test", urlPatterns = {"/QCM/test"} )
public class TestServlet extends HttpServlet {

    private TestsManager testsManager = ManagerFactory.testsManager();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateurs user = (Utilisateurs)req.getSession(false).getAttribute("user");
        Epreuves epreuve = user.getCandidats().getEpreuves();


        req.getRequestDispatcher("/QCM/testJsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
