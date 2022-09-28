package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * PropertyManager class gets data with the help of a getProperty method from Property file.
 */
public class PropertyManager {

    private Map<String, Properties> map = new HashMap<>();
    Map<String, File> files = new HashMap<>();

    public PropertyManager() {
        files.put("pet", new File(ClassLoader
                .getSystemResource("properties/pet.properties")
                .getPath()));
        files.put("store", new File(ClassLoader
                .getSystemResource("properties/store.properties")
                .getPath()));

        for (File file : files.values()) {
            Properties props = new Properties();
            try {
                //load a property file
                props.load(Files.newInputStream(Paths.get("pet.properties")));

                //get the property value and print it out
                System.out.println(props.getProperty("id"));
                System.out.println(props.getProperty("name"));

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public String getProperty(String file, String key) {

        Properties props = map.get(file);

        if(props != null) {
            return props.getProperty(key);
        }
        return null;
    }
}
