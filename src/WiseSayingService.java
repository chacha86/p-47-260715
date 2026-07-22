import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingService {

    int lastId = 0;
    ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

    private int findIndexById(int id) {

        return IntStream.range(0, wiseSayings.size())
                .filter((i) -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

    }

    public WiseSaying findById(int id) {
        int idx = findIndexById(id);
        if(idx == -1) {
            return null;
        }

        return wiseSayings.get(idx);
    }

    public WiseSaying write(String content, String author) {
        ++lastId;
        WiseSaying w1 = new WiseSaying(lastId, content, author);
        wiseSayings.add(w1);

        return w1;
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public boolean delete(int id) {
        boolean rst = wiseSayings.removeIf(
                wiseSaying -> wiseSaying.getId() == id
        );
        return rst;
    }

    public List<WiseSaying> findAllIdDesc() {
        return wiseSayings.reversed();
    }
}
