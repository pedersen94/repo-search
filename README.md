# Repository Search — Android Code Challenge

Build a repository search feature. The plumbing is scaffolded so you can spend
your time on **architecture decisions**, not boilerplate.

**Timebox: 20–30 minutes.** If you run out of time, leave comments describing
what you'd do — we care as much about your reasoning as your code.

## What the app should do
1. A search field at the top, debounced (~300ms).
2. A scrollable list of results: repo **name**, **description**, **star count**.
3. Distinct UI states: **loading**, **results**, **empty results**, **error**.
4. Survive configuration changes (rotation).

Try these queries against the provided fake: `kotlin`, `compose`, `error`
(throws), `zzz` (empty).

## Module layout (already set up)
```
:domain   Pure Kotlin/JVM. No Android/Compose/Retrofit — importing them won't compile.
          Domain model, repository interface, use case.
:data     DTO, remote data source + provided fake, repository implementation (stubbed).
:app      Compose UI, ViewModel, manual DI (wired for you in MainActivity).
```
Dependency direction: `:app` and `:data` depend on `:domain`; `:domain` depends on nothing.

## Where to work (look for `TODO(candidate)`)
- `data/RepositoryRepositoryImpl.kt` — implement + map DTO → domain.
- `app/SearchUiState.kt` — model the UI state.
- `app/SearchViewModel.kt` — query, debounce, cancellation, state.
- `app/SearchScreen.kt` — the UI.

## Ground rules
- Constructor injection only — don't `new` dependencies inside a class.
- Don't let DTOs leak past the data layer.
- Manual DI is fine; no need to add Hilt.

## Provided fake behaviour
- `delay(700)` to simulate latency.
- Query `"error"` throws; unmatched queries return an empty list.
