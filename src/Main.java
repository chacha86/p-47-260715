import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        String cmd = "";
        int no = 1;

        while(!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if(cmd.equals("등록")) {

                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                // %d => 숫자
                // %s => 문자열
                System.out.println("%d번 명언이 등록되었습니다.".formatted(no));
                ++no;
            }
        }
    }
}
