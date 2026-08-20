# Interviewer Notes — not for the candidate

## Purpose
Separate mid from senior by *how* the feature is built: layering, dependency
direction, SOLID, and correct reactive/coroutine handling — not just "it works".

## The scaffold already enforces some things
- `:domain` is a pure Kotlin/JVM module, so `import android.*` / Compose / Retrofit
  there is a **compile error**. A candidate who tries to shortcut through the domain
  layer will be stopped by the build — watch how they react.
- DI is wired in `MainActivity`; nobody should need to `new` dependencies inside
  the ViewModel or repository. If they do, that's a DIP/testability red flag.

## Senior signals
- DTO → domain mapping in a dedicated mapper; DTOs never surface in UI.
- Sealed `SearchUiState`; illegal states unrepresentable.
- Debounce + `flatMapLatest` (or equivalent) so a new query cancels the in-flight
  one and slow old responses can't overwrite newer results.
- `collectAsStateWithLifecycle`, state via `SavedStateHandle` (survives process death),
  understands why over `rememberSaveable`.
- Error strategy (Result/typed errors) rather than raw exceptions to the UI.
- Could swap fake → real data source without touching domain/presentation.
- Has an opinion on whether the use case earns its place.

## Red flags
- DTO used directly in Compose / as the domain model.
- Repository interface in :data, or ViewModel constructing its own impl.
- Coroutine/network work in a composable body; no debounce; API on every keystroke.
- State lost on rotation with no awareness of why.
- Three-layer split that's cosmetic (logic all in the ViewModel).

## Verbal follow-ups (cheap, discriminating)
- Why does the repository interface live in :domain, not :data?
- What happens if a slow response for an old query lands after a newer one?
- Does every feature need a use case? When is it ceremony?
- Add an offline cache without changing the ViewModel or domain — how?
  (probes Open/Closed + DIP)
- `rememberSaveable` vs `SavedStateHandle` for surviving process death?
- What would fail to compile if someone imported `android.*` into `:domain`, and
  why is that a useful property?

## Scoring
See the rubric in the challenge doc. Weight architecture and behaviour together:
a cleanly layered app that hits the API every keystroke and loses state on rotation
is not senior — and neither is a race-free pipeline crammed into one file.
