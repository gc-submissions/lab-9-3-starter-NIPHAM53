package co.grandcircus.trackerapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;
import co.grandcircus.trackerapi.model.TrackingList;

@Service
public class TrackerServiceA implements TrackerService{

	private List<CountPair> counts;

	public List<CountPair> getCounts() {
		return counts;
	}

	public void setCounts(List<CountPair> counts) {
		this.counts = counts;
	}

	public TrackerServiceA() {
		counts = new ArrayList<CountPair>();
	}

	@Override
	public void add(String token) {

		for (CountPair count : counts) {
			if (count.getToken().equals(token)) {
				count.setCount(count.getCount() + 1);
				return;
			}
		}
		CountPair newCount = new CountPair(token, 1);
		counts.add(newCount);
		
	}

	@Override
	public void reset() {
		/**
		 * Clear out all records. Reset back to no tokens.
		 */
		counts = new ArrayList<CountPair>();
		
	}

	@Override
	public int getTotalCount() {

		int total = 0;
		for (CountPair count : counts) {
			total += count.getCount();
		}
		return total;
		
	}

	@Override
	public boolean getTokenExists(String token) {
		for (CountPair count : counts) {
			if(count.getToken().equals(token)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		for (CountPair count : counts) {
			if (count.getToken().equals(token)) {
				return count.getCount();
			}
		}
		return -1;
	}

	@Override
	public String getLatest() {
		/**
		 * Return the most recent token tracked
		 */
		
		String latest = "";
		if(counts.size()==0) {
			return latest;
		}
		for (int i = counts.size() - 1 ; i < counts.size() ; i++) {
			 latest = counts.get(counts.size() - 1).getToken();
		}
			

		return latest;
	}

	@Override
	public CountPair getTop() {
		/**
		 * Return the token that has been tracked the most times AND how many times
		 * it has been tracked. If there are no tokens return a CountPair("", 0).
		 * 
		 * @return a CountPair including the token and count
		 */
		CountPair highestCount = new CountPair("",0);
		for (CountPair count : counts) {
		if (count.getCount() > highestCount.getCount()) {
			highestCount = count;
		}
		}
		return highestCount;
		
	}

	@Override
	public List<String> getLatest5() {
		/**
		 * Return five the most recent token tracked in order with the most recent
		 * first. The list may contain duplicates if the same token was registered
		 * multiple times. If there are less than five total hits, return all the
		 * available tokens.
		 */
		List<String> latest = new ArrayList<>();
		
		if(counts.size()==0) {
			return latest;
		}
		if(counts.size() <5) {
			for (CountPair count: counts) {
				latest.add(count.getToken());
			}
			return latest;
		}
		for (int i = counts.size() - 5 ; i < counts.size() ; i++) {
			 latest.add(counts.get(i).getToken());
			 
		}
			

		return latest;
	}

	@Override
	public List<CountPair> getTop5() {
		/**
		 * Return the five tokens that have been tracked the most times AND how many
		 * times they have been tracked. If there are less than five unique tokens,
		 * return CountPairs the available tokens.
		 * 
		 * @return a List of CountPair ordered with the highest count first.
		 */
		
		
		
		List<CountPair> topFive = new ArrayList<>();
		if (counts.size()==0) {
			return topFive;
		}
		if (counts.size() > 4) {
			
			
		}
		return topFive;
	}

}
