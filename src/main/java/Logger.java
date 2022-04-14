import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private int count = 1;

    private static Logger instance = null;

    private Logger() {
    }

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + " " + count++ + "]" + " " + msg);
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }


}
