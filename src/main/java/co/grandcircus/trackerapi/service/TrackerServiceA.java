package co.grandcircus.trackerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.trackerapi.model.CountPair;
import co.grandcircus.trackerapi.model.TrackingList;

@Service
public class TrackerServiceA implements TrackerService{
	TrackingList trackingList = new TrackingList();

	@Override
	public void add(String token) {
		CountPair countPair = new CountPair(token, 0);
		trackingList.addToList(countPair);
		
	}

	@Override
	public void reset() {
		/**
		 * Clear out all records. Reset back to no tokens.
		 */
	trackingList.deleteAll();
		
		
	}

	@Override
	public int getTotalCount() {
		List<CountPair >countList = trackingList.getCountPairList();
		int counter = 0;
		for (CountPair cp : countList) {
			counter++;
		}

		return counter;
		
	}

	@Override
	public boolean getTokenExists(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTokenCount(String token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountPair getTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLatest5() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountPair> getTop5() {
		// TODO Auto-generated method stub
		return null;
	}

}
