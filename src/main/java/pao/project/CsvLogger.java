package pao.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CsvLogger {

    private static CsvLogger _logger = null;
    private FileOutputStream log;

    private CsvLogger() {

        File logFile = new File("log.csv");
        try {
            if(logFile.createNewFile()) {
                System.out.println("Creating log.csv");
            }
            else {
                System.out.println("Loading log.csv");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            log = new FileOutputStream(logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static CsvLogger getInstance() {
        if (_logger == null) {
            _logger = new CsvLogger();
        }

        return _logger;
    }

    public void logMessage(String message) {

        byte[] messageBytes = message.getBytes();
        byte comma = (byte) ',';
        byte[] timeBytes = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss")).getBytes();
        byte lineEnd = (byte) '\n';

        byte[] bytes = new byte[2 + messageBytes.length + timeBytes.length];
        System.arraycopy(messageBytes,0, bytes, 0, messageBytes.length);
        bytes[messageBytes.length] = comma;
        System.arraycopy(timeBytes, 0, bytes, messageBytes.length + 1, timeBytes.length);
        bytes[messageBytes.length + 1 + timeBytes.length] = lineEnd;

        try {
            log.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
