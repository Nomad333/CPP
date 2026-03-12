package task1;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) {
        Properties props = new Properties();

        try(InputStream is = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(Objects.requireNonNull(is));
            System.out.println(props.getProperty("props.local.hello"));
            System.out.println(props.getProperty("props.mvn.hello"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
