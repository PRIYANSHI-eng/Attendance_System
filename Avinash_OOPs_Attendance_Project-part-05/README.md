# School Attendance System
This is a 10-part code-along project to build a console-based school attendance system in Java.

## Part 1: Introduction and Orientation
- Verified Java and Git setup.
- Initialized Git repository for the project.
- Created basic project structure with `Main.java`.
- Compiled and ran the initial "Welcome" program.
- Pushed initial setup to a `part-01` branch on GitHub and created a PR.

### How to Run
1. Navigate to the project root directory (`AttendanceSystem`).
2. Compile: `javac src/com/school/Main.java`
3. Run: `java -cp src com.school.Main`

4. ## Session 2: Core Domain Modelling
- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters (e.g., `student1.getStudentId()`) when creating records.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java` (or list individual files including `AttendanceRecord.java`)
3. Run: `java -cp src com.school.Main`

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

## Part 6: File storage (Storable + FileStorageService)

- Added `Storable.java` interface with `String toDataString()` for serializing domain objects to CSV-like lines.
- Implemented `toDataString()` in:
	- `Student.java` -> returns `id,name,gradeLevel`
	- `Course.java` -> returns `courseId,courseName`
	- `AttendanceRecord.java` -> returns `studentId,courseId,status`
- Added `FileStorageService.java` which exposes `saveData(List<? extends Storable> items, String filename)` and writes each item's `toDataString()` to the given file using `PrintWriter` + `FileWriter` (try-with-resources).
- Updated `Main.java` to create sample `students`, `courses`, and `attendance` lists, then call `saveData(...)` to write three files: `students.txt`, `courses.txt`, and `attendance_log.txt`.

### Verifying output files

1. After running `Main`, three files are created in the working directory where the JVM was launched:
	 - `students.txt` (format: `id,name,gradeLevel`)
	 - `courses.txt` (format: `courseId,courseName`)
	 - `attendance_log.txt` (format: `studentId,courseId,status`)
2. Example contents produced by the included sample run:

```
students.txt
1,Alice,10th
2,Bob,9th

courses.txt
C101,Mathematics
C102,Science

attendance_log.txt
1,C101,Present
2,C102,Absent
```

If you don't see the files in the project root, check the current working directory used when launching the JVM and look there for the three files.

### How to compile & run (recommended)

From the project root (this repository):

```bash
javac -d out src/com/school/*.java
java -cp out com.school.Main
```

This will produce `students.txt`, `courses.txt`, and `attendance_log.txt` in the directory you run the command from.
