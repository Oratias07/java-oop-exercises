import java.util.ArrayList;
import java.util.List;

public class ObjectsUser implements Runnable {
    private ObjectManager manager;
    private List<Integer> nums;

    public ObjectsUser(ObjectManager m, List<Integer> nums) { 
        this.manager = m; 
        this.nums = nums; 
    }

    public void run() { 
        List<Object> objects = new ArrayList<>(); 
        for (Integer num : nums){
            objects.add(m.getObject(num));  
        }
        for (int i = 0; i < objects.size(); i++) { 
            System.out.print(objects.get(i)); 
        }
        try{
            sleep(5000); 
        } catch(InterruptedException e) { }
        for (Integer num : nums)
            m.releaseObject(num);
    } 
}
