package passingVariables;

import java.util.ArrayList;
import java.util.List;

public class SortList {
	public List<Integer> sort(List<Integer> list) {
		List<Integer> newList = new ArrayList<>(list);
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 1; i < newList.size(); i++) {
				if(newList.get(i-1) > newList.get(i)) {
					Integer tmp = newList.get(i);
					newList.set(i, newList.get(i-1));
					newList.set(i-1, tmp);
					sorted = false;
				}
			}
		}
		return newList;
	}
}
