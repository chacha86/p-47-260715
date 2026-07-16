import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        String cmd = "";

        while(!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if(cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
            }
        }
    }
}
