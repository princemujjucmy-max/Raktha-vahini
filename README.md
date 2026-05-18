# Rakta-Vahini 🩸

A **filtered, privacy-first blood donor network** — an Android app built for the
MindMatrix VTU Internship Program (Project 07, Healthcare).

When a rural hospital needs blood, people rely on noisy WhatsApp "mass forwards".
Rakta-Vahini replaces that with a managed directory that only surfaces donors of
the **correct blood group** who are **currently eligible** (have not donated in
the last 90 days) and **nearby**.

## Tech stack

- **Kotlin** + **Jetpack Compose** (Material 3)
- **Room** for local persistence
- **Navigation Compose** with a bottom navigation bar
- MVVM — `RaktaViewModel` + `RaktaRepository`

## Features (mapped to the brief)

| Brief requirement | Where it lives |
|---|---|
| Donor Profile (group, location, last donation) | `ProfileScreen` |
| Emergency Search (group → eligible donors nearby) | `SearchScreen` |
| "I am Eligible" / Ready-to-Donate toggle | Home + Profile screens |
| Donation Log (personal history) | `DonationLogScreen` |
| 90-day eligibility logic | `util/Eligibility.kt` |
| 10 km / 20 km radius filter | `SearchScreen` |
| Call donors without showing numbers | `DonorCard` → `ACTION_DIAL` Intent |
| "Thank You" notification after logging | `util/Notifications.kt` |
| Search hides ineligible donors | `SearchScreen` filter |

## Running it

1. Open the `rakta/` folder in **Android Studio** (Hedgehog or newer).
2. Let Gradle sync — it downloads the wrapper and dependencies automatically.
3. Run on an emulator or device (minSdk 24, targetSdk 34).

> The Gradle wrapper JAR is not committed. Android Studio regenerates it on the
> first sync. From a terminal you can also run `gradle wrapper` once if you have
> Gradle installed.

The app seeds a demo donor directory on first launch so Search works immediately.
