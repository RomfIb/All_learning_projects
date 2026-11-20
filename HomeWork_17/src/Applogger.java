import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import Enum.*;
public class Applogger {
    private Path path;


    public Applogger(Path path) {
        this.path = path;
    }

    public void log(LogInfo l, String message) {
        try {
            LocalDateTime now = LocalDateTime.now();
            Files.writeString(this.path, now + ": " + l + ": " + message + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            throw new RuntimeException("Cannot write log", e);
        }
    }
}
