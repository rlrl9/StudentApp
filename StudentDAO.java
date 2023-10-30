package jpamvcexam.model.dao;

import jpamvcexam.model.dto.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class StudentDAO {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
    EntityManager em = factory.createEntityManager();
    public void close() {
        em.close();
        factory.close();
    }
    public boolean insertStudent(Student entity){
        boolean result = true;
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    public List<Student> getAllStudent(){//데이터가 없으면 비어있는 리스트 리턴
        TypedQuery<Student> q = em.createQuery("select t from Student t", Student.class);
        List<Student> list = q.getResultList();
        return list;
    }
    public Student getScore(String name){//존재하지 않는 학생명으로 호출하면 null 리턴
        Student vo = em.find(Student.class, name);
        return vo;
    }
    public boolean updateStudent(Student entity){
        boolean result = true;
        try {
            em.getTransaction().begin();
            Student oldVo = em.find(Student.class, entity.getName());
            System.out.println(oldVo.getName());
            oldVo.setScore(entity.getScore());
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    public boolean deleteStudent(String name){
        boolean result = true;
        try {
            em.getTransaction().begin();
            Student vo = em.find(Student.class, name);
            em.remove(vo);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

}
