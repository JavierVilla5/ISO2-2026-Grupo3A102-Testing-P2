# Plan – T1 – Maven skeleton and CI (#2)

| | |
|---|---|
| **Issue** | #2 · branch `feature/maven-skeleton` |
| **Step** | Step 1 – Program (Pair 2) · issue #159 of the main repository |
| **Specification** | statement ET.02.00 and ET.02.03; lab sessions S.02.07 (CI) and S.04.02 (Surefire and JaCoCo) |
| **Decisions** | D-003 (artifact and version), D-004 (coverage), D-006 (working method), D-010 (English), D-011 (issues in progress) |
| **Plan approved by** | Javier, 23/11/2026 |

## Questions and answers
- **Q:** Which versions? **A:** JUnit 6.1.3, Surefire 3.5.6 and JaCoCo 0.8.16, those of the lab slides (Javier, 23/11/2026).
- **Q:** Which CI trigger? **A:** `push` and `pull_request` to `main` and `develop`, as the lab workflow (Javier, 23/11/2026).
- **Q:** Which coverage threshold? **A:** 80 % of lines only, no threshold for branches; it only warns until Step 3 (Javier, 23/11/2026; D-004).
- **Q:** How do the packages exist while they are empty? **A:** A `package-info.java` with Javadoc in each (Javier, 23/11/2026).
- **Q:** Which Java release? **A:** 21, as in the README (Javier, 23/11/2026).
- **Q:** Which `groupId`? **A:** `es.uclm.iso2` (Javier, 23/11/2026), the prefix of the packages of D-003 and D-008. The artifact is `ISO2-2026-Grupo3A102-Testing-P2`, version `0.1.0-SNAPSHOT` (D-003).

## Files
| File | Action | What |
|---|---|---|
| `pom.xml` | create | `es.uclm.iso2` : `ISO2-2026-Grupo3A102-Testing-P2` : `0.1.0-SNAPSHOT`; `maven.compiler.release` 21; JUnit `junit-jupiter` 6.1.3 in scope test; `maven-surefire-plugin` 3.5.6; `jacoco-maven-plugin` 0.8.16 with `prepare-agent`, `report` and `check` (rule on `LINE`, `COVEREDRATIO`, minimum 0.80, `BUNDLE`, `haltOnFailure` false) |
| `.gitignore` | create | `target/` and the files of the editors |
| `src/main/java/es/uclm/iso2/scholarships/domain/package-info.java` | create | empty package with its Javadoc (T2 fills it) |
| `src/main/java/es/uclm/iso2/scholarships/ui/package-info.java` | create | empty package with its Javadoc (T3 fills it) |
| `.github/workflows/maven.yml` | create | `Build with Maven`: `push` and `pull_request` to `main` and `develop`; `ubuntu-latest`; `actions/checkout@v7`; `actions/setup-java@v6` with Temurin 21 and Maven cache; `mvn -B verify` |
| `doc/plans/T1-maven-skeleton.md` | create | this plan |

Not in this task: any class of the domain or the console (T2, T3), any test (rule 17), the `maven-site-plugin` and the reporting section of the lab (the statement asks only for JUnit, Surefire and JaCoCo; rule 6).

## Steps
Tick each step with the hash of its commit (green `mvn -B verify`).
- [x] 1. `pom.xml`, `.gitignore` and the two `package-info.java`; `mvn -B verify` is green (ca9df8e)
- [x] 2. `.github/workflows/maven.yml` (0c87fed)
- [ ] 3. Open the pull request to `develop` with `Closes #2` (only when Javier asks); check that the CI is green

## Verification
- [ ] Every point of the issue #2 is checked.
- [ ] Every `package-info.java` has its Javadoc (rule 18).
- [ ] `mvn -B verify` is green, with the JaCoCo report in `target/site/jacoco/index.html` and a warning at most for the coverage.
- [ ] The CI is green on the pull request.

## Status
- **In progress:** nothing
- **Next step:** step 3, the pull request when Javier asks
- **Open questions:** none
- **Last update:** 23/11/2026, Javier
