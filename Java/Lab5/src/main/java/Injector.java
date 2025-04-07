import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public <T> T inject(T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String interfaceName = field.getType().getName();
                String implClassName = properties.getProperty(interfaceName);
                try {
                    Class<?> implClass = Class.forName(implClassName);
                    Object implInstance = implClass.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(obj, implInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}
