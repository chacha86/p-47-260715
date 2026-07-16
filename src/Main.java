import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        String cmd = "";
        int lastNo = 0;
        WiseSaying wiseSaying =  new WiseSaying();

        while(!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if(cmd.equals("등록")) {

                System.out.print("명언 : ");
                wiseSaying.content = sc.nextLine();
                System.out.print("작가 : ");
                wiseSaying.author = sc.nextLine();
                // %d => 숫자
                // %s => 문자열
                ++lastNo;
                wiseSaying.no = lastNo;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.no));
            }

            if(cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("%d / %s / %s.".formatted(wiseSaying.no, wiseSaying.author, wiseSaying.content));
            }


        }
    }
}

class WiseSaying {
    int no;
    String content;
    String author;
}