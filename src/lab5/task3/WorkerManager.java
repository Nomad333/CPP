package lab5.task3;

import lab4.task2.workers.Worker;

public interface WorkerManager {
    void addWorker(Worker worker);

    void editWorker(Worker oldWorker, Worker newWorker);

    void deleteWorker(Worker worker);
}
