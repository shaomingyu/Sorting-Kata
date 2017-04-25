package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}
	
	private void heapify() {
		for (int i = list.size() / 2 - 1; i >= 0; i--) {	
			bubbleDown(i, list.size() - 1);
		}
	} 
	
	protected void bubbleDown(int index, int end) {
		int i = index; 
		while((2*i + 2 <= end && list.compare(i,2*i + 2, comparator) < 0) 
				|| (2*i + 1 <= end && list.compare(i, 2*i + 1, comparator) < 0)){
			if(2*i + 2 > end || (2*i + 2 <= end && list.compare(2*i + 1, 2*i + 2, comparator) > 0)) {
				list.swap(i, 2*i + 1); 
				i = 2*i + 1;
			}
			else {
				list.swap(i, 2*i + 2);
				i = 2*i + 2;
			}
		}
	}
	@Override
	public SwapList<T> sort() {
        heapify();
        for(int i = list.size() - 1; i >= 1; i--) {
        	list.swap(0, i);
        	bubbleDown(0, i-1);
        }
        return list;
	}

}
