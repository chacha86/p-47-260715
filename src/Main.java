import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        String cmd = sc.nextLine();

        sc.close();
    }
}
