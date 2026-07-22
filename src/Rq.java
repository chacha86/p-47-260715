import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {

    String actionName;
    Map<String, String> paramMap = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];

        String queryString = cmdBits.length > 1 ? cmdBits[1] : "";
        String[] queryStringBits = queryString.split("&");

        paramMap = Arrays.stream(queryStringBits) // key1=value1, key2=value2 ...
                .map(part -> part.split("="))
                .filter(bits -> bits.length == 2 && bits[0] != null && bits[1] != null)// [key1, value1]
                .collect(
                        Collectors.toMap(
                                bits -> bits[0],
                                bits -> bits[1]
                        )
                );

    }


    public String getActionName() {
        return actionName;
    }

    public String getParam(String key, String defaultValue) {
        return paramMap.getOrDefault(key, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue) {

        String rst = getParam(key, "");

        try {
            return Integer.parseInt(rst);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력값을 넣어서 기본값으로 반환됩니다.");
            return defaultValue;
        }
    }
}
