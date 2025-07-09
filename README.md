#  Quantum Bookstore

##  Overview

**Quantum Bookstore** is a Java-based object-oriented simulation of an online bookstore, developed as part of the Fawry Quantum Internship Challenge. The system manages various types of books, supports purchasing, shipping, and emailing operations, and demonstrates solid design using abstraction, inheritance, interfaces, and polymorphism.

This project is designed to reflect real-world use cases using clean architecture and separation of concerns.

---

##  Features

-  Add and manage different types of books
-  Purchase paper and e-books with validation
-  Prevent purchase of showcase (display-only) books
-  Ship physical books to addresses
-  Email digital books to customers
-  Remove outdated books based on publication year
-  Interface-based service integration (ShippingService, MailService)

---

##  Book Types

| Type           | Description                                                                 |
|----------------|------------------------------------------------------------------------------|
| `PaperBook`    | Can be purchased and shipped to a physical address                          |
| `EBook`        | Can be purchased and emailed to the user                                     |
| `ShowcaseBook` | Not for sale, used only for display in the bookstore catalog                |

---

**Screenshots of test output are included in the `screenshots/` folder.**

---

##  How to Run

 Clone the repository:
   git clone https://github.com/MohamedMaher03/Online_Book_Store.git
   cd Online_Book_Store

    Open the project in VSCode or any Java IDE.

    Navigate to:src/QuantumBookstoreFullTest.java
    Run the test class and observe the console output.
