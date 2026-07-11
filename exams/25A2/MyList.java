import java.util.ArrayList;
import java.util.Collection;

public class MyList<T> extends ArrayList<T> implements Combinable<MyList<T>> {
    @Override
	public MyList<T> combine(MyList<T> other) {
		MyList<T> combined = new MyList<>();
		for(int i=0; i<size(); i+=2)
			combined.add(get(i));
		for(int i=1; i<other.size(); i+=2)
			combined.add(other.get(i));
		return combined;
	}
    

	T lastRemovedElement = null;
	int lastRemovedIndex = -1;
	@Override
	public T remove(int index) {
		lastRemovedElement = get(index);
		lastRemovedIndex = index;
		return super.remove(index);
	}
	public void undoLastRemove() {
		if(lastRemovedElement!=null)
			add(lastRemovedIndex, lastRemovedElement);
	} 
	

    private boolean reverseOrder = false;
	public void setReverseOrder(boolean reverseOrder) {
		this.reverseOrder = reverseOrder;
	}

	@Override
	public Iterator<T> iterator() {
		if(!reverseOrder)
			return super.iterator();
		else return new Iterator<T>() {
				int cur = size()-1;
				@Override
				public boolean hasNext() {
					return cur>=0;
				}

				@Override
				public T next() {
					return get(cur--);
				}
		};
	}
}