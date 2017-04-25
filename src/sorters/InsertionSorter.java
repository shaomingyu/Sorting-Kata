package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		for(int i = 1; i < list.size(); i++) {
			int j = i;
			int k = j - 1;
			sortHelper(j, k);
		}
		return list;
	}
	
	public void sortHelper(int j, int k) {
		while(k >= 0 && list.compare(j, k, comparator) <= 0) {
			k--;
		}
		for(int i = j; i > k + 1; i--) {
			list.swap(i, i - 1);
		}
	}

}

