
package aliganga;

import aliganga.Applicant;
import java.util.ArrayList;
import java.util.List;


public class ApplicantService {
    private List<Applicant> applicants = new ArrayList<>();
    private int currentId = 1;

    public void createApplicant(Applicant applicant) {
        applicant.setId(currentId++);
        applicants.add(applicant);
    }

    public List<Applicant> viewApplicants() {
        return applicants;
    }

    public void updateApplicant(int id, Applicant updatedApplicant) {
        for (Applicant app : applicants) {
            if (app.getId() == id) {
                app.setName(updatedApplicant.getName());
                app.setEmail(updatedApplicant.getEmail());
                app.setPhone(updatedApplicant.getPhone());
                break;
            }
        }
    }

    public void deleteApplicant(int id) {
        applicants.removeIf(app -> app.getId() == id);
    }
}
