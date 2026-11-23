package es.uclm.iso2.scholarships.domain;

/**
 * Scholarship category that a student is awarded (statement ET.02.03).
 *
 * <p>The program returns only the category, not the amounts (Q7 of the README). When no rule is met the result is
 * {@link #NONE}, which is a valid result and not an error (Q4).
 */
public enum Scholarship {

    /** Excellence Scholarship: full tuition waiver plus a €1,000 stipend. */
    EXCELLENCE,

    /** Residence Scholarship: full tuition waiver plus a housing allowance. */
    RESIDENCE,

    /** Large Family Scholarship: full tuition waiver. */
    LARGE_FAMILY,

    /** Inclusion Scholarship: full tuition waiver plus assistive technology funding. */
    INCLUSION,

    /** No scholarship: the student meets none of the rules (Q4). */
    NONE
}
