/*
Name: Maisha Nabila
UF-ID: 03062609
Section: 0398
Project Number: 5
Brief Description: This program allows the user grade an essay and list misspelled words in the essay by student type
 */
import java.io.IOException;
import java.util.Scanner;

public class Project5 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        final boolean SUCCESS = true;
        Dictionary dict = new Dictionary();

        while (dict.getVocabularySize() <= 0) {
            System.out.println("Please specify the file name (without extension) of the dictionary.");
            if (dict.loadDictionaryFromFile(input.nextLine() + ".txt") == SUCCESS && dict.getVocabularySize() > 0)
                System.out.println("Dictionary load successfully.");
            else
                System.out.println("Failed to load dictionary. Please try again.");
        }

        Grader grader = new Grader(dict);
        Student student;
        String id;

        while (true) {
            System.out.println("Please specify the ID of the student whose essay will be graded.");
            id = input.nextLine();
            if (id != null && id.trim().equalsIgnoreCase("exit"))
                break;

            if (!grader.isAvailable())
                grader.reset();

            if (grader.gradeStudent(id) == SUCCESS) {
                student = grader.getStudent();
                student.writeToFile();
                System.out.println("Student " + id + " has been graded.");
            } else {
                System.out.println("Grading student " + id + " failed. Please try another one.");
            }


        }
    }

}
