package co.grandcircus.trackerapi.model;

import java.util.List;

public class TrackingList {
	private List<CountPair> countPairList;
	
	public void addToList(CountPair countPair) {
		countPairList.add(countPair);
	}
	
	public void deleteAll() {
		for (CountPair cP : countPairList) {
			countPairList.remove(cP);
		}
	}
	
	
	public List<CountPair> getCountPairList() {
		return countPairList;
	}

	public void setCountPairList(List<CountPair> countPairList) {
		this.countPairList = countPairList;
	}
}
