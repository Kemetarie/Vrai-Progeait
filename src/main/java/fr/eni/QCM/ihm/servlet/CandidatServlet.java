package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.CandidatsManager;
import bll.manager.EpreuvesManager;
import bll.manager.TestsManager;
import bll.manager.UtilisateursManager;
import bo.Epreuves;
import bo.Tests;
import bo.Utilisateurs;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name="candidat", urlPatterns = {"/QCM/candidat"} )
public class CandidatServlet extends HttpServlet {


    private TestsManager testsManager = ManagerFactory.testsManager();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateurs user = (Utilisateurs)req.getSession(false).getAttribute("user");
        Epreuves epreuve = user.getCandidats().getEpreuves();
        List<Tests> listeTests = null;
        try {
            listeTests = testsManager.selectAllTestsByEpreuveId(epreuve.getIdEpreuve());
        } catch (ManagerException e) {
            e.printStackTrace();
        }

        req.setAttribute("epreuve", epreuve);
        req.setAttribute("listeTests", listeTests);

        req.getRequestDispatcher("/QCM/candidatjsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }

}
