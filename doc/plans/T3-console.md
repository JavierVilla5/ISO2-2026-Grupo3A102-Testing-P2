# Plan – T3 – Console interface (#4)

| | |
|---|---|
| **Issue** | #4 · branch `feature/console` |
| **Step** | Step 1 – Program (Pair 2) · issue #159 of the main repository |
| **Specification** | statement ET.02.03 and table Q of the [README](../../README.md); issue #4 |
| **Decisions** | D-003 (easy to test), D-004 (coverage), D-005 (no tests in Step 1, Javadoc), D-006 (working method), D-008 (console apart from the domain), D-010 (English), D-011 (issues in progress) |
| **Plan approved by** | Javier, 23/11/2026 |

## Questions and answers
Decided one by one by Javier on 23/11/2026. A Makefile was considered and rejected: `make` is not installed on Windows and rule 6 asks for no new tools.
- **Q:** How many classes? **A:** One class `ScholarshipConsole` with `main` and `run(InputStream, PrintStream)`, so that it can be tried without a real keyboard (Javier, 23/11/2026).
- **Q:** What if the user types something that is not a number? **A:** The console asks again for that value only, with a clear message (Javier, 23/11/2026).
- **Q:** What if the domain rejects a value? **A:** The console shows `getMessage()` of the `IllegalArgumentException` as it is and asks again for the five data (Javier, 23/11/2026).
- **Q:** How many students per run? **A:** One. To try another case, run the program again (Javier, 23/11/2026).
- **Q:** What is shown as the result? **A:** The category, for example `Scholarship: LARGE_FAMILY` (Q7: only the category) (Javier, 23/11/2026).
- **Q:** Decimal separator? **A:** The dot (`7.5`), read with `Locale.ROOT` so that it does not depend on the computer (Javier, 23/11/2026).
- **Q:** How is the program run, without new plugins (rule 6)? **A:** `mvn compile` and `java -cp target/classes es.uclm.iso2.scholarships.ui.ScholarshipConsole`, written in the README (Javier, 23/11/2026).

## Files
| File | Action | What |
|---|---|---|
| `doc/plans/T3-console.md` | create | this plan |
| `src/main/java/es/uclm/iso2/scholarships/ui/ScholarshipConsole.java` | create | `main(String[])` and `run(InputStream, PrintStream)`: reads the five data in the order of the constructor of `Student`, creates it, calls `ScholarshipSelector.select` and prints the category. No business rules (D-008); Javadoc on every public method |
| `src/main/java/es/uclm/iso2/scholarships/ui/package-info.java` | change | replace "It is filled in by task T3" with the name of the class |
| `README.md` | change | section "Run the program" with the two commands |

No test is written in Step 1 (rule 17 of AGENTS.md). Not in this task: `pom.xml`, the CI, the domain and the rule 22 of `AGENTS.md` (issue #24).

## Steps
Tick each step with the hash of its commit (green `mvn -B verify`).
- [ ] 1. This plan
- [ ] 2. `ScholarshipConsole` (reading and result) and the `package-info.java` of `ui`
- [ ] 3. README: how to run the program
- [ ] 4. Tick the steps of this plan with their hashes, and push everything
- [ ] 5. Open the pull request to `develop` with `Closes #4`, only when everything is pushed and Javier asks (rule 22 proposed in #24); check that the CI is green

## Verification
- [ ] Every point of the issue #4 is checked.
- [ ] Every public class and method has its Javadoc (rule 18).
- [ ] The console has no business rules: it only creates the `Student`, calls the domain and prints (D-008).
- [ ] `mvn -B verify` is green, and the program has been tried by hand with a valid case and an invalid one.
- [ ] The CI is green on the pull request.

## Status
- **In progress:** nothing
- **Next step:** step 2, `ScholarshipConsole` and the `package-info.java` of `ui`
- **Open questions:** none
- **Last update:** 23/11/2026, Javier's agent
