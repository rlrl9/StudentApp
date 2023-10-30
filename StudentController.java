package jpamvcexam.controller;

import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.dto.Student;

import java.util.List;

public class StudentController {
    private StudentDAO dao= new StudentDAO();

    public StudentController() {
    }

    public void printAll(){
        List<Student> list = dao.getAllStudent();
        for(Student vo : list) {
            System.out.println("이름 : "+vo.getName()+", 성적 : "+vo.getScore());
        }
    }
    public void printScore(String name){
        Student vo= dao.getScore(name);
        if(vo==null){
            System.out.println(name+" 학생은 존재하지 않습니다.");
        }else{
            System.out.println(name+" 학생의 점수는 "+vo.getScore()+"입니다.");
        }

    }
    public void insert(String name, int score){
        Student vo = new Student();
        vo.setName(name);
        vo.setScore(score);
        System.out.println(vo);
        boolean result = dao.insertStudent(vo);
        if (result)
            System.out.println("입력 성공");
        else
            System.out.println("입력 실패");
    }
    public void update(String name, int score){
        Student vo= dao.getScore(name);
        if(vo!=null){
            boolean result = dao.updateStudent(vo);
            vo.setScore(score);
            System.out.println(name+" 학생의 점수를 변경했습니다.");
        }
        else
            System.out.println(name+" 학생은 존재하지 않습니다.");
    }
    public void delete(String name){
        Student vo= dao.getScore(name);
        if(vo!=null){
            boolean result = dao.deleteStudent(name);
            System.out.println(name+" 학생의 데이터를 삭제했습니다.");
        }
        else
            System.out.println(name+" 학생은 존재하지 않습니다.");
    }
    public void close() {
        dao.close();
    }
}
