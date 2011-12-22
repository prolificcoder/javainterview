package com.code.prolificcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Schedule implements Comparable<Schedule> {
	long startTime;
	long endTime;

	Schedule(long startTime, long endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Schedule another) {
		// TODO Auto-generated method stub
		if (this.startTime < another.startTime)
			return -1;
		else if (this.startTime > another.startTime)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return (startTime + "---" + endTime);
	}

}

public class ConflictClusters {
	public static void main(String[] args) {
		ConflictClusters cc = new ConflictClusters();
		Schedule s1 = new Schedule(5, 10);
		Schedule s2 = new Schedule(11, 12);
		Schedule s3 = new Schedule(5, 13);
		Schedule s4 = new Schedule(3, 4);
		List<Schedule> schedules = new ArrayList<Schedule>();
		schedules.add(s2);
		schedules.add(s1);
		schedules.add(s3);
		schedules.add(s4);
		schedules.add(new Schedule(6, 9));
		schedules.add(new Schedule(2, 5));
		SortedMap<Schedule, List<Schedule>> conflicts = cc
				.findConflicts(schedules);
		System.out.println(conflicts.size());
		System.out.println(conflicts.get(conflicts.firstKey()).size());
		Set<Schedule> keyset = conflicts.keySet();
		for (Schedule st : keyset) {
			List<Schedule> list = conflicts.get(st);
			for (Schedule s : list)
				System.out.println(s);
		}
	}

	protected SortedMap<Schedule,List<Schedule>> findConflicts(List<Schedule> schedules){
		if(schedules.size()<=1) return null;
		Collections.sort(schedules);
		SortedMap<Schedule,List<Schedule>> conflicts=new TreeMap<Schedule, List<Schedule>>();
		for(int i=1;i<schedules.size();i++){
			//If start times are equal
			if(schedules.get(i-1).startTime==schedules.get(i).startTime){
				long endTime;
				int removeIndex;
				if(schedules.get(i-1).endTime>schedules.get(i).endTime){
					endTime=schedules.get(i-1).endTime;
					removeIndex=i;
				}
				else {
					endTime=schedules.get(i).endTime;
					removeIndex=i-1;
				}
				insertIntoConflict(conflicts,schedules.get(i),schedules.get(i-1),schedules.get(i).startTime,endTime);
				schedules.remove(removeIndex);
			}
		}
		for(int i=1;i<schedules.size();i++){
		 if(schedules.get(i).startTime<schedules.get(i-1).endTime){
			 long endTime=schedules.get(i).endTime;
			 if(schedules.get(i-1).endTime>schedules.get(i).endTime)
					endTime=schedules.get(i-1).endTime;
			 if(conflicts.isEmpty())	
				 insertIntoConflict(conflicts,schedules.get(i),schedules.get(i-1),schedules.get(i-1).startTime,endTime);
		}
		}
		
		return conflicts;
	}

	private void insertIntoConflict(
			SortedMap<Schedule, List<Schedule>> conflicts, Schedule schedule,
			Schedule schedule2, long startTime, long endTime) {
		List<Schedule> conflictedSchedules = new ArrayList<Schedule>();
		conflictedSchedules.add(schedule);
		conflictedSchedules.add(schedule2);
		if (conflicts.size() == 0)
			conflicts
					.put(new Schedule(startTime, endTime), conflictedSchedules);
		else {
			conflicts
					.put(new Schedule(startTime, endTime), conflictedSchedules);
		}

	}
}
