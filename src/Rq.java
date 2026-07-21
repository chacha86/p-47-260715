public class Rq {

    private String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }

    public String getActionName() {
        // 문자열 쪼개기 -> split

        String[] cmdBits = cmd.split("\\?"); // ?기호를 기준으로 잘라줌. ["삭제", "id=1"]
        return cmdBits[0];
    }
}
