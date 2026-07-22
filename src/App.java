import java.util.Scanner;

public class App {

    Scanner sc = AppContext.sc;
    WiseSayingController wiseSayingController = AppContext.wiseSayingController;

    public void run() {

        System.out.println("== 명언 앱 ==");

        String cmd = "";
        while (!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                wiseSayingController.actionWrite(); // mac : option + enter, win : alt + enter
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.startsWith("삭제")) {
                wiseSayingController.actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                wiseSayingController.actionModify(cmd);
            } else if (!cmd.equals("종료")) {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }
    }
}
