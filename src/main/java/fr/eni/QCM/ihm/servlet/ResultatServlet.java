package ihm.servlet;

import bll.factory.ManagerFactory;
import bll.manager.PropositionsManager;
import bll.manager.QuestionsManager;
import bll.manager.Questions_TirageManager;
import bll.manager.Reponses_TirageManager;
import bo.Propositions;
import bo.Questions;
import bo.Questions_Tirage;
import bo.Reponses_Tirage;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResultatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reponses_TirageManager reponses_tirageManager = ManagerFactory.reponses_tirageManager();
        List<Reponses_Tirage> listreponses_tirage = null;
        PropositionsManager propositionsManager = ManagerFactory.propositionsManager();
        Propositions propositions = null;
        Questions_TirageManager questions_tirageManager = ManagerFactory.questions_tirageManager();
        Questions_Tirage questions_tirage = null;
        QuestionsManager questionsManager = ManagerFactory.questionsManager();
        Questions questions = null;

        try {
            listreponses_tirage = reponses_tirageManager.selectAll();

            for(Reponses_Tirage reponse : listreponses_tirage){
                propositions = propositionsManager.selectById(reponse.getIdProposition());
                req.setAttribute("bonneprop",propositions.isEstBonne());

                questions_tirage = questions_tirageManager.selectById(reponse.getIdQuestion_Tirage());
                req.setAttribute("numquestion",questions_tirage.getNumOrdre());
            }

        } catch (ManagerException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
