# Plan – Docs – Update the documentation with the requests of #155 (#27)

| | |
|---|---|
| **Issue** | #27 · branch `feature/docs-update-155` · sub-issue of #5 (Repo setup) |
| **Step** | Repo setup (no step of the program) |
| **Specification** | comment of Marcos in [igrt08-uclm/2026-ISO2-3A1.02#155](https://github.com/igrt08-uclm/2026-ISO2-3A1.02/issues/155); rule 9 of `AGENTS.md` (changes to `AGENTS.md` and `DECISIONS.md` need the approval of the member) |
| **Decisions** | D-006 (working method), D-010 (English), D-011 (issues in progress) |
| **Plan approved by** | Javier, 24/11/2026 |

## Questions and answers
- **Q:** Which issues trigger the warning about the main repository? **A:** The issues of a task of this repository (T1, T2, T3…), not only the step issues (Javier, 24/11/2026).
- **Q:** What does the agent remind, and who does it? **A:** When a task issue is closed, the agent reminds the member to tick the matching checkbox of the step issue of the main repository (#159, #160 or #161). When the last task of the step is closed, it reminds the member to close that issue too. The member does it by hand; the agent never touches the main repository (rule 8) (Javier, 24/11/2026).
- **Q:** One task or three? **A:** One issue (#27) and one branch for the three changes (Javier, 24/11/2026).
- **Q:** Is the text of D-012, D-013 and rule 23 below right? **A:** Yes, approved as drafted (Javier, 24/11/2026).
- **Q:** The wiki page *Time tracking* is not in Git. When is it created? **A:** Pending: only when Javier asks for that exact action (rule 8), after reading the page of P1.

## Files
| File | Action | What |
|---|---|---|
| `doc/plans/docs-update-155.md` | create | this plan |
| `DECISIONS.md` | change | add D-012 (SOLID) and D-013 (parent issue reminder) |
| `AGENTS.md` | change | rule 5 references D-012; new rule 23 (parent issue reminder) |
| Wiki *Time tracking* | create (GitHub, not in Git) | same layout as the P1 wiki; only when Javier asks |

Drafts of the texts, to be approved before they are written:

**`DECISIONS.md`, D-012 · Follow the SOLID principles to make the program easy to test.** Date 24/11/2026 · Step 1 · Issue #27. Context: statement ET.02.00 (practical session 0) encourages SOLID, and Marcos added the same decision in P1 (D-012 there). Decision: the program follows the SOLID principles pragmatically, without overengineering: data and validation (`Student`), rules (`ScholarshipSelector`) and console (`ui`) are separate classes with one responsibility; the limits are named constants; the domain does not depend on the console. Alternatives: ignore SOLID, or add layers and frameworks that make Steps 2 and 3 harder. Consequences: extends D-003 and D-008; the program is frozen (D-007), so reviewing it against SOLID is issue #23, not this one.

**`DECISIONS.md`, D-013 · Reminder to close the issue of the main repository.** Date 24/11/2026 · Step 1 · Issue #27. Context: each step issue of the main repository (#159, #160, #161) has a checklist that our tasks fulfil, and nothing reminds us to update it. A `Closes` keyword would close it with the first merged pull request, before the step ends. Decision: the member updates the issue of the main repository by hand, and the agent reminds the member every time a task issue is closed. Alternatives: `Closes` in every pull request; closing it by hand with no reminder. Consequences: rule 23 of `AGENTS.md`.

**`AGENTS.md`, rule 5:** `5. **Keep it simple and follow SOLID (D-012).** The smallest cohesive code that meets the specification and applies the SOLID principles: no extra features and no overengineering. The simpler and better decoupled the program, the easier it is to test.`

**`AGENTS.md`, rule 23, after rule 22:**
```
23. **Remind the member about the main repository** (D-013). When a task issue of this repository is closed, remind
    the member to tick the matching checkbox of the step issue of the main repository (#159, #160 or #161) and, if it
    was the last task of the step, to close that issue too. Never do it yourself (rule 8).
```

Not in this task: the program (frozen, D-007), the review of SOLID (#23), `pom.xml`, the CI and any other rule. No test is written (rule 17).

## Steps
Tick each step with the hash of its commit.
- [ ] 1. This plan
- [ ] 2. D-012 in `DECISIONS.md` and rule 5 of `AGENTS.md`
- [ ] 3. D-013 in `DECISIONS.md` and rule 23 of `AGENTS.md`
- [ ] 4. Wiki *Time tracking* (only when Javier asks) and a line in the wiki *Traceability*
- [ ] 5. Open the pull request to `develop` with `Closes #27`, only when everything is pushed and Javier asks (rule 22)

## Verification
- [ ] The texts are the approved ones and nothing else of `AGENTS.md` or `DECISIONS.md` changed (`git diff` shows only these lines).
- [ ] No file counts the rules or the decisions (checked with a search in the `.md` files).
- [ ] `mvn -B verify` is green (the CI also runs it).

## Status
- **In progress:** nothing
- **Next step:** step 2, D-012 in `DECISIONS.md` and rule 5 of `AGENTS.md`
- **Open questions:** when to create the wiki page
- **Last update:** 24/11/2026, Javier's agent
