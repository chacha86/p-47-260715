import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastNo = 0; // 가장 최근 생성된 명언 번호. 번호 관리
    int lastIndex = 0; // 가장 최근 생성된 명언의 배열 인덱스. 배열 관리
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
            else if (cmd.equals("목록")) {
                actionList();
            }
            else if (cmd.equals("삭제")) {
                actionDelete();
            }
        }
    }

    private void actionDelete() {
        for(int i = 1; i < lastIndex; i++) {
            wiseSayings[i] = wiseSayings[i + 1];
        }
        --lastIndex;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = lastIndex - 1; i >= 0; i--) {
            WiseSaying target = wiseSayings[i];
            System.out.println("%d / %s / %s.".formatted(target.no, target.author, target.content));
        }
    }

    private WiseSaying write(String content, String author) {
        WiseSaying w1 = new WiseSaying();
        wiseSayings[lastIndex] = w1;
        ++lastIndex;
        ++lastNo;
        w1.no = lastNo;
        w1.content = content;
        w1.author = author;

        return w1;
    }

    private void actionWrite() {

        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.no));
    }
}
