import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastId = 0;
    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();


    public void run() {

        System.out.println("== 명언 앱 ==");

        String cmd = "";
        while (!cmd.equals("종료")) {
            System.out.print("명령) ");
            cmd = sc.nextLine();

            if (cmd.equals("등록")) {
                actionWrite(); // mac : option + enter, win : alt + enter
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
            } else if (!cmd.equals("종료")) {
                System.out.println("존재하지 않는 명령어입니다.");
            }
        }
    }

    // 너무 짧거나 너무 긴거 -> 그나마 긴게 나음
    public int findIndexById(int id) {

         return IntStream.range(0, wiseSayings.size())
                .filter((i) -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

    }

    private void actionModify(String cmd) {
        String strId = cmd.substring(cmd.indexOf("=") + 1).trim();
        int id = Integer.parseInt(strId);

        int targetIdx = findIndexById(id);


        //수정 로직
        WiseSaying wiseSaying = wiseSayings.get(targetIdx);

        System.out.println("명언(기존)): %s".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String content = sc.nextLine();
        wiseSaying.setContent(content);

        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseSaying.setAuthor(author);

    }

    private void actionDelete(String cmd) {

        String strId = cmd.substring(cmd.indexOf("=") + 1).trim();
        int id = Integer.parseInt(strId);

        int targetIdx = findIndexById(id);

        if (targetIdx == -1) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        wiseSayings.remove(targetIdx);
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying target = wiseSayings.get(i);
            System.out.println("%d / %s / %s.".formatted(target.getId(), target.getAuthor(), target.getContent()));
        }
    }

    private WiseSaying write(String content, String author) {
        ++lastId;
        WiseSaying w1 = new WiseSaying(lastId, content, author);
        wiseSayings.add(w1);

        return w1;
    }

    private void actionWrite() {

        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }
}
