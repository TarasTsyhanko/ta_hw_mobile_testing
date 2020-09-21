package utils;

import config.Properties;
import listener.GmailTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileReader {
    private static final Logger log = LogManager.getLogger(FileReader.class);

    public static Letter getLetter() {
        return readFile(Properties.getLetterFilePath(), Letter.class);
    }

    public static <T> T readFile(String path, Class<T> tClass) {
        T object = null;
        try {
            object = new ObjectMapper().readValue(new File(path), tClass);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return object;
    }
}
