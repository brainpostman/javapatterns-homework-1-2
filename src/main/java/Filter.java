import java.util.List;

public class Filter {
    protected int criterion;

    public Filter(int criterion) {
        this.criterion = criterion;
    }

    public int getCriterion() {
        return criterion;
    }

    public void setCriterion(int criterion) {
        this.criterion = criterion;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        return list.stream()
                .peek(num -> {
                    if (num > criterion) {
                        logger.log("Элемент " + num + " проходит");
                    } else {
                        logger.log("Элемент " + num + " не проходит");
                    }
                })
                .filter(num -> num > criterion)
                .toList();
    }
}
