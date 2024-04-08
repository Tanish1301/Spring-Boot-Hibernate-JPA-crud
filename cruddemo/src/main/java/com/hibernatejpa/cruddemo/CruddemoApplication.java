package com.hibernatejpa.cruddemo;

import com.hibernatejpa.cruddemo.dao.StudentDAO;
import com.hibernatejpa.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: "+ numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve based on id
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change firstname to scooby
		System.out.println("Updating student.....");
		myStudent.setFirstName("Tanish");

		//update student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("S");

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ramu", "S", "ramu@gmail.com");

		// save the student
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student, Generated id: " + theId);

		//retrieve student based on the id; primary key
		System.out.println("Retrieving student id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found Student "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student objects....");
		Student tempStudent1 = new Student("Srinivas","K","srinu@gmail.com");
		Student tempStudent2 = new Student("Vikas","V","viks@gmail.com");
		Student tempStudent3 = new Student("Rajesh","Sagar","rajesh@gmail.com");

		//save student objects
		System.out.println("Saving the students.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("tanish","kavali","tanish@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the save student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
