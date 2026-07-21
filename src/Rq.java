import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String cmd;
    Map<String, String> paramMap = new HashMap<>();

    public Rq(String cmd) {
        this.cmd = cmd;

        // 목록?keywordType=content&keyword=과거
        String[] cmdBits = cmd.split("\\?"); // ["목록", "keywordType=content&keyword=과거"]

        String params = cmdBits[1]; //"keywordType=content&keyword=과거"

        String[] paramBits = params.split("&"); //["keywordType=content", "keyword=과거"]

        String param1 = paramBits[0]; //"keywordType=content"
        String param2 = paramBits[1]; // "keyword=과거"

        String[] param1Bits = param1.split("="); // ["keyword", "content"]
        String[] param2Bits = param2.split("="); // ["keyword", "과거"]

        paramMap.put(param1Bits[0], param1Bits[1]); // paramBits[0]
        paramMap.put(param2Bits[0], param2Bits[1]);
    }

    public String getActionName() {
        // 문자열 쪼개기 -> split

        String[] cmdBits = cmd.split("\\?"); // ?기호를 기준으로 잘라줌. ["삭제", "id=1"]
        return cmdBits[0];
    }

    public String getParam(String key, String defaultValue) {



        if(key.equals("searchKeyword")) {
            return "영광";
        } else if(key.equals("keywordType")) {
            return "content";
        }

        return defaultValue;
    }
}
