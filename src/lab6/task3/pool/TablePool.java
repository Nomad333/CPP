package lab6.task3.pool;

import lab6.task3.Table;

import java.util.ArrayDeque;
import java.util.Deque;

public class TablePool implements ObjectPool<Table> {
    private final int poolSize;
    private final Deque<Table> tables = new ArrayDeque<>();

    public TablePool(int poolSize) {
        this.poolSize = poolSize;

        for (int i = 0; i < poolSize; i++) {
            tables.add(new Table(i));
        }
    }

    // TODO: OPTION<Table>
    @Override
    public Table acquire() {
        return tables.poll();
    }

    @Override
    public void release(Table obj) {
        tables.add(obj);
    }

    @Override
    public int getPullSize() {
        return poolSize;
    }

    @Override
    public int getCurrentPullSize() {
        return tables.size();
    }
}
