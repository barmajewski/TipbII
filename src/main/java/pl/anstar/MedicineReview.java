package pl.anstar;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import pl.anstar.service.EmailService;

import javax.inject.Named;

@Named
public class MedicineReview implements JavaDelegate {

    private final EmailService emailService;

    public MedicineReview(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String medicine = "";
        medicine = (String) delegateExecution.getVariable("medicine");

        String email = "";
        email = (String) delegateExecution.getVariable("email");

        String patientFirstName = "";
        patientFirstName = (String) delegateExecution.getVariable("patientFirstName");

        String patientLastName = "";
        patientLastName = (String) delegateExecution.getVariable("patientLastName");

        System.out.println(medicine);
        System.out.println(email);
        System.out.println(patientFirstName);
        System.out.println(patientLastName);


        emailService.sendMessage(email, "Recepta od lekarza",
                "Witaj "+patientFirstName+" " +patientLastName+ "!\n\n"+
                        "Lek dla ciebie: \n"+ medicine +"\n"+
                        "Dziękujemy za dołączenie do naszego serwisu!");
    }
}
