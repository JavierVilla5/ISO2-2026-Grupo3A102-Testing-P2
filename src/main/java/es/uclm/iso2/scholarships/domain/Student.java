package es.uclm.iso2.scholarships.domain;

/**
 * Profile data of a university student that decide the scholarship (statement ET.02.03): GPA, family income,
 * distance from home to the campus, degree of disability and number of siblings.
 *
 * <p>The data are validated in the constructor (Q5 and Q6 of the README), so an object of this class always holds
 * valid data. Once created, it cannot be changed.
 */
public final class Student {

    /** Lowest valid GPA, included. */
    public static final double MIN_GPA = 0.0;

    /** Highest valid GPA, included. */
    public static final double MAX_GPA = 10.0;

    /** Lowest valid family income in euros, included. */
    public static final double MIN_FAMILY_INCOME = 0.0;

    /** Lowest valid distance from home to the campus in kilometres, included. */
    public static final double MIN_DISTANCE = 0.0;

    /** Lowest valid degree of disability in percent, included. */
    public static final int MIN_DISABILITY_DEGREE = 0;

    /** Highest valid degree of disability in percent, included. */
    public static final int MAX_DISABILITY_DEGREE = 100;

    /** Lowest valid number of siblings, included. */
    public static final int MIN_SIBLINGS = 0;

    private final double gpa;
    private final double familyIncome;
    private final double distance;
    private final int disabilityDegree;
    private final int siblings;

    /**
     * Creates a student with the given data, after checking that every value is valid (Q5 of the README).
     *
     * <p>The data are checked in the order of the parameters, and the exception reports the first invalid one.
     *
     * @param gpa              grade point average, from {@value #MIN_GPA} to {@value #MAX_GPA}, both included
     * @param familyIncome     family income in euros, {@value #MIN_FAMILY_INCOME} or more
     * @param distance         distance from home to the campus in kilometres, {@value #MIN_DISTANCE} or more
     * @param disabilityDegree degree of disability in percent, from {@value #MIN_DISABILITY_DEGREE} to
     *                         {@value #MAX_DISABILITY_DEGREE}, both included
     * @param siblings         number of siblings, {@value #MIN_SIBLINGS} or more
     * @throws IllegalArgumentException if a value is out of its range, or if a {@code double} value is
     *                                  {@code NaN} or infinite. The message names the field:
     *                                  {@code "GPA must be between 0 and 10"},
     *                                  {@code "Family income must be 0 or more"},
     *                                  {@code "Distance must be 0 or more"},
     *                                  {@code "Disability degree must be between 0 and 100"} or
     *                                  {@code "Number of siblings must be 0 or more"}
     */
    public Student(double gpa, double familyIncome, double distance, int disabilityDegree, int siblings) {
        if (!Double.isFinite(gpa) || gpa < MIN_GPA || gpa > MAX_GPA) {
            throw new IllegalArgumentException("GPA must be between 0 and 10");
        }
        if (!Double.isFinite(familyIncome) || familyIncome < MIN_FAMILY_INCOME) {
            throw new IllegalArgumentException("Family income must be 0 or more");
        }
        if (!Double.isFinite(distance) || distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("Distance must be 0 or more");
        }
        if (disabilityDegree < MIN_DISABILITY_DEGREE || disabilityDegree > MAX_DISABILITY_DEGREE) {
            throw new IllegalArgumentException("Disability degree must be between 0 and 100");
        }
        if (siblings < MIN_SIBLINGS) {
            throw new IllegalArgumentException("Number of siblings must be 0 or more");
        }
        this.gpa = gpa;
        this.familyIncome = familyIncome;
        this.distance = distance;
        this.disabilityDegree = disabilityDegree;
        this.siblings = siblings;
    }

    /**
     * Returns the grade point average.
     *
     * @return the GPA, from {@value #MIN_GPA} to {@value #MAX_GPA}
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Returns the family income.
     *
     * @return the family income in euros, {@value #MIN_FAMILY_INCOME} or more
     */
    public double getFamilyIncome() {
        return familyIncome;
    }

    /**
     * Returns the distance from home to the campus.
     *
     * @return the distance in kilometres, {@value #MIN_DISTANCE} or more
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Returns the degree of disability.
     *
     * @return the degree of disability in percent, from {@value #MIN_DISABILITY_DEGREE} to
     *         {@value #MAX_DISABILITY_DEGREE}
     */
    public int getDisabilityDegree() {
        return disabilityDegree;
    }

    /**
     * Returns the number of siblings.
     *
     * @return the number of siblings, {@value #MIN_SIBLINGS} or more
     */
    public int getSiblings() {
        return siblings;
    }
}
