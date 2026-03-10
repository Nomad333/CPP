package lab6.task3.pool;

public interface ObjectPool<T> {
    T acquire();

    void release(T obj);

    int getPullSize();

    int getCurrentPullSize();
}
