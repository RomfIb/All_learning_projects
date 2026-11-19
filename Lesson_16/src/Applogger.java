import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Applogger {
    private Path path;


    public Applogger(Path path) {
        this.path = path;
    }

    public void log(String message) {
        try {
            LocalDateTime now = LocalDateTime.now();
            Files.writeString(this.path, now + ": " + message + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            throw new RuntimeException("Cannot write log", e);
        }
    }
}
