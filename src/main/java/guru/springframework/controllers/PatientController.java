package guru.springframework.controllers;


import org.springframework.stereotype.Controller;
import guru.springframework.domain.Patient;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.conversion.RetrieveData;

@Controller
public class PatientController {
    private PatientConversion patientConversion;
    private RetrieveData temp = new RetrieveData();

    private String defaultUrl="http://localhost:8080/api/search/patients?";
    private String getAllUrl="http://localhost:8080/api/patients";
    private String queryUrl = "";
    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }


    @RequestMapping("/patient")
    public String searchPatient(Model model, String birthdate, String email, String family, String gender, String given, String identifier, String name){
        model.addAttribute("patient", new Patient());

        Boolean isNull = true;
        String url = defaultUrl;

        if(birthdate != null && !birthdate.equals("")){
            url = url+"birthdate="+birthdate+"&";
            isNull = false;
        }
        if (email != null && !email.equals("")){
            url = url+"email="+email+"&";
            isNull = false;
        }
        if (family != null && !family.equals("")){
            url = url+"family="+family+"&";
            isNull = false;
        }
        if (gender != null && !gender.equals("")){
            url = url+"gender="+gender+"&";
            isNull = false;
        }
        if (given != null && !given.equals("")){
            url = url+"given="+given+"&";
            isNull = false;
        }
        if (identifier != null && !identifier.equals("")){
            url = url+"identifier="+identifier+"&";
            isNull = false;
        }
        if (name != null && !name.equals("")){
            url = url+"name="+name+"&";
            isNull = false;
        }

        if (isNull){
            model.addAttribute("patientresource","[]");
            return "patientform";
        }
        url= url.substring(0,url.length()-1);
        System.out.println(url);

        temp.setUrl(url);
        model.addAttribute("patientresource",temp.convertPatient());

        return "patientform";
    }


}
