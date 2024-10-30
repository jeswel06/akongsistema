
package aliganga;

import aliganga.JobListing;
import java.util.ArrayList;
import java.util.List;


public class JobListingService {
    private List<JobListing> jobListings = new ArrayList<>();
    private int currentId = 1;

    public void createJobListing(JobListing jobListing) {
        jobListing.setId(currentId++);
        jobListings.add(jobListing);
    }

    public List<JobListing> viewJobListings() {
        return jobListings;
    }

    public void updateJobListing(int id, JobListing updatedJob) {
        for (JobListing job : jobListings) {
            if (job.getId() == id) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setCompany(updatedJob.getCompany());
                job.setLocation(updatedJob.getLocation());
                break;
            }
        }
    }

    public void deleteJobListing(int id) {
        jobListings.removeIf(job -> job.getId() == id);
    }
}




