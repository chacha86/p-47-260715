import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String cmd;
    Map<String, String> paramMap = new HashMap<>();

    public Rq(String cmd) {
        this.cmd = cmd;

        // 목록?keywordType=content&keyword=과거
        String[] cmdBits = cmd.split("\\?"); // ["목록", "keywordType=content&keyword=과거"]

        String params = cmdBits[1]; //"keywordType=content&keyword=과거&page=1"
        String[] paramBits = params.split("&"); //["keywordType=content", "keyword=과거", "page=1"]

        for (String param : paramBits) {
            String[] keyValue = param.split("=");
            paramMap.put(keyValue[0], keyValue[1]);
        }

    }

    public String getActionName() {
        // 문자열 쪼개기 -> split

        String[] cmdBits = cmd.split("\\?"); // ?기호를 기준으로 잘라줌. ["삭제", "id=1"]
        return cmdBits[0];
    }

    public String getParam(String key, String defaultValue) {
        return paramMap.get(key);
    }
}
