import java.util.List;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();


    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public WiseSaying write(String content, String author) {

        WiseSaying w1 = new WiseSaying(content, author);
        WiseSaying savedWiseSaying = wiseSayingRepository.save(w1);

        return savedWiseSaying;
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public boolean delete(int id) {
        boolean rst = wiseSayingRepository.delete(id);
        return rst;
    }

    public List<WiseSaying> findAllIdDesc() {

        return wiseSayingRepository.findAllIdDesc();
    }
}
