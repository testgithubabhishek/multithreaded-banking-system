# Multithreaded Database-Driven Banking System

A Java backend application simulating a concurrent, multi-user banking environment with robust security and package isolation.

---

## 🚀 Project Architecture
The project has evolved from a monolithic layout into a clean, object-oriented package structure designed for clear encapsulation:

*   **`com.bank.system`**: Core application bootloader and main execution loop.
*   **`com.bank.system.Accounts`**: Handles base core variables, initialization sequences, and account derivations like `Savings`.
*   **`com.bank.system.data`**: Manages underlying storage arrays (`AccountDetails`), checking structures, `Current` accounts, and abstract core interfaces.

---

## 🛠️ Current Stage: Phase 2 (Modular Console UI Engine)
We have successfully wrapped up the baseline structure and consolidated operations into a multi-tiered system:

*   **Interactive Switch-Case Console UI Loop**: Completely optimized user menu with full input buffer validation to prevent workflow skipping.
*   **Encapsulated Security**: Removed insecure getters (`getPassword`) and moved validation directly into the `Account` layer for safe confirmation checks.
*   **Unified Interface Contracts**: Standardized account capabilities by introducing a global `Services` interface handling `deposit`, `Withdraw`, and `accounBalance`.
*   **Unique Sequence Tracking**: Automatic tracking of individual account identifiers using internal state isolation mechanisms instead of vulnerable random strings.
*   **In-Memory Collections**: Managing runtime entities dynamically inside an `ArrayList` catalog baseline.

---

## 🎯 Future Milestones

*   [ ] **Polymorphic Payment Networks**: Introduce a `Transferable` layer to handle funds routing via Debit Card, Credit Card, and mock PayPal networks.
*   [ ] **Database Persistence**: Drop the local array lists and substitute a persistent storage system using MySQL and JDBC.
*   [ ] **Multithreading Concurrency**: Apply thread-safe counters and inject an `ExecutorService` thread pool to safely handle simultaneous banking transactions without race conditions.
