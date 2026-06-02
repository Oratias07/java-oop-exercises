package tasks;

public class NamedTasks extends Tasks {
    private String[] taskNames;

    public NamedTasks(String[] names) {
        super(names.length);
        this.taskNames = names;
    }
    
    public boolean dependsOn(String task1, String task2) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equals(task1)) {
                index1 = i;
            }
            if (taskNames[i].equals(task2)) {
                index2 = i;
            }
        }
        if (index1 == -1 || index2 == -1) {
            return false;
        }
        return super.dependsOn(index1, index2);
    }

    public String[] nameOrder() {
        int[] order = super.order();
        if (order == null) {
            return null;
        }
        String[] nameOrder = new String[order.length];
        for (int i = 0; i < order.length; i++) {
            nameOrder[i] = taskNames[order[i]];
        }
        return nameOrder;
    }
    
}
