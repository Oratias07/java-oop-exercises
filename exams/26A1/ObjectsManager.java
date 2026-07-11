import java.util.ArrayList;
import java.util.Set;

public class ObjectsManager {
    private Object[] objects;
    private Thread[] owners;

    public ObjectsManager(int M) {
        objects = new Object[M];
        for (int i = 0; i < M; i++)
            objects[i] = newObject();
        owners = new Thread[M];
    }

    public synchronized Object getObject(int index) {
        while(owners[index - 1] != null && 
              owners[index - 1] != Thread.currentThread()) {
            try {
                wait();
            } catch(InterruptedException e) { }
        }
        owners[index - 1] = Thread.currentThread();
        return objects[index - 1];
    }

    public synchronized void releaseObject(int index) {
        if (owners[index - 1] != Thread.currentThread()) return;
        owners[index - 1] = null;
        notifyAll();
    }
}
