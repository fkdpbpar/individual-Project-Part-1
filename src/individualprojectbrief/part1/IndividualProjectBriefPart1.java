package individualprojectbrief.part1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IndividualProjectBriefPart1 {

    public static void main(String[] args) {
        System.out.println("Welcome to the project of Theofanis Kollias");
        ArrayList<Course> arrayOfCourses = new ArrayList();
        ArrayList<Trainer> arrayOfTrainers = new ArrayList();
        ArrayList<Student> arrayOfStudents = new ArrayList();
        ArrayList<Assignment> arrayOfAssignments = new ArrayList();
        boolean flagCourse = false;
        boolean flagTrainer = false;
        boolean flagStudent = false;
        boolean flagAssignment = false;
        //Insertion of number of courses
        Scanner scanner = new Scanner(System.in);

        printMessage("What would you like to insert?(Type Courses/Students/Trainers/Assignments/Courses and Assignments e.g.)");
        String whatToInsert = scanner.nextLine();
        whatToInsert = whatToInsert.toLowerCase();
        while (!whatToInsert.contains("course") && !whatToInsert.contains("student") && !whatToInsert.contains("trainer") && !whatToInsert.contains("assignment")) {
            System.out.println("Invalid word, please try again");
            whatToInsert = scanner.nextLine();
        }
        if (whatToInsert.indexOf("course") != -1) {
            flagCourse = true;
            int numOfCourses;
            do {
                printMessage("How many courses would you like to insert?(if you type 0,the program should use synthetic data)");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a number.Try again\n", input);
                }
                numOfCourses = scanner.nextInt();
            } while (numOfCourses < 0);
            System.out.printf("You have entered the valid number %d.\n", numOfCourses);
            if (numOfCourses == 0) {
                Course c1 = new Course("CB1", "JAVA", "FULL TIME", "25-03-2020", "25-06-2020");
                Course c2 = new Course("CB2", "C++", "PART TIME", "29-03-2020", "29-06-2020");
                arrayOfCourses.add(c1);
                arrayOfCourses.add(c2);
            } else {

                //Insertion of course details
                for (int i = 0; i < numOfCourses; i++) {
                    printMessage("Let's add a new Course.");
                    System.out.print("Please give the title of course: ");
                    String title = scanner.next();
                    System.out.print("Please give the stream of course: ");
                    String stream = scanner.next();
                    System.out.print("Please give the type of course: ");
                    String type = scanner.next();
                    int day;
                    do {
                        System.out.print("Give day of the starting date of the course (e.g 15): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        day = scanner.nextInt();
                    } while (day < 01 || day > 31);

                    int month;
                    do {
                        System.out.print("Give month of the starting date of the course (e.g 04): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        month = scanner.nextInt();
                    } while (month < 01 || month > 13);

                    int year;
                    do {
                        System.out.print("Give year of the starting date of the course (e.g 2020): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        year = scanner.nextInt();
                    } while (year < 2020 || year > 2050);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String format = String.format("%d-%d-%d", day, month, year);
                    if (day > 9 && month > 9) {
                        format = String.format("%d-%d-%d", day, month, year);
                    } else if (day < 10 && month > 9) {
                        format = String.format("0%d-%d-%d", day, month, year);
                    } else if (day < 10 && month < 10) {
                        format = String.format("0%d-0%d-%d", day, month, year);
                    } else if (day > 9 && month < 10) {
                        format = String.format("%d-0%d-%d", day, month, year);
                    }
                    LocalDate dateFromString = LocalDate.parse(format, formatter);
                    String startDate = dateFromString.format(formatter);
                    Period period = Period.ofMonths(3);
                    dateFromString = dateFromString.plus(period);
                    String endDate = dateFromString.format(formatter);
                    Course c = new Course(title, stream, type, startDate, endDate);
                    arrayOfCourses.add(c);
                }
            }
            printMessage("Would you like to print the list of Courses?(Type Yes/No)");
            String printListOfCourses = scanner.next();
            printListOfCourses = printListOfCourses.toLowerCase();
            while (!printListOfCourses.equals("yes") && !printListOfCourses.equals("no")) {
                printMessage("Invalid word, please try again");
                printListOfCourses = scanner.next();
            }
            if (printListOfCourses.equals("yes")) {
                System.out.println(arrayOfCourses);
            }
        }
        //Insertion of number of trainers
        if (whatToInsert.indexOf("trainer") != -1) {
            flagTrainer = true;
            int numOfTrainers;
            do {
                printMessage("How many trainers would you like to insert?(if you type 0,the program should use synthetic data) ");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a number.Try again\n", input);
                }
                numOfTrainers = scanner.nextInt();
            } while (numOfTrainers < 0);

            System.out.printf("You have entered the valid number %d.\n", numOfTrainers);
            if (numOfTrainers == 0) {
                Trainer t1 = new Trainer("LEONIDAS", "SOURTIS", "JAVA");
                Trainer t2 = new Trainer("ACHILLEAS", "PAPAZOGLOU", "C++");
                arrayOfTrainers.add(t1);
                arrayOfTrainers.add(t2);
            } else {
                //Insertion of trainers details
                for (int i = 0; i < numOfTrainers; i++) {
                    printMessage("Let's add a new trainer.");
                    System.out.print("Please insert the first name of trainer: ");
                    String firstName = scanner.next();
                    System.out.print("Please insert the last name of trainer: ");
                    String lastName = scanner.next();
                    System.out.print("Please insert the subject of trainer: ");
                    String subject = scanner.next();
                    Trainer t = new Trainer(firstName, lastName, subject);
                    arrayOfTrainers.add(t);
                }
            }

            printMessage("Would you like to print the list of Trainers?(Type Yes/No)");
            String printListOfTrainers = scanner.next();
            printListOfTrainers = printListOfTrainers.toLowerCase();
            while (!printListOfTrainers.equals("yes") && !printListOfTrainers.equals("no")) {
                printMessage("Invalid word, please try again");
                printListOfTrainers = scanner.next();
            }
            if (printListOfTrainers.equals("yes")) {
                System.out.println(arrayOfTrainers);
            }
        }
        //Insertion of number of students
        if (whatToInsert.indexOf("student") != -1) {
            flagStudent = true;
            int numOfStudents;
            do {
                System.out.print("How many students would you like to insert?(if you type 0,the program should use synthetic data) ");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a number.Try again\n", input);
                }
                numOfStudents = scanner.nextInt();
            } while (numOfStudents < 0);

            System.out.printf("You have entered the valid number %d.\n", numOfStudents);
            if (numOfStudents == 0) {
                Student s1 = new Student("GIORGOS", "ARVANITIS", 3000, "1987-12-08");
                Student s2 = new Student("DIMITRIS", "RAPTOPOULOS", 2500, "1960-06-19");
                arrayOfStudents.add(s1);
                arrayOfStudents.add(s2);
            } else {
                //Insertion of students details
                for (int i = 0; i < numOfStudents; i++) {
                    printMessage("Let's add a new student.");
                    System.out.print("Please insert the first name of student: ");
                    String firstName = scanner.next();
                    System.out.print("Please insert the last name of student: ");
                    String lastName = scanner.next();

                    int tuitionFees;
                    do {
                        System.out.print("Please give the tuition fees of student:  ");
                        while (!scanner.hasNextInt()) {
                            String input = scanner.next();
                            System.out.printf("\"%s\" is not a number.Try again\n", input);
                        }
                        tuitionFees = scanner.nextInt();
                    } while (tuitionFees < 0);
                    int day;
                    do {
                        System.out.print("Please insert day of your date of birth (e.g 15): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        day = scanner.nextInt();
                    } while (day < 01 || day > 31);

                    int month;
                    do {
                        System.out.print("Please insert month of your date of birth  (e.g 04): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        month = scanner.nextInt();
                    } while (month < 01 || month > 13);

                    int year;
                    do {
                        System.out.print("Please insert year of your date of birth (e.g 1998): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        year = scanner.nextInt();
                    } while (year < 1900 || year > 2021);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String dateOfBirth = String.format("%d-%d-%d", day, month, year);
                    if (day > 9 && month > 9) {
                        dateOfBirth = String.format("%d-%d-%d", day, month, year);
                    } else if (day < 10 && month > 9) {
                        dateOfBirth = String.format("0%d-%d-%d", day, month, year);
                    } else if (day < 10 && month < 10) {
                        dateOfBirth = String.format("0%d-0%d-%d", day, month, year);
                    } else if (day > 9 && month < 10) {
                        dateOfBirth = String.format("%d-0%d-%d", day, month, year);
                    }
                    Student s = new Student(firstName, lastName, tuitionFees, dateOfBirth);
                    arrayOfStudents.add(s);
                }
            }

            printMessage("Would you like to print the list of Students?(Type Yes/No)");
            String printListOfStudents = scanner.next();
            printListOfStudents = printListOfStudents.toLowerCase();
            while (!printListOfStudents.equals("yes") && !printListOfStudents.equals("no")) {
                printMessage("Invalid word, please try again");
                printListOfStudents = scanner.next();
            }
            if (printListOfStudents.equals("yes")) {
                System.out.println(arrayOfStudents);
            }
        }

        //Insertion of number of Assignments
        if (whatToInsert.indexOf("assignment") != -1) {
            flagAssignment = true;
            int numOfAssignments;
            do {
                System.out.print("How many assignments would you like to insert?(if you type 0,the program should use synthetic data)");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a number.Try again\n", input);
                }
                numOfAssignments = scanner.nextInt();
            } while (numOfAssignments < 0);

            System.out.printf("You have entered the valid number %d.\n", numOfAssignments);
            if (numOfAssignments == 0) {
                Assignment a1 = new Assignment("METHODS IN JAVA", "DEVELPMENT OF METHODS IN JAVA", 9, "24-04-2020");
                Assignment a2 = new Assignment("METHODS IN C++", "DEVELPMENT OF METHODS IN C++", 6, "29-04-2020");
                arrayOfAssignments.add(a1);
                arrayOfAssignments.add(a2);
            } else {

                //Insertion of assignments details
                for (int i = 0; i < numOfAssignments; i++) {
                    printMessage("Let's add a new assignment.");
                    System.out.print("Please give the title of assignment: ");
                    String title = scanner.next();
                    System.out.print("Please give the description of assignment: ");
                    String description = scanner.next();

                    int totalMark;
                    do {
                        System.out.print("Please give the total mark of assignment(0-10)(if it is not given yet please insert number -1):  ");
                        while (!scanner.hasNextInt()) {
                            String input = scanner.next();
                            System.out.printf("\"%s\" is not a number.Try again\n", input);
                        }
                        totalMark = scanner.nextInt();
                    } while (totalMark < -1 || totalMark > 10);
                    int day;
                    do {
                        System.out.print("Please insert a day of the submission day (e.g 15): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        day = scanner.nextInt();
                    } while (day < 01 || day > 31);

                    int month;
                    do {
                        System.out.print("Please insert month of the submission day  (e.g 04): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        month = scanner.nextInt();
                    } while (month < 01 || month > 13);

                    int year;
                    do {
                        System.out.print("Please insert year of the submission day (e.g 2021): ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a number:");
                            scanner.next();
                        }
                        year = scanner.nextInt();
                    } while (year < 1900 || year > 2021);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String subDateTime = String.format("%d-%d-%d", day, month, year);
                    if (day > 9 && month > 9) {
                        subDateTime = String.format("%d-%d-%d", day, month, year);
                    } else if (day < 10 && month > 9) {
                        subDateTime = String.format("0%d-%d-%d", day, month, year);
                    } else if (day < 10 && month < 10) {
                        subDateTime = String.format("0%d-0%d-%d", day, month, year);
                    } else if (day > 9 && month < 10) {
                        subDateTime = String.format("%d-0%d-%d", day, month, year);
                    }
                    Assignment a = new Assignment(title, description, totalMark, subDateTime);
                    arrayOfAssignments.add(a);
                }
            }

            printMessage("Would you like to print the list of Assignments?(Type Yes/No)");
            String printListOfAssignments = scanner.next();
            printListOfAssignments = printListOfAssignments.toLowerCase();
            while (!printListOfAssignments.equals("yes") && !printListOfAssignments.equals("no")) {
                printMessage("Invalid word, please try again");
                printListOfAssignments = scanner.next();
            }
            if (printListOfAssignments.equals("yes")) {
                System.out.println(arrayOfAssignments);
            }
        }
        //LIST TRAINERS PER COURSE
        if (flagCourse == true && flagTrainer == true) {
            ArrayList<String> trainersInCoursesList = new ArrayList();
            ArrayList<Trainer> trainersInCourses = new ArrayList();
            int counter = 0;
            for (int a = 0; a < arrayOfCourses.size(); a++) {
                for (int i = 0; i < arrayOfTrainers.size(); i++) {
                    printMessage("Would you like the " + arrayOfTrainers.get(i) + " to teach in the " + arrayOfCourses.get(a) + " ?(Yes/No)");
                    String printTrainersInCourses = scanner.next();
                    printTrainersInCourses = printTrainersInCourses.toLowerCase();
                    while (!printTrainersInCourses.equals("yes") && !printTrainersInCourses.equals("no")) {
                        printMessage("Invalid word, please try again");
                        printTrainersInCourses = scanner.next();
                    }
                    if (printTrainersInCourses.equals("yes")) {
                        trainersInCourses.add(arrayOfTrainers.get(i));
                        trainersInCoursesList.add(String.format(trainersInCourses.get(counter) + "will teach in the " + arrayOfCourses.get(a)));
                        counter++;
                    }
                }
            }
            printMessage("Would you like to print the list of trainers in courses?(Type Yes/No)");
            String printTrainersInCoursesList = scanner.next();
            printTrainersInCoursesList = printTrainersInCoursesList.toLowerCase();
            while (!printTrainersInCoursesList.equals("yes") && !printTrainersInCoursesList.equals("no")) {
                printMessage("Invalid word, please try again");
                printTrainersInCoursesList = scanner.next();
            }
            if (printTrainersInCoursesList.equals("yes")) {
                for (int i = 0; i < trainersInCoursesList.size(); i++) {
                    System.out.println(trainersInCoursesList.get(i));
                }
            }
        }
        //LIST STUDENTS PER COURSE
        if (flagCourse == true && flagStudent == true) {
            ArrayList<Student> studentsInCourses = new ArrayList();
            ArrayList<String> studentsInCoursesList = new ArrayList();
            Set<Student> listWithDuplicatedStudentsInCourse = new HashSet<>();
            int counter1 = 0;
            for (int b = 0; b < arrayOfCourses.size(); b++) {
                for (int i = 0; i < arrayOfStudents.size(); i++) {
                    printMessage("Would you like the " + arrayOfStudents.get(i) + " to participate in the " + arrayOfCourses.get(b) + " ?(Yes/No)");
                    String printStudentsInCourses = scanner.next();
                    printStudentsInCourses = printStudentsInCourses.toLowerCase();
                    while (!printStudentsInCourses.equals("yes") && !printStudentsInCourses.equals("no")) {
                        printMessage("Invalid word, please try again");
                        printStudentsInCourses = scanner.next();
                    }
                    if (printStudentsInCourses.equals("yes")) {
                        studentsInCourses.add(arrayOfStudents.get(i));
                        studentsInCoursesList.add(String.format(studentsInCourses.get(counter1) + "will participate in the " + arrayOfCourses.get(b)));
                        counter1++;
                    }
                }
            }
            printMessage("Would you like to print the list of students in courses?(Type Yes/No)");
            String printStudentsInCoursesList = scanner.next();
            printStudentsInCoursesList = printStudentsInCoursesList.toLowerCase();
            while (!printStudentsInCoursesList.equals("yes") && !printStudentsInCoursesList.equals("no")) {
                printMessage("Invalid word, please try again");
                printStudentsInCoursesList = scanner.next();
            }
            if (printStudentsInCoursesList.equals("yes")) {
                for (int i = 0; i < studentsInCoursesList.size(); i++) {
                    System.out.println(studentsInCoursesList.get(i));
                }
            }
            printMessage("Would you like to print the students who belong to more than one course?(Type Yes/No)");
            String printKeepDuplicatesFromStudentsInCourse = scanner.next();
            printKeepDuplicatesFromStudentsInCourse = printKeepDuplicatesFromStudentsInCourse.toLowerCase();
            while (!printKeepDuplicatesFromStudentsInCourse.equals("yes") && !printKeepDuplicatesFromStudentsInCourse.equals("no")) {
                printMessage("Invalid word, please try again");
                printKeepDuplicatesFromStudentsInCourse = scanner.next();
            }
            if (printKeepDuplicatesFromStudentsInCourse.equals("yes")) {
                for (Student duplicatedStudents : studentsInCourses) {
                    if (listWithDuplicatedStudentsInCourse.add(duplicatedStudents) == false) {
                        printMessage("the students who belong to more than one course are: " + duplicatedStudents);
                    }
                }
            }

        }

        //LIST ASSIGNMENTS PER COURSE
        if (flagCourse == true && flagAssignment == true) {
            ArrayList<Assignment> assignmentsInCourses = new ArrayList();
            ArrayList<String> assignmentsInCoursesList = new ArrayList();
            int counter2 = 0;
            for (int b = 0; b < arrayOfCourses.size(); b++) {
                for (int i = 0; i < arrayOfAssignments.size(); i++) {
                    printMessage("Would you like the " + arrayOfAssignments.get(i) + " to introduce into the " + arrayOfCourses.get(b) + " ?(Yes/No)");
                    String printAssignmentsInCourses = scanner.next();
                    printAssignmentsInCourses = printAssignmentsInCourses.toLowerCase();
                    while (!printAssignmentsInCourses.equals("yes") && !printAssignmentsInCourses.equals("no")) {
                        printMessage("Invalid word, please try again");
                        printAssignmentsInCourses = scanner.next();
                    }
                    if (printAssignmentsInCourses.equals("yes")) {
                        assignmentsInCourses.add(arrayOfAssignments.get(i));
                        assignmentsInCoursesList.add(String.format(assignmentsInCourses.get(counter2) + "will introduce into the " + arrayOfCourses.get(b)));
                        counter2++;
                    }
                }
            }
            printMessage("Would you like to print the list of assignments per courses?(Type Yes/No)");
            String printAssignmentsInCourses = scanner.next();
            printAssignmentsInCourses = printAssignmentsInCourses.toLowerCase();
            while (!printAssignmentsInCourses.equals("yes") && !printAssignmentsInCourses.equals("no")) {
                printMessage("Invalid word, please try again");
                printAssignmentsInCourses = scanner.next();
            }
            if (printAssignmentsInCourses.equals("yes")) {
                for (int i = 0; i < assignmentsInCoursesList.size(); i++) {
                    System.out.println(assignmentsInCoursesList.get(i));
                }
            }
        }
        //LIST ASSIGNMENTS PER STUDENTS
        if (flagAssignment == true && flagStudent == true) {
            ArrayList<String> assignmentsInStudentsList = new ArrayList();
            ArrayList<Assignment> assignmentsInStudents = new ArrayList();
            ArrayList<String> Hmeromhnies = new ArrayList();
            int counter3 = 0;
            for (int b = 0; b < arrayOfStudents.size(); b++) {
                for (int i = 0; i < arrayOfAssignments.size(); i++) {
                    printMessage("Would you like the " + arrayOfAssignments.get(i) + " that will be assigned to the " + arrayOfStudents.get(b) + " ?(Yes/No)");
                    String printAssignmentsInStudents = scanner.next();
                    printAssignmentsInStudents = printAssignmentsInStudents.toLowerCase();
                    while (!printAssignmentsInStudents.equals("yes") && !printAssignmentsInStudents.equals("no")) {
                        printMessage("Invalid word, please try again");
                        printAssignmentsInStudents = scanner.next();
                    }
                    if (printAssignmentsInStudents.equals("yes")) {
                        assignmentsInStudents.add(arrayOfAssignments.get(i));
                        String x = String.format(" " + assignmentsInStudents.get(counter3));
                        //System.out.println(x);
                        String y = x.substring(x.length() - 11, x.length() - 1);
                        //System.out.println(y);
                        Hmeromhnies.add(String.format(y + " is the date that an assignment must be committed by " + arrayOfStudents.get(b)));
                        assignmentsInStudentsList.add(String.format(assignmentsInStudents.get(counter3) + "will be assigned to the " + arrayOfStudents.get(b)));
                        counter3++;
                    }
                }
            }

            printMessage("Would you like to print the list of assignments per students?(Type Yes/No)");
            String printAssignmentsInStudentsList = scanner.next();
            printAssignmentsInStudentsList = printAssignmentsInStudentsList.toLowerCase();
            while (!printAssignmentsInStudentsList.equals("yes") && !printAssignmentsInStudentsList.equals("no")) {
                printMessage("Invalid word, please try again");
                printAssignmentsInStudentsList = scanner.next();
            }
            if (printAssignmentsInStudentsList.equals("yes")) {
                for (int i = 0; i < assignmentsInStudentsList.size(); i++) {
                    System.out.println(assignmentsInStudentsList.get(i));
                }
            }
            //The program ask from the user a date and it should output a list of students who need to submit one or more assignments on the same calendar week as the given date
            int day;
            do {
                System.out.print("Please insert day of the date of submission of Assignments (e.g 15): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a number:");
                    scanner.next();
                }
                day = scanner.nextInt();
            } while (day < 01 || day > 31);

            int month;
            do {
                System.out.print("Please insert month of the date of submission of Assignments (e.g 04): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a number:");
                    scanner.next();
                }
                month = scanner.nextInt();
            } while (month < 01 || month > 13);

            int year;
            do {
                System.out.print("Please insert year of the date of submission of Assignments (e.g 2021): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Please enter a number:");
                    scanner.next();
                }
                year = scanner.nextInt();
            } while (year > 3000 || year < 2020);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String submittedDate = String.format("%d-%d-%d", day, month, year);
            if (day > 9 && month > 9) {
                submittedDate = String.format("%d-%d-%d", day, month, year);
            } else if (day < 10 && month > 9) {
                submittedDate = String.format("0%d-%d-%d", day, month, year);
            } else if (day < 10 && month < 10) {
                submittedDate = String.format("0%d-0%d-%d", day, month, year);
            } else if (day > 9 && month < 10) {
                submittedDate = String.format("%d-0%d-%d", day, month, year);
            }
            LocalDate dateFromString = LocalDate.parse(submittedDate, formatter);
            LocalDate firstDateOfWeek = dateFromString;
            while (firstDateOfWeek.getDayOfWeek() != DayOfWeek.MONDAY) {
                firstDateOfWeek = firstDateOfWeek.minusDays(1);
            }
            LocalDate lastDateOfWeek = firstDateOfWeek.plusDays(6);
            for (int i = 0; i < Hmeromhnies.size(); i++) {
                String date = Hmeromhnies.get(i);
                String date2 = date.substring(0, 10);

                //System.out.println(date2);
                LocalDate dateFromString1 = LocalDate.parse(date2, formatter);
                if (dateFromString1.isAfter(firstDateOfWeek.minusDays(1)) && dateFromString1.isBefore(lastDateOfWeek.plusDays(1))) {
                    System.out.println(Hmeromhnies.get(i));
                }
            }
        }
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

}
