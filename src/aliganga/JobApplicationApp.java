package aliganga;

import aliganga.Applicant;
import aliganga.JobListing;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JobApplicationApp {
    private static JobListingService jobService = new JobListingService();
    private static ApplicantService applicantService = new ApplicantService();
    private static Scanner scanner = new Scanner(System.in);
    private static config dbConfig = new config(); 

  public static void main(String[] args) {
    while (true) {
        displayMainMenu();
        int choice = getUserChoice(4); 
        switch (choice) {
            case 1:
                handleJobListings();
                break;
            case 2:
                handleApplicants();
                break;
            case 3:
                handleReports();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

   private static void displayMainMenu() {
    System.out.println("--------------------------------------------------------------");
    System.out.println("                   Job Management System                      ");
    System.out.println("--------------------------------------------------------------");
    System.out.println("1. Job Listings                                               ");
    System.out.println("2. Applicants                                                 ");
    System.out.println("3. Reports                                                    ");
    System.out.println("4. Exit                                                      "); 
    System.out.println("--------------------------------------------------------------");
    System.out.print("Select an option: ");
}

    private static void handleJobListings() {
        while (true) {
            displayJobListingsMenu();
            int choice = getUserChoice(5);
            switch (choice) {
                case 1:
                    createJobListing();
                    break;
                case 2:
                    viewJobListings();
                    break;
                case 3:
                    updateJobListing();
                    break;
                case 4:
                    deleteJobListing();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayJobListingsMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("                             JOB                              ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1. Create Job Listing                                         ");
        System.out.println("2. View Job Listings                                          ");
        System.out.println("3. Update Job Listing                                         ");
        System.out.println("4. Delete Job Listing                                         ");
        System.out.println("5. Back to Main Menu                                          ");
        System.out.println("--------------------------------------------------------------");
        System.out.print("Select an option: ");
    }

    private static void createJobListing() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        System.out.print("Enter location: ");
        String loc = scanner.nextLine();
        
        double salary = 0;
        while (true) {
            System.out.print("Enter salary: ");
            try {
                salary = scanner.nextDouble();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for salary.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 
        System.out.print("Enter employment type (e.g., Full-time, Part-time): ");
        String emptype = scanner.nextLine();
        System.out.print("Enter required experience (e.g., 2 years, Entry-level): ");
        String exp = scanner.nextLine();

        String insertSql = "INSERT INTO JobListing (title, description, company, location, salary, employment_type, experience_required) VALUES (?, ?, ?, ?, ?, ?, ?)";
        dbConfig.addRecord(insertSql, title, description, company, loc, salary, emptype, exp);
        System.out.println("Job listing created successfully.");
    }

    private static void viewJobListings() {
        String viewSql = "SELECT * FROM JobListing";
        String[] jobHeaders = {"ID", "Title", "Description", "Company", "Location", "Salary", "Employment Type", "Experience Required"};
        String[] jobColumnNames = {"id", "title", "description", "company", "location", "salary", "employment_type", "experience_required"};
        dbConfig.viewRecords(viewSql, jobHeaders, jobColumnNames);
    }

    private static void updateJobListing() {
        System.out.print("Enter job ID to update: ");
        int idToUpdateJob = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new company: ");
        String newCompany = scanner.nextLine();
        System.out.print("Enter new location: ");
        String newLocation = scanner.nextLine();
        
        double newSalary = 0;
        while (true) {
            System.out.print("Enter new salary: ");
            try {
                newSalary = scanner.nextDouble();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for salary.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 
        System.out.print("Enter new employment type: ");
        String newEmploymentType = scanner.nextLine();
        System.out.print("Enter new required experience: ");
        String newExperienceRequired = scanner.nextLine();

        String updateSql = "UPDATE JobListing SET title = ?, description = ?, company = ?, location = ?, salary = ?, employment_type = ?, experience_required = ? WHERE id = ?";
        dbConfig.updateRecord(updateSql, newTitle, newDescription, newCompany, newLocation, newSalary, newEmploymentType, newExperienceRequired, idToUpdateJob);
        System.out.println("Job listing updated successfully.");
    }

    private static void deleteJobListing() {
        System.out.print("Enter job ID to delete: ");
        int idToDeleteJob = scanner.nextInt();
        String deleteSql = "DELETE FROM JobListing WHERE id = ?";
        dbConfig.deleteRecord(deleteSql, idToDeleteJob);
        System.out.println("Job listing deleted successfully.");
    }

    private static void handleApplicants() {
        while (true) {
            displayApplicantsMenu();
            int choice = getUserChoice(5);
            switch (choice) {
                case 1:
                    createApplicant();
                    break;
                case 2:
                    viewApplicants();
                    break;
                case 3:
                    updateApplicant();
                    break;
                case 4:
                    deleteApplicant();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayApplicantsMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("                       Applicants                          ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1. Create Applicant                                        ");
        System.out.println("2. View Applicants                                         ");
        System.out.println("3. Update Applicant                                        ");
        System.out.println("4. Delete Applicant                                        ");
        System.out.println("5. Back to Main Menu                                       ");
        System.out.println("-----------------------------------------------------------");
        System.out.print("Select an option: ");
    }

    private static void createApplicant() {
        Applicant applicant = new Applicant();
        System.out.print("Enter name: ");
        applicant.setName(scanner.nextLine());
        System.out.print("Enter email: ");
        applicant.setEmail(scanner.nextLine());
        System.out.print("Enter phone: ");
        applicant.setPhone(scanner.nextLine());
        System.out.print("Enter resume file path: ");
        applicant.setResume(scanner.nextLine());

        String insertApplicantSql = "INSERT INTO Applicant (name, email, phone, resume) VALUES (?, ?, ?, ?)";
        dbConfig.addRecord(insertApplicantSql, applicant.getName(), applicant.getEmail(), applicant.getPhone(), applicant.getResume());
        System.out.println("Applicant created successfully.");
    }

    private static void viewApplicants() {
        String viewApplicantSql = "SELECT * FROM Applicant";
        String[] applicantHeaders = {"ID", "Name", "Email", "Phone", "Resume", "Application Date", "Status"};
        String[] applicantColumnNames = {"id", "name", "email", "phone", "resume", "application_date", "status"};
        dbConfig.viewRecords(viewApplicantSql, applicantHeaders, applicantColumnNames);
    }

    private static void updateApplicant() {
        System.out.print("Enter applicant ID to update: ");
        int idToUpdateApplicant = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String newPhone = scanner.nextLine();
        System.out.print("Enter new resume file path: ");
        String newResume = scanner.nextLine();

        String updateApplicantSql = "UPDATE Applicant SET name = ?, email = ?, phone = ?, resume = ? WHERE id = ?";
        dbConfig.updateRecord(updateApplicantSql, newName, newEmail, newPhone, newResume, idToUpdateApplicant);
        System.out.println("Applicant updated successfully.");
    }

    private static void deleteApplicant() {
        System.out.print("Enter applicant ID to delete: ");
        int idToDeleteApplicant = scanner.nextInt();
        String deleteApplicantSql = "DELETE FROM Applicant WHERE id = ?";
        dbConfig.deleteRecord(deleteApplicantSql, idToDeleteApplicant);
        System.out.println("Applicant deleted successfully.");
    }
    private static void handleReports() {
    while (true) {
        displayReportsMenu();
        int choice = getUserChoice(3); 
        switch (choice) {
            case 1:
                viewReports(); 
                break;
            case 2:
                viewIndividualReport(); 
                break;
            case 3:
                return; 
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void displayReportsMenu() {
    System.out.println("--------------------------------------------------------------");
    System.out.println("                       Reports Menu                            ");
    System.out.println("--------------------------------------------------------------");
    System.out.println("1. View All Reports                                          ");
    System.out.println("2. View Individual Report                                     ");
    System.out.println("3. Back to Main Menu                                        ");
    System.out.println("--------------------------------------------------------------");
    System.out.print("Select an option: ");
}



private static void viewReports() {
    System.out.println("Viewing All Reports");
    String viewSql = "SELECT * FROM Reports";
    String[] reportHeaders = {"ID", "Title", "Content"};
    String[] reportColumnNames = {"id", "title", "content"};
    dbConfig.viewRecords(viewSql, reportHeaders, reportColumnNames);
}

private static void viewIndividualReport() {
    System.out.print("Enter report ID to view: ");
    int reportId = scanner.nextInt();
    scanner.nextLine(); 

    String viewSql = "SELECT * FROM Reports WHERE id = ?";
    String[] reportHeaders = {"ID", "Title", "Content"};
    String[] reportColumnNames = {"id", "title", "content"};

    
    dbConfig.viewRecords(viewSql, reportHeaders, reportColumnNames);
}


    private static int getUserChoice(int maxOption) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                if (choice < 1 || choice > maxOption) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxOption + ".");
                } else {
                    return choice;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }
    }
}