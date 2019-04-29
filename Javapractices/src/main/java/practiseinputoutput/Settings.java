package practiseinputoutput;

import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static final Settings INSTANCE = new Settings();

        private final Properties properties = new Properties();

        private Settings(){
            try{
                properties.load(getClass().getClassLoader().getResourceAsStream("filename.properties"));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        public static Settings getInstance(){
            return INSTANCE;
        }

        public String value(String key){
            return this.properties.getProperty(key);
        }
}
