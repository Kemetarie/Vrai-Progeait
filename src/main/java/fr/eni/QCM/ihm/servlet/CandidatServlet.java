package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.CandidatsManager;
import bll.manager.EpreuvesManager;
import bll.manager.UtilisateursManager;
import bo.Epreuves;
import bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name="candidat", urlPatterns = {"/QCM/candidat"} )
public class CandidatServlet extends HttpServlet {

    private CandidatsManager candidatsManager = ManagerFactory.candidatsManager();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateurs user = (Utilisateurs)req.getSession(false).getAttribute("user");
        Epreuves epreuve = user.getCandidats().getEpreuves();
        req.setAttribute("epreuve", epreuve);


        req.getRequestDispatcher("/QCM/candidatJsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }

}
