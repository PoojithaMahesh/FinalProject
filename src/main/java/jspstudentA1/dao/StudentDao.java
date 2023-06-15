package jspstudentA1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jspstudentA1.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}

public Student saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
	return student;
}
public List<Student> getAllStudent(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select a from Student a");
	List<Student> list=query.getResultList();
	return list;
}

public Student getStudentByEmail(String email) {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select a from Student a where a.studentEmail=?1");
	query.setParameter(1, email);
	return (Student) query.getSingleResult();
}

public void deleteStudentById(int id) {
EntityManager entityManager=getEntityManager();
Student student=entityManager.find(Student.class, id);
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.remove(student);
	entityTransaction.commit();
}

public Student getStudentById(int id) {
EntityManager entityManager=getEntityManager();
Student student=entityManager.find(Student.class, id);
	return student;
}

public void updateStudent(int id, Student student) {
	EntityManager entityManager=getEntityManager();
	Student student2=entityManager.find(Student.class, id);
	if(student2!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		student.setStudentId(id);
		entityManager.merge(student);
		entityTransaction.commit();
	}
}

}
