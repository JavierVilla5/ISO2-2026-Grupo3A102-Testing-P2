package es.uclm.iso2.scholarships.ui;

import es.uclm.iso2.scholarships.domain.Scholarship;
import es.uclm.iso2.scholarships.domain.ScholarshipSelector;
import es.uclm.iso2.scholarships.domain.Student;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Command-line interface of the scholarship program (task T3, D-008).
 *
 * <p>It reads the five data of one student, creates the {@link Student}, asks the {@link ScholarshipSelector} for the
 * scholarship and shows its category. It has no business rules: the ranges of the data are checked by
 * {@link Student}, and the console only shows the message of the exception.
 *
 * <p>Decimal numbers are typed with a dot, for example {@code 7.5}.
 */
public class ScholarshipConsole {

    /**
     * Runs the program with the keyboard and the screen. It handles one student and then ends.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        new ScholarshipConsole().run(System.in, System.out);
    }

    /**
     * Reads the data of one student from {@code in}, and writes the questions and the result to {@code out}.
     *
     * <p>If a line is not a number, it asks again for that value only. If the domain rejects the data, it shows the
     * message of the exception and asks again for the five data. If the input ends before the data are complete, it
     * shows a message and returns.
     *
     * @param in  where the data are read from, line by line (for example {@code System.in})
     * @param out where the questions, the messages and the result are written (for example {@code System.out})
     */
    public void run(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        try {
            Student student = readStudent(scanner, out);
            Scholarship scholarship = new ScholarshipSelector().select(student);
            out.println("Scholarship: " + scholarship);
        } catch (NoSuchElementException e) {
            out.println("The input ended before all the data were typed.");
        }
    }

    private Student readStudent(Scanner scanner, PrintStream out) {
        while (true) {
            double gpa = readDouble(scanner, out, "GPA: ");
            double familyIncome = readDouble(scanner, out, "Family income (euros): ");
            double distance = readDouble(scanner, out, "Distance to the campus (km): ");
            int disabilityDegree = readInt(scanner, out, "Degree of disability (%): ");
            int siblings = readInt(scanner, out, "Number of siblings: ");
            try {
                return new Student(gpa, familyIncome, distance, disabilityDegree, siblings);
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }
    }

    private double readDouble(Scanner scanner, PrintStream out, String question) {
        while (true) {
            out.print(question);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                out.println("\"" + line + "\" is not a number, try again (use a dot for decimals, for example 7.5).");
            }
        }
    }

    private int readInt(Scanner scanner, PrintStream out, String question) {
        while (true) {
            out.print(question);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                out.println("\"" + line + "\" is not a whole number, try again.");
            }
        }
    }
}
