package demo.dso;

import org.noear.solon.Utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * <p><code>
 *     I18nUtils.get("appcode","code1");
 * </code></p>
 *
 * @author noear 2021/1/14 created
 */

public class I18nUtils {
    private static Map<String, Properties> i18nMap = new HashMap<>();

    public static String get(ClassLoader classLoader, Locale locale, String bundle, String name) {
        String fileName;
        if (locale != null) {
            fileName = bundle + "_" + locale.getLanguage() +"_"+locale.getCountry();
        } else {
            fileName = bundle;
        }

        Properties properties = i18nMap.get(fileName);

        if (properties == null) {
            synchronized (fileName.intern()) {
                properties = i18nMap.get(fileName);

                if (properties == null) {
                    URL url = Utils.getResource(classLoader, "i18n/" + fileName + ".properties");

                    if (url != null) {
                        properties = new Properties();

                        try {
                            properties.load(new InputStreamReader(url.openStream()));
                            i18nMap.put(fileName, properties);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }

        if (properties == null) {
            throw new IllegalArgumentException("There is no i18n file:" + fileName);
        } else {
            return properties.getProperty(name);
        }
    }

    public static String get(Locale locale, String bundle, String name) {
        return get(ClassLoader.getSystemClassLoader(), locale, bundle, name);
    }

    public static String get(String bundle, String name) {
        return get(ClassLoader.getSystemClassLoader(), Locale.getDefault(), bundle, name);
    }
}