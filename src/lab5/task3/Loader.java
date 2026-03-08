package lab5.task3;

import java.io.Serializable;

public interface Loader<T> extends Serializable {
    void save(String filePath);

    void load(String filePath);
}
