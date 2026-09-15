# ASCEND v0.4.0 — Android real schedule/voice prototype

This is a native Android project (Java + classic Views) intended to stay light on an older PC.

## What is real in this build
- Add / edit / delete schedules.
- Start/end time picked with Android's native time picker.
- Repeat: every day, weekdays, weekend, once.
- Schedules persist locally.
- Exact alarm scheduling with Android AlarmManager where permission is available.
- Recurring schedules re-arm themselves after each start (until you edit/delete them).
- High-importance schedule notifications.
- Android Text-to-Speech when the schedule starts.
- `TEST VOICE` button for instant TTS verification.

## Not included yet
- App blocking/restriction engine.
- Cloud sync.
- AI-generated voices.
- Windows client.

## Build / test
Open the project folder in Android Studio, let Gradle sync, and run `app` on your emulator.

For Android 13+, allow notifications when prompted. On Android 12+, ASCEND may open the system screen for the exact-alarm permission; allow it for reliable scheduled starts.

Make a schedule for 1–2 minutes in the future and wait with the app closed. You should get a notification and a spoken reminder.

If the emulator has no TTS voice installed, open Android Settings > System > Languages & input > Text-to-speech and install/select an English voice.
