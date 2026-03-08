package lab5.task3;

import java.io.Serializable;

public interface Loader<T> extends Serializable {
    void save(String filePath);

    T load(String filePath);
}
