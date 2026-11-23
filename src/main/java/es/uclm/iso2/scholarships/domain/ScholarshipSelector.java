package es.uclm.iso2.scholarships.domain;

/**
 * Chooses the most appropriate scholarship for a student with the rules of the statement (ET.02.03).
 *
 * <p>The rules are checked in the order of Q1 of the README, and the first one that is met wins:
 * {@link Scholarship#EXCELLENCE}, {@link Scholarship#RESIDENCE}, {@link Scholarship#LARGE_FAMILY} and
 * {@link Scholarship#INCLUSION}. If none is met, the result is {@link Scholarship#NONE} (Q4). Every limit is a named
 * constant; whether it is included follows Q2 and Q3.
 */
public class ScholarshipSelector {

    /** Excellence: lowest GPA, included ("8.5 or higher"). */
    public static final double EXCELLENCE_MIN_GPA = 8.5;

    /** Excellence: family income in euros must be below this value, not included ("below €30,000"). */
    public static final double EXCELLENCE_INCOME_LIMIT = 30_000.0;

    /** Residence: lowest GPA, included ("between 6.5 and 8.4"). */
    public static final double RESIDENCE_MIN_GPA = 6.5;

    /** Residence: GPA must be below this value, not included (Q2: 6.5 &le; GPA &lt; 8.5). */
    public static final double RESIDENCE_GPA_LIMIT = 8.5;

    /** Residence: family income in euros must be below this value, not included ("under €20,000"). */
    public static final double RESIDENCE_INCOME_LIMIT = 20_000.0;

    /** Residence: distance in kilometres must be above this value, not included ("exceeds 50 km"). */
    public static final double RESIDENCE_DISTANCE_LIMIT = 50.0;

    /** Large family: lowest GPA, included ("5.0 or higher"). */
    public static final double LARGE_FAMILY_MIN_GPA = 5.0;

    /** Large family: family income in euros must be below this value, not included ("strictly below €15,000"). */
    public static final double LARGE_FAMILY_INCOME_LIMIT = 15_000.0;

    /** Large family: lowest number of siblings, included ("3 or more"). */
    public static final int LARGE_FAMILY_MIN_SIBLINGS = 3;

    /** Inclusion: lowest degree of disability in percent, included ("33% or higher"). */
    public static final int INCLUSION_MIN_DISABILITY_DEGREE = 33;

    /** Inclusion: lowest GPA, included ("a minimum GPA of 5.0"). */
    public static final double INCLUSION_MIN_GPA = 5.0;

    /**
     * Creates a selector. It has no state, so one selector can be used for any number of students.
     */
    public ScholarshipSelector() {
        // Nothing to initialise: the rules only use the constants of this class.
    }

    /**
     * Returns the scholarship that the student is awarded, checking the rules in the order of Q1 of the README.
     *
     * <ol>
     *   <li>{@link Scholarship#EXCELLENCE}: GPA &ge; {@value #EXCELLENCE_MIN_GPA} and family income &lt;
     *       {@value #EXCELLENCE_INCOME_LIMIT}.</li>
     *   <li>{@link Scholarship#RESIDENCE}: {@value #RESIDENCE_MIN_GPA} &le; GPA &lt; {@value #RESIDENCE_GPA_LIMIT},
     *       family income &lt; {@value #RESIDENCE_INCOME_LIMIT} and distance &gt;
     *       {@value #RESIDENCE_DISTANCE_LIMIT}.</li>
     *   <li>{@link Scholarship#LARGE_FAMILY}: GPA &ge; {@value #LARGE_FAMILY_MIN_GPA}, family income &lt;
     *       {@value #LARGE_FAMILY_INCOME_LIMIT} and siblings &ge; {@value #LARGE_FAMILY_MIN_SIBLINGS}.</li>
     *   <li>{@link Scholarship#INCLUSION}: disability degree &ge; {@value #INCLUSION_MIN_DISABILITY_DEGREE} and
     *       GPA &ge; {@value #INCLUSION_MIN_GPA}.</li>
     *   <li>Otherwise {@link Scholarship#NONE}.</li>
     * </ol>
     *
     * @param student the student, with data already validated by its constructor
     * @return the first scholarship whose rule is met, or {@link Scholarship#NONE} if no rule is met; never
     *         {@code null}
     * @throws IllegalArgumentException if {@code student} is {@code null}, with the message
     *                                  {@code "Student must not be null"} (Q8)
     */
    public Scholarship select(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student must not be null");
        }
        double gpa = student.getGpa();
        double income = student.getFamilyIncome();
        double distance = student.getDistance();
        int disabilityDegree = student.getDisabilityDegree();
        int siblings = student.getSiblings();

        if (gpa >= EXCELLENCE_MIN_GPA && income < EXCELLENCE_INCOME_LIMIT) {
            return Scholarship.EXCELLENCE;
        }
        if (gpa >= RESIDENCE_MIN_GPA && gpa < RESIDENCE_GPA_LIMIT && income < RESIDENCE_INCOME_LIMIT
                && distance > RESIDENCE_DISTANCE_LIMIT) {
            return Scholarship.RESIDENCE;
        }
        if (gpa >= LARGE_FAMILY_MIN_GPA && income < LARGE_FAMILY_INCOME_LIMIT && siblings >= LARGE_FAMILY_MIN_SIBLINGS) {
            return Scholarship.LARGE_FAMILY;
        }
        if (disabilityDegree >= INCLUSION_MIN_DISABILITY_DEGREE && gpa >= INCLUSION_MIN_GPA) {
            return Scholarship.INCLUSION;
        }
        return Scholarship.NONE;
    }
}
