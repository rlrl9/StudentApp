package jpamvcexam.mainview;

import jpamvcexam.controller.StudentController;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        StudentController stc = new StudentController();
        int score;
        String name;
        while (true) {
            System.out.print("처리하려는 기능을 선택하세요.\n1.학생 정보 출력\n2.학생 정보 입력\n3.학생 정보 삭제\n4.학생 정보 수정\n5.학생 점수 확인\n6.종료\n입력: ");
            num = sc.nextInt();
            if(num==1){
                stc.printAll();
            }
            else if(num==2){
                System.out.println("작성하려는 학생 정보를 입력하세요.");
                System.out.print("학생 이름 : ");
                name= sc.next();
                System.out.print("학생 점수 : ");
                score= sc.nextInt();
                stc.insert(name,score);
            } else if (num==3) {
                System.out.println("삭제하려는 학생 이름을 입력하세요.");
                System.out.print("학생 이름 : ");
                name= sc.next();
                stc.delete(name);
            } else if (num==4) {
                System.out.println("수정하려는 학생 이름을 입력하세요.");
                System.out.print("학생 이름 : ");
                name= sc.next();
                System.out.print("학생 점수 : ");
                score= sc.nextInt();
                stc.update(name,score);
            } else if (num==5) {
                System.out.println("확인하려는 학생 이름을 입력하세요.");
                System.out.print("학생 이름 : ");
                name= sc.next();
                stc.printScore(name);
            } else if (num==6) {
                stc.close();
                break;
            }
        }
        sc.close();
    }
}
