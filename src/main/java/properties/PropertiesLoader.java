package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    static java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(PropertiesLoader.class.toString());

    public static Properties getProperties(){
        return loadPropertiesFile("config.properties");
    }
    private static Properties loadPropertiesFile(String filePath) {
        logger.info("Properties file: " + filePath);
        Properties prop = new Properties();
        try (InputStream resourceAsStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            logger.info("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
