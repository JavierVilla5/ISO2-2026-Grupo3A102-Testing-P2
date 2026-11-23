# Plan – R22 – Rule 22 of AGENTS.md: open the pull request last (#24)

| | |
|---|---|
| **Issue** | #24 · branch `feature/rule-22` · sub-issue of #5 (Repo setup) |
| **Step** | Repo setup (no step of the program) |
| **Specification** | issue #24; rule 9 of `AGENTS.md` (changes to `AGENTS.md` need the approval of the member) |
| **Decisions** | D-006 (working method), D-010 (English), D-011 (issues in progress) |
| **Plan approved by** | Javier, 23/11/2026 |

## Questions and answers
- **Q:** Which text has the rule? **A:** The text that Javier approved in the chat, without changes (Javier, 23/11/2026).
- **Q:** Is there a new entry in `DECISIONS.md` (D-012)? **A:** No: the rule alone is enough (Javier, 23/11/2026).
- **Q:** Where does the rule go? **A:** After rule 21 and before the sentence "If two sources disagree…". No other rule changes, and no file counts the rules (checked with a search in the `.md` files).
- **Q:** Name of this plan and number of steps? **A:** `doc/plans/R22-open-the-pull-request-last.md`, two steps (Javier, 23/11/2026).

## Files
| File | Action | What |
|---|---|---|
| `doc/plans/R22-open-the-pull-request-last.md` | create | this plan |
| `AGENTS.md` | change | add rule 22 after rule 21 |

The text of the rule, exactly as it will be written:

```
22. **Open the pull request last.** Do not open a pull request until everything of the task is committed and pushed:
    the code, the documents that the issue asks for, and the plan with every step ticked and its Status up to date
    (cycle step 8). Check that `git status` is clean and that `git log origin/<branch>..HEAD` shows nothing. Once the
    pull request is open, push nothing more to its branch except what a reviewer asks for in it.
```

Not in this task: `DECISIONS.md`, any other rule, the program and the CI. No test is written (rule 17).

## Steps
Tick each step with the hash of its commit.
- [x] 1. This plan (743672c)
- [x] 2. Rule 22 in `AGENTS.md` (b4581c1), and the plan ticked with the hashes; push everything
- [ ] 3. Open the pull request to `develop` with `Closes #24`, only when everything is pushed and Javier asks; check that the CI is green

## Verification
- [x] The text of rule 22 is the approved one, after rule 21, and nothing else of `AGENTS.md` changed (`git diff` shows only added lines).
- [x] `mvn -B verify` is green (the CI also runs it).
- [ ] The CI is green on the pull request.

## Status
- **In progress:** nothing
- **Next step:** push everything and, when Javier asks, step 3, the pull request with `Closes #24`
- **Open questions:** none
- **Last update:** 23/11/2026, Javier's agent
