# Plan – T2 – Domain and scholarship rules (#3)

| | |
|---|---|
| **Issue** | #3 · branch `feature/domain` |
| **Step** | Step 1 – Program (Pair 2) · issue #159 of the main repository |
| **Specification** | statement ET.02.03 (and ET.02.00: easy to test, SOLID, data encapsulated, exceptions) and table Q of the [README](../../README.md) |
| **Decisions** | D-003 (easy to test), D-004 (coverage), D-005 (no tests in Step 1, Javadoc), D-006 (working method), D-007 (frozen after delivery), D-008 (no console in the domain), D-010 (English) |
| **Plan approved by** | Adam, 23/11/2026 |

## Questions and answers
- **Q:** Are tests written in this task? **A:** No: rule 17, D-002 and D-005. Pair 3 designs them and Pair 1 writes them (Javier, 23/11/2026).
- **Q:** Branch and plan names? **A:** `feature/domain`, created by Adam from the issue once #20 is merged; this file (Javier, 23/11/2026).
- **Q:** Where is the method that chooses the scholarship? **A:** Its own class `ScholarshipSelector`, with one public instance method `select(Student)`, so that `Student` only holds and validates the data (single responsibility, ET.02.00; Adam, 23/11/2026).
- **Q:** `Student` as a class or a record? **A:** A `final` class with private `final` fields, a constructor that validates and one getter per field (data encapsulated, ET.02.00 and D-003; Adam, 23/11/2026).
- **Q:** Order of the parameters of the constructor? **A:** The order of the statement and of the README: GPA, family income, distance, disability degree, siblings (Adam, 23/11/2026).
- **Q:** Messages of the exceptions (Q5 only says English and the name of the field)? **A:** `GPA must be between 0 and 10`, `Family income must be 0 or more`, `Distance must be 0 or more`, `Disability degree must be between 0 and 100`, `Number of siblings must be 0 or more`. With several invalid data, the first one in that order is reported (Adam, 23/11/2026).
- **Q:** What does `select` do with a `null` student? The statement and table Q do not say. **A:** A new row Q8 of the README: `IllegalArgumentException` with the message `Student must not be null`, the same exception as Q5 for any invalid input. Pair 2 reviews it in the pull request (Adam, 23/11/2026).
- **Q:** Where are the limits? **A:** The limits of the valid ranges are `public static final` constants of `Student`, and the limits of the rules are `public static final` constants of `ScholarshipSelector`, one per rule even when two rules share the value (5.0), so that each boundary is traced to its rule (Adam, 23/11/2026).
- **Q:** One `if` per rule with `&&`, or nested `if` statements? **A:** One `if` per rule with `&&`, in the order of Q1, and `return NONE` at the end (D-003: simple `if` statements; each rule is one compound decision for the MC/DC of Pair 3; Adam, 23/11/2026).
- **Q:** May the sentence "It is filled in by task T2" of the `package-info.java` of the domain be replaced by the list of the classes? **A:** Yes (Adam, 23/11/2026).

## Files
| File | Action | What |
|---|---|---|
| `doc/plans/T2-domain.md` | create | this plan |
| `src/main/java/es/uclm/iso2/scholarships/domain/Scholarship.java` | create | enum `EXCELLENCE`, `RESIDENCE`, `LARGE_FAMILY`, `INCLUSION`, `NONE`, with the Javadoc of each value (Q4, Q7) |
| `src/main/java/es/uclm/iso2/scholarships/domain/Student.java` | create | the five data; constructor `Student(double gpa, double familyIncome, double distance, int disabilityDegree, int siblings)` that throws `IllegalArgumentException` (Q5, Q6, `NaN` and infinite values included); constants `MIN_GPA`, `MAX_GPA`, `MIN_FAMILY_INCOME`, `MIN_DISTANCE`, `MIN_DISABILITY_DEGREE`, `MAX_DISABILITY_DEGREE`, `MIN_SIBLINGS`; getters |
| `src/main/java/es/uclm/iso2/scholarships/domain/ScholarshipSelector.java` | create | `public Scholarship select(Student student)`; constants `EXCELLENCE_MIN_GPA` 8.5, `EXCELLENCE_INCOME_LIMIT` 30,000, `RESIDENCE_MIN_GPA` 6.5, `RESIDENCE_GPA_LIMIT` 8.5, `RESIDENCE_INCOME_LIMIT` 20,000, `RESIDENCE_DISTANCE_LIMIT` 50, `LARGE_FAMILY_MIN_GPA` 5.0, `LARGE_FAMILY_INCOME_LIMIT` 15,000, `LARGE_FAMILY_MIN_SIBLINGS` 3, `INCLUSION_MIN_DISABILITY_DEGREE` 33, `INCLUSION_MIN_GPA` 5.0 (Q1, Q2, Q3) |
| `src/main/java/es/uclm/iso2/scholarships/domain/package-info.java` | change | replace "It is filled in by task T2" with the list of the classes |
| `README.md` | change | table "Methods to test" and row Q8 |

No test is written in Step 1 (rule 17 of AGENTS.md). Not in this task: the console (T3, #4), `pom.xml` and the CI.

## Steps
Tick each step with the hash of its commit (green `mvn -B verify`). Steps 1 to 4 are committed one after the other from the same set of files; each of them was built on its own with a green `mvn -B verify` before it was committed.
- [ ] 1. This plan and `Scholarship`
- [ ] 2. `Student` with its validations
- [ ] 3. `ScholarshipSelector` with the rules
- [ ] 4. README: "Methods to test" and Q8, and the `package-info.java` of the domain
- [ ] 5. Tick the steps of this plan with their hashes
- [ ] 6. Open the pull request to `develop` with `Closes #3` (only when Adam asks); check that the CI is green

## Verification
- [x] Every point of the issue #3 is checked: `Student` (Q5, Q6), `Scholarship` (Q4, Q7), one public method with simple `if` statements in the order of Q1 and the limits of Q2 and Q3, named constants, Javadoc, no console, and the table "Methods to test" of the README.
- [x] Every public class, method and constant has its Javadoc (rule 18); `mvn javadoc:javadoc` with `doclint=all` shows no warning.
- [x] The domain has no console input or output (D-003).
- [x] `mvn -B verify` is green after each step; there are no tests yet, so JaCoCo has nothing to check (D-004).
- [ ] The CI is green on the pull request.

## Status
- **In progress:** nothing
- **Next step:** step 5, tick steps 1 to 4 with the hashes of their commits; then step 6, the pull request when Adam asks, and tell Javier the signatures of `Student` and `ScholarshipSelector` for T3 (#4)
- **Open questions:** none
- **Last update:** 23/11/2026, Adam
