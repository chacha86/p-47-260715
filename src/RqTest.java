public class RqTest {

    public static void main(String[] args) {

//        testActionName();
        testGetParam();

    }

    public static void testGetParam() {
        Rq rq = new Rq("목록?searchKeyword=영광"); // key=value
        String searchKeyword = rq.getParam("searchKeyword", ""); // "영광"

        System.out.println(searchKeyword); // 영광

        Rq rq2 = new Rq("목록?keywordType=content"); // key=value
        String keywordType = rq2.getParam("keywordType", "");

        System.out.println(keywordType); // content

        Rq rq3 = new Rq("목록?keywordType=author"); // key=value
        String keywordType2 = rq3.getParam("keywordType", "");

        System.out.println(keywordType2); // author
    }

    public static void testActionName() {
        Rq rq1 = new Rq("삭제?id=1");
        String action = rq1.getActionName();

        System.out.println(action); // 삭제

        Rq rq2 = new Rq("수정?id=1");
        String action2 = rq2.getActionName(); // 수정

        System.out.println(action2); // 수정
    }
}
