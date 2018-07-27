package guru.springframework.controllers;


import org.springframework.stereotype.Controller;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import guru.springframework.conversion.PatientConversion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.conversion.RetrieveData;

@Controller
public class PatientController {
    private PatientConversion patientConversion;

    public void setPatientConversion(PatientConversion patientConversion) {
        this.patientConversion = patientConversion;
    }

//<<<<<<< HEAD
//    @RequestMapping("/patient/new")
//    public String newPatient(Model model){
//        model.addAttribute("patient", new Patient());
//        System.out.println(this);
//        return "patientform";
//    }
//
//    @RequestMapping(value = "/patient", method = RequestMethod.POST)
//        public String saveProduct(Patient patient){

    @RequestMapping("/patient/{id}")
    public String convertPatient(@PathVariable Long id, Model model){
        RetrieveData temp = new RetrieveData("http://localhost:8080/api/patients/"+id);
        model.addAttribute(temp.ConvertResponse());
        return "patientResource";
    }



}
