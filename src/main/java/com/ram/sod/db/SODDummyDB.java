package com.ram.sod.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ram.sod.SODConstant.StatusCode;
import com.ram.sod.dto.Blockers;
import com.ram.sod.dto.ScrumEntry;
import com.ram.sod.dto.ScrumNotes;
import com.ram.sod.dto.Task;
import com.ram.sod.dto.TaskEntry;

public class SODDummyDB {
	
	public static ScrumNotes getTodaysNotes(){
		ScrumNotes notes = new ScrumNotes();
		notes.setDate("01/12/2014");
		List<Blockers> blockers = new ArrayList<Blockers>();
		blockers.add(new Blockers("some blocker", "ruhul", "monor","01/12/2014"));
		blockers.add(new Blockers("some more blocker", "sam", "monor","01/12/2014"));
		blockers.add(new Blockers(" more blocker", "kam", "mazor","01/12/2014"));
		notes.setBlockers(blockers);
		
		Map<String, ScrumEntry> entries = new HashMap<String,  ScrumEntry>();
		
		Set<TaskEntry> today = new HashSet<TaskEntry>();
		Task task = new Task("STD-1", "Story Name", "SSP");
		Task task1 = new Task("STD-2", "Story 2 Name", "SSP");
		

		today.add(new TaskEntry("spend some time here", 4, 10, task, "ruhul"));
		today.add(new TaskEntry("spend some time here", 4, 10, task1, "ruhul"));
		
		Set<TaskEntry> yestarday = new HashSet<TaskEntry>();
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task, "ruhul"));
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task1, "ruhul"));
		ScrumEntry entry = new ScrumEntry(today, yestarday, "ruhul", "01/12/2014");
		entries.put("ruhul", entry);
		
		Task task2 = new Task("STD-1", "Story Name", "SSP");
		Task task3 = new Task("STD-2", "Story 2 Name", "SSP");
		
		today = new HashSet<TaskEntry>();
		today.add(new TaskEntry("spend some time here", 4, 10, task2, "sam"));
		today.add(new TaskEntry("spend some time here", 4, 10, task3, "sam"));
		yestarday = new HashSet<TaskEntry>();
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task2, "sam"));
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task3, "sam"));
		ScrumEntry entry1 = new ScrumEntry(today, yestarday, "sam", "01/12/2014");
		entries.put("sam",entry1);
		
		notes.setOthers(entries);
		
		
		today = new HashSet<TaskEntry>();
		today.add(new TaskEntry("spend some time here", 4, 10, task1, "test"));
		today.add(new TaskEntry("spend some time here", 4, 10, task2, "test"));
		yestarday = new HashSet<TaskEntry>();
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task, "test"));
		yestarday.add(new TaskEntry("spend some time here", 4, 10, task3, "test"));
		ScrumEntry entry2 = new ScrumEntry(null, null, "test", "01/12/2014");
		notes.setSelf(entry2);
		notes.setStatus(StatusCode.autherror);
		return notes;
		
		
	}

}
