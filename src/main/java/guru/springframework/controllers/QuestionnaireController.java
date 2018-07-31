package guru.springframework.controllers;

import guru.springframework.conversion.QuestionnaireConversion;
import guru.springframework.domain.Questionnaire;
import guru.springframework.conversion.RetrieveData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionnaireController {
//    private QuestionnaireConversion questionnaireConversion;
    private RetrieveData temp = new RetrieveData();
    private String getUrl="http://localhost:8080/api/questionnaires/";

//    public void setQuestionnaireConversion(QuestionnaireConversion questionnaireConversion){
//        this.questionnaireConversion = questionnaireConversion;
//    }

    @RequestMapping("/questionnaire")
    public String searchQuestionnaires(Model model, Integer id){
        model.addAttribute("questionnaire", new Questionnaire());

        if (id == null){
            model.addAttribute("questionnaireresource","[]");
            return "questionnaireform";
        }
        String url = getUrl+id;
        System.out.println(url);
        temp.setUrl(url);
        model.addAttribute("questionnaireresource",temp.convertQuestionnnaire());

        return "questionnaireform";
    }


}
