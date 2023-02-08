package pl.anstar;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import pl.anstar.model.User;
import pl.anstar.repo.UserRepo;

import javax.inject.Named;

@Named
public class VistiDate implements JavaDelegate {

    private final UserRepo userRepo;

    public VistiDate(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String visitDate = "";
        visitDate = (String) delegateExecution.getVariable("visitDate");

        String patientFirstName = "";
        patientFirstName = (String) delegateExecution.getVariable("patientFirstName");

        String patientLastName = "";
        patientLastName = (String) delegateExecution.getVariable("patientLastName");

        User user = User.builder()
                .firstName(patientFirstName)
                .lastName(patientLastName)
                .data(visitDate)
                .build();

        userRepo.save(user);
    }
}
