package lolVo;

import java.util.ArrayList;
import java.util.List;

public class LotationVo {
	List<Integer> freeChampions = new ArrayList<Integer>();
	
	public LotationVo(List<Integer> list) {
		this.freeChampions = list;
	}

	public List<Integer> getFreeChampions() {
		return freeChampions;
	}

	public void setFreeChampions(List<Integer> freeChampions) {
		this.freeChampions = freeChampions;
	}
	
	
	
}
