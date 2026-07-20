import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastNo = 0; // 가장 최근 생성된 명언 번호. 번호 관리
    int lastIndex = 0; // 가장 최근 생성된 명언의 배열 인덱스. 배열 관리
    WiseSaying[] wiseSayings = new WiseSaying[10];

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
            else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            }
        }
    }

    private void actionDelete(String cmd) {

        // 삭제?id=4 에서 1만 가져오는 법
        // =까지 자르고, 그 뒤에 있는 1을 가져오기


        String strId = cmd.substring(cmd.indexOf("=") + 1).trim();
        int id = Integer.parseInt(strId);

        int targetIdx = -1;

        for(int i = 0; i < lastIndex; i++) {
            WiseSaying w1 = wiseSayings[i];
            if(w1.no == id) {
               targetIdx = i;
            }
        }

        for(int i = targetIdx; i < lastIndex; i++) {
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
