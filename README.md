# 🎓 Student Management System

A web-based **Student Management System** developed using **Java Servlets, JDBC, HTML, CSS, and Oracle Database**.

This project provides a simple and user-friendly interface to register, search, update, and delete student records.

---

## 📌 Project Overview

The Student Management System is designed to manage student information efficiently through a web application.

The application connects the frontend with an Oracle database using **Java Servlets and JDBC**.

It supports basic **CRUD operations** on student records.

---

## ✨ Features

- 📝 **Student Registration** – Add new student records
- 🔍 **Search Student** – Search students using Roll Number
- ✏️ **Update Student** – Modify existing student information
- 🗑️ **Delete Student** – Remove student records
- 🔐 **Admin Login** – Simple login authentication
- 🎨 **User-Friendly Interface** – Clean and responsive web design
- 🗄️ **Oracle Database** – Stores student and login information

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Backend programming |
| Java Servlets | Server-side application logic |
| JDBC | Database connectivity |
| HTML5 | Web page structure |
| CSS3 | User interface and styling |
| Oracle Database | Data storage |
| Apache Tomcat 9 | Web server |
| Eclipse IDE | Development environment |

---

## 🏗️ Architecture

```text
User
  ↓
HTML / CSS
  ↓
Java Servlets
  ↓
JDBC
  ↓
Oracle Database

🔄 CRUD Operations
Operation	Description
Create	Register a new student
Read	Search student details
Update	Modify student information
Delete	Remove a student record

📁 Project Structure
StudentRegistration
│
├── src
│   └── main
│       └── java
│           └── process
│               ├── ProcessRegistrationServlet.java
│               ├── LoginServlet.java
│               ├── SearchServlet.java
│               ├── DeleteServlet.java
│               └── UpdateServlet.java
│
├── src
│   └── main
│       └── webapp
│           ├── index.html
│           ├── registration.html
│           ├── login.html
│           ├── search.html
│           ├── delete.html
│           ├── update.html
│           ├── style.css
│           └── WEB-INF
│
├── .gitignore
└── README.md
🗄️ Database

The application uses Oracle Database for storing student information.

Student Registration Table
CREATE TABLE STUDENT_REGISTRATION (
    NAME VARCHAR2(100),
    ROLLNO VARCHAR2(20) PRIMARY KEY,
    SECTION VARCHAR2(10),
    CGPA NUMBER(4,2),
    INTERESTED_DOMAIN VARCHAR2(100),
    COURSE VARCHAR2(100)
);
Login Users Table
CREATE TABLE LOGIN_USERS (
    USERNAME VARCHAR2(50) PRIMARY KEY,
    PASSWORD VARCHAR2(50) NOT NULL
);
🚀 How to Run the Project
Requirements
Java JDK
Eclipse IDE
Apache Tomcat 9
Oracle Database
Oracle JDBC Driver
Steps
Clone or download this repository.
Import the project into Eclipse.
Configure Apache Tomcat 9.
Configure the Oracle Database.
Add the Oracle JDBC driver to the project.
Update the database connection configuration.
Run the project using Apache Tomcat.
Open the application in a browser.
http://localhost:8085/StudentRegistration/
🔐 Security Note

For learning purposes, database credentials are configured locally.

Do not upload real database passwords, API keys, or other secrets to GitHub.

For production applications, credentials should be stored securely using environment variables or external configuration.

📸 Screenshots

Screenshots of the application can be added here.

Home Page
<img width="960" height="540" alt="Screenshot 2026-09-11 100331" src="https://github.com/user-attachments/assets/3653182f-97aa-4599-8e6a-be6db5556bb0" />
<img width="960" height="540" alt="Screenshot 2026-09-11 100314" src="https://github.com/user-attachments/assets/21badf0f-ce0f-4380-af96-a6721a6ab097" />



Student Registration

<img width="960" height="540" alt="Screenshot 2026-09-11 100435" src="https://github.com/user-attachments/assets/731659eb-a7cb-4b83-8d85-0c4e3fdcac37" />


Search Student

<img width="960" height="540" alt="Screenshot 2026-09-11 100502" src="https://github.com/user-attachments/assets/6adcb3c7-6d80-4c73-8af1-9b06a591295a" />


Update Student

<img width="960" height="540" alt="Screenshot 2026-09-11 100603" src="https://github.com/user-attachments/assets/a4e34bfb-2a39-4ea2-9f19-eee6531d8a86" />


Delete Student

<img width="960" height="540" alt="Screenshot 2026-09-11 100653" src="https://github.com/user-attachments/assets/820c90ac-6470-45dd-8404-a761b78f84e5" />


Login

<img width="960" height="540" alt="Screenshot 2026-09-11 100726" src="https://github.com/user-attachments/assets/4ffef402-b141-46c4-b3fe-96e58fc47e3d" />


🔮 Future Enhancements
👨‍💼 Admin Dashboard
👨‍🎓 Student Dashboard
🔒 Password Encryption
👥 Role-Based Authentication
📊 Student Statistics and Reports
📄 Export Student Records
📱 Improved Mobile Responsiveness
☁️ Cloud Deployment
🔎 Advanced Student Search
📧 Email Notifications
🎯 Learning Outcomes

Through this project, I gained practical experience in:

Java Servlet development
JDBC database connectivity
Oracle SQL
CRUD operations
HTML and CSS
Client-server architecture
Apache Tomcat
Git and GitHub
Web application development
👩‍💻 Developer

Sravani

B.Tech – Computer Science and Engineering

⭐ If you find this project useful, feel free to star the repository!


### Now

Paste this into GitHub's **`README.md`** editor.

Then scroll down to **Commit changes** and use:

**Commit message:**
```text
Add professional README
