
package aliganga;

import aliganga.Applicant;
import aliganga.JobListing;
import java.util.Scanner;


import java.util.Scanner;

public class JobApplicationApp {
    private static JobListingService jobService = new JobListingService();
    private static ApplicantService applicantService = new ApplicantService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Job Listings");
            System.out.println("2. Applicants");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleJobListings();
                    break;
                case 2:
                    handleApplicants();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleJobListings() {
        while (true) {
            System.out.println("1. Create Job Listing");
            System.out.println("2. View Job Listings");
            System.out.println("3. Update Job Listing");
            System.out.println("4. Delete Job Listing");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    JobListing job = new JobListing();
                    System.out.print("Enter title: ");
                    job.setTitle(scanner.nextLine());
                    System.out.print("Enter description: ");
                    job.setDescription(scanner.nextLine());
                    System.out.print("Enter company: ");
                    job.setCompany(scanner.nextLine());
                    System.out.print("Enter location: ");
                    job.setLocation(scanner.nextLine());
                    jobService.createJobListing(job);
                    break;
                case 2:
                    System.out.println(jobService.viewJobListings());
                    break;
                case 3:
                    System.out.print("Enter job ID to update: ");
                    int idToUpdateJob = scanner.nextInt();
                    scanner.nextLine(); 
                    JobListing updatedJob = new JobListing();
                    System.out.print("Enter new title: ");
                    updatedJob.setTitle(scanner.nextLine());
                    System.out.print("Enter new description: ");
                    updatedJob.setDescription(scanner.nextLine());
                    System.out.print("Enter new company: ");
                    updatedJob.setCompany(scanner.nextLine());
                    System.out.print("Enter new location: ");
                    updatedJob.setLocation(scanner.nextLine());
                    jobService.updateJobListing(idToUpdateJob, updatedJob);
                    break;
                case 4:
                    System.out.print("Enter job ID to delete: ");
                    int idToDeleteJob = scanner.nextInt();
                    jobService.deleteJobListing(idToDeleteJob);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleApplicants() {
        while (true) {
            System.out.println("1. Create Applicant");
            System.out.println("2. View Applicants");
            System.out.println("3. Update Applicant");
            System.out.println("4. Delete Applicant");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Applicant applicant = new Applicant();
                    System.out.print("Enter name: ");
                    applicant.setName(scanner.nextLine());
                    System.out.print("Enter email: ");
                    applicant.setEmail(scanner.nextLine());
                    System.out.print("Enter phone: ");
                    applicant.setPhone(scanner.nextLine());
                    applicantService.createApplicant(applicant);
                    break;
                case 2:
                    System.out.println(applicantService.viewApplicants());
                    break;
                case 3:
                    System.out.print("Enter applicant ID to update: ");
                    int idToUpdateApplicant = scanner.nextInt();
                    scanner.nextLine(); 
                    Applicant updatedApplicant = new Applicant();
                    System.out.print("Enter new name: ");
                    updatedApplicant.setName(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    updatedApplicant.setEmail(scanner.nextLine());
                    System.out.print("Enter new phone: ");
                    updatedApplicant.setPhone(scanner.nextLine());
                    applicantService.updateApplicant(idToUpdateApplicant, updatedApplicant);
                    break;
                case 4:
                    System.out.print("Enter applicant ID to delete: ");
                    int idToDeleteApplicant = scanner.nextInt();
                    applicantService.deleteApplicant(idToDeleteApplicant);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

