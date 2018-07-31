package guru.springframework.controllers;

import guru.springframework.conversion.ProcedureConversion;
import guru.springframework.conversion.RetrieveData;
import guru.springframework.domain.Procedure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProcedureController {
//    private ProcedureConversion procedureConversion;
    private RetrieveData temp = new RetrieveData();
    private String getUrl="http://localhost:8080/api/procedures/";

//    public void setProcedureConversion(ProcedureConversion procedureConversion){
//        this.procedureConversion = procedureConversion;
//    }

    @RequestMapping("/procedure")
    public String searchQuestionnaires(Model model, Integer id){
        model.addAttribute("procedure", new Procedure());

        if (id == null){
            model.addAttribute("procedureresource","[]");
            return "procedureform";
        }
        String url = getUrl+id;
        System.out.println(url);
        temp.setUrl(url);
        model.addAttribute("procedureresource",temp.convertProcedure());

        return "procedureform";
    }
}
