# EventBus Counter

A simple Android application demonstrating the use of [GreenRobot EventBus](https://github.com/greenrobot/EventBus) for communication between Fragments.

## Overview

In this project, we have two fragments:
1.  **HomeFragment**: Displays the current counter value. It subscribes to `CounterEvent`.
2.  **ControlFragment**: Contains buttons to increment and decrement the counter. It posts `CounterEvent` when buttons are clicked.

Using EventBus simplifies communication by decoupling the sender and the receiver. No interfaces or listeners are required between the fragments.

## Features

-   Increment/Decrement counter.
-   Real-time UI update using EventBus.
-   Decoupled architecture.

## How it works

1.  **Define the event**: `CounterEvent` is a simple data class.
2.  **Post the event**: `ControlFragment` calls `EventBus.getDefault().post(CounterEvent(value))`.
3.  **Subscribe to the event**: `HomeFragment` uses `@Subscribe` annotation to receive and handle the event.
4.  **Register/Unregister**: `HomeFragment` registers to EventBus in `onStart()` and unregisters in `onStop()`.

## Dependencies

-   [EventBus](https://github.com/greenrobot/EventBus)
-   View Binding
-   AndroidX Libraries (AppCompat, ConstraintLayout, etc.)
-   Kotlin DSL for Gradle

## License

This project is licensed under the MIT License.
