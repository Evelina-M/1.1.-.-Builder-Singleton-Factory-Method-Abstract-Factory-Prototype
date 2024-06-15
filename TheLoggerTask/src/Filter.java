import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (Integer number : source) {
            if (number > treshold) {
                result.add(number);
                logger.log("Элемент " + number + " проходит");
                count++;
            } else {
                logger.log("Элемент " + number + " не проходит");
            }
        }
        System.out.println("Прошло фильтр " + count + " элемента из " + source.size());
        logger.log("Фильтрация завершена");
        return result;
    }
}