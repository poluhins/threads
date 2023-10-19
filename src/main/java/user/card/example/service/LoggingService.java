package user.card.example.service;

public class LoggingService {

    public void logObj(Object obj) {
        log(obj.toString());
    }

    public void log(String logStr) {
        System.out.println("LOG :: " + logStr);
    }

}
