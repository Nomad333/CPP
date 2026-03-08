package lab5.task3;

import lab4.task2.workers.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Corporation implements Loader<List<Worker>>, WorkerManager {
    private List<Worker> workers = new ArrayList<>();

    List<Worker> searchWorkerBy(Predicate<Worker> workerPredicate) {

    }

    void printWorkersBy(Predicate<Worker> workerPredicate) {

    }

    @Override
    public void save(String filePath) {

    }

    @Override
    public List<Worker> load(String filePath) {
        return null;
    }

    @Override
    public void addWorker(Worker worker) {

    }

    @Override
    public void editWorker(Worker oldWorker, Worker newWorker) {

    }

    @Override
    public void deleteWorker(Worker worker) {

    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
