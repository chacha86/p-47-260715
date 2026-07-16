import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastNo = 0;
    WiseSaying[] wiseSayings = new WiseSaying[10];
    // run 함수가 길다 => 길다.
    // run 함수는 길이가 적절하다. => 적절하다
    // run 함수는 충분히 짧다. => 짧다
    // 코드의 길이는 절대 규칙은 없고 팀 상황에 따라 다르다.

    // 나눌 필요가 있다면 최대한 응집도 있게
    public void run() {

        System.out.println("== 명언 앱 ==");

        String cmd = "";
        while (!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                actionWrite(); // mac : option + enter, win : alt + enter
            }
            if (cmd.equals("목록")) {
                actionList();
            }
        }
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = lastNo - 1; i >= 0; i--) {
            WiseSaying target = wiseSayings[i];
            System.out.println("%d / %s / %s.".formatted(target.no, target.author, target.content));
        }
    }

    private void actionWrite() {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSayings[lastNo] = wiseSaying;

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
}
