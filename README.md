# ISO2-2026-Grupo3A102-Testing-P2

Problem 2 (ET.02.03, Scholarships) of the second theoretical exercise of Software Engineering II (UCLM, 2026/27),
group 3A1.02. The program decides the most appropriate scholarship category for a university student from their GPA,
family income, distance from home to the campus, degree of disability and number of siblings.

| Step | Subgroup | Members | Issue |
|---|---|---|---|
| Step 1 – Program | Pair 2 | Adam Gouram El Bouhali, Javier Villanueva Crespo | [#159](https://github.com/igrt08-uclm/2026-ISO2-3A1.02/issues/159) |
| Step 2 – Test design | Pair 3 | Denis-Alexandru Ionescu Telibasa, Rodrigo Muñoz Martín, David Calzado Olmo | [#160](https://github.com/igrt08-uclm/2026-ISO2-3A1.02/issues/160) |
| Step 3 – JUnit tests | Pair 1 | Marcos Loro Carrasco, Ignacio Romero Torres | [#161](https://github.com/igrt08-uclm/2026-ISO2-3A1.02/issues/161) |

Tasks, dates and how we work: [Planning](https://github.com/JavierVilla5/ISO2-2026-Grupo3A102-Testing-P2/wiki/Planning)
in the wiki. Rules for people and AI agents: [AGENTS.md](AGENTS.md). Why things are the way they are:
[DECISIONS.md](DECISIONS.md). Main repository of the team:
[2026-ISO2-3A1.02](https://github.com/igrt08-uclm/2026-ISO2-3A1.02) · [Testing Part](https://github.com/igrt08-uclm/2026-ISO2-3A1.02/wiki/Testing-Part)

## Requirements

- Java 21 or later
- Maven 3.9 or later

## Build and test

```
mvn verify
```

- Test results (Surefire): `target/surefire-reports`
- Coverage report (JaCoCo): `target/site/jacoco/index.html`. The minimum is 80 % of the lines.

> Until Step 3 the coverage check only shows a warning (`haltOnFailure` is `false` in `pom.xml`), because the program
> is written before its tests. Pair 1 sets `haltOnFailure` to `true` in Step 3 (D-004).

## Structure

| Package | Content |
|---|---|
| `es.uclm.iso2.scholarships.domain` | `Student` (input data and validations), `Scholarship` (the result) and the rules that choose it |
| `es.uclm.iso2.scholarships.ui` | Command-line interface, with no business rules |
| `src/test/java` | JUnit tests (Step 3, Pair 1) |

## The rules of the statement

The program returns one scholarship. When several rules are met, the first one in this order wins (Q1).

| Order | Scholarship | Conditions (all of them) | What it gives |
|---|---|---|---|
| 1 | `EXCELLENCE` | GPA ≥ 8.5 and family income < €30,000 | Full tuition waiver plus a €1,000 stipend |
| 2 | `RESIDENCE` | 6.5 ≤ GPA < 8.5, family income < €20,000 and distance > 50 km | Full tuition waiver plus a housing allowance |
| 3 | `LARGE_FAMILY` | GPA ≥ 5.0, family income < €15,000 and siblings ≥ 3 | Full tuition waiver |
| 4 | `INCLUSION` | Disability degree ≥ 33 % and GPA ≥ 5.0 | Full tuition waiver plus assistive technology funding |
| – | `NONE` | None of the above | Nothing |

The last column is for information only: the program returns the category, not the amounts (Q7).

**Valid input data** (Q5). Anything else makes the constructor of `Student` throw an `IllegalArgumentException`.

| Data | Type | Valid values |
|---|---|---|
| GPA | `double` | From 0 to 10, both included |
| Family income (€) | `double` | 0 or more |
| Distance to the campus (km) | `double` | 0 or more |
| Degree of disability (%) | `int` | From 0 to 100, both included |
| Number of siblings | `int` | 0 or more |

`NaN` and infinite values are rejected too.

## Decisions on the statement

The statement leaves these questions open. These are the answers the program follows, so that Pair 3 can design the
tests from them. A new decision is added as Q8, Q9… and, once Step 1 is delivered, it counts as a change of the
program (D-007).

| # | Question | Answer | Why |
|---|---|---|---|
| Q1 | A student meets the conditions of several scholarships. Which one is returned? | The first one in this order: `EXCELLENCE`, `RESIDENCE`, `LARGE_FAMILY`, `INCLUSION`. | The statement assumes that there is no ambiguity but gives no order, so we keep the order in which it lists them. It is also the simplest code: one `if` after another. |
| Q2 | "GPA between 6.5 and 8.4" leaves a gap with "GPA of 8.5 or higher": what about 8.45? | `RESIDENCE` takes 6.5 ≤ GPA < 8.5, so every GPA belongs to only one band. | A student with 8.45 would otherwise meet no rule even with the right income and distance, and comparing with 8.4 in a `double` is inexact. |
| Q3 | Which limits include their value? | The literal reading of the statement: "or higher" and "or more" include it (GPA ≥ 8.5, ≥ 5.0, ≥ 6.5, disability ≥ 33, siblings ≥ 3); "below", "under", "strictly below" and "exceeds" do not (income < 30,000, < 20,000, < 15,000, distance > 50). | We do not invent a reading that the statement does not give, so every pair gets the same boundary values from the text. |
| Q4 | What does the program return when no scholarship applies? | The value `NONE`. | A student without a scholarship is a valid case, not an error, and a separate value lets the tests tell it apart from invalid data, which throws an exception. |
| Q5 | Which data are valid, and what happens with the invalid ones? | The ranges of the table above. Otherwise the constructor of `Student` throws an `IllegalArgumentException` with a message in English that names the field. | A GPA is out of 10 and a disability degree is a percentage; the statement gives no other range and we do not invent one. The standard exception needs no new class and is tested with `assertThrows`. |
| Q6 | Which Java types? | `double` for GPA, income and distance; `int` for disability and siblings. | Disability degree and siblings are whole numbers. The income is only compared with limits, so `BigDecimal` would add complexity for nothing. |
| Q7 | What does the program return? | The enum `Scholarship` with five values: `EXCELLENCE`, `RESIDENCE`, `LARGE_FAMILY`, `INCLUSION` and `NONE`. Only the category, not the amounts. | The statement asks to determine the category. Every test compares with one value, and there are no amounts to calculate or texts to compare. |

## For Pair 3 – test design (Step 2)

You design the tests from this README and the code of `develop`, and deliver `ISO2-2026-Grupo3A102-Testing-P2.pdf` (all the sections that the statement asks for in ET.02.00 and TW.02.01).

- **Inputs and outputs:** the five input data of the table "Valid input data" and the six results (five values of `Scholarship`, plus the exception for invalid data).
- **Decision table:** the table "The rules of the statement", read from top to bottom. The code follows the same order with simple `if` statements.
- **Limits:** every limit is a named constant in the code, so you take the boundary values from them: GPA 5.0, 6.5 and 8.5; income 15,000, 20,000 and 30,000; distance 50; disability degree 33; siblings 3; and the ends of the valid ranges (GPA 0 and 10, disability 0 and 100).
- **Methods to test:** the table below is completed when task T2 is done.

| Class | Method | What it does | Throws |
|---|---|---|---|
| `Student` | constructor | *to be completed in T2* | *to be completed in T2* |
| *to be completed in T2* | *to be completed in T2* | *to be completed in T2* | – |

## For Pair 1 – JUnit tests (Step 3)

You write the tests from the PDF of Pair 3, in `src/test/java`, on a `hotfix` branch created from `develop`.

- **Rules:** JUnit 6 (`org.junit.jupiter`), one method per case, `@DisplayName` in English, arrange, act, assert. Do not change the production code; if a test fails, say whether the error is in the test or in the code (rule 17 of AGENTS.md).
- **Coverage:** at least 80 % of the lines with JaCoCo (D-004). Set `haltOnFailure` to `true` in `pom.xml`. The console classes of the package `ui` count too.
- **Reports:** fill in the wiki page [Test reports](https://github.com/JavierVilla5/ISO2-2026-Grupo3A102-Testing-P2/wiki/Test-reports) with the results of `mvn verify`.
- **Pull request:** to `develop`, approved by someone other than the author (D-001).
