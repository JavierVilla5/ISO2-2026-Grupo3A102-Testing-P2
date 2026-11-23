# Plan – Repo setup – Project board (#18)

| | |
|---|---|
| **Issue** | #18 · branch `feature/project-board` |
| **Step** | Repo setup (#5) · not part of the exercise |
| **Specification** | D-041 of the main repository (issues in progress); no statement rule applies |
| **Decisions** | D-006 (working method), D-001 (pull requests) |
| **Plan approved by** | Javier, 23/11/2026 |

## Questions and answers
- **Q:** Is the text of D-011 right, in the style of D-041 of the main repository? **A:** Yes (Javier, 23/11/2026).
- **Q:** May AGENTS.md change in step 1 of the cycle, as D-041 did there? **A:** Yes, one line (Javier, 23/11/2026).
- **Q:** May the issue #18 get a checkbox for D-011, and this plan be created? **A:** Yes (Javier, 23/11/2026).

## Files
| File | Action | What |
|---|---|---|
| `DECISIONS.md` | change | add D-011 · Issues in progress, and one agent per task at a time |
| `AGENTS.md` | change | step 1 of the cycle: check that nobody else works on the issue and remind the member to move it to *In progress* (D-011) |
| `doc/plans/project-board.md` | create | this plan |

Not part of this task: the Project, its access and its board view are already done (checked in #18). No code is written and no test (rule 17).

## Steps
Tick each step with the hash of its commit. There is no `pom.xml` on `develop` yet (task T1), so `mvn -B verify` cannot run in this task; the check is reading the diff.
- [ ] 1. Add D-011 to `DECISIONS.md`, and this plan
- [ ] 2. Change step 1 of the cycle in `AGENTS.md`

## Verification
- [ ] Every point of the issue #18 is checked.
- [ ] The text of D-011 is the one Javier approved.
- [ ] The diff only touches the three files above.
- [ ] `mvn -B verify`: not applicable until T1 is merged.

## Status
- **In progress:** step 1
- **Next step:** step 2, the line in `AGENTS.md`
- **Open questions:** none
- **Last update:** 23/11/2026, Javier
