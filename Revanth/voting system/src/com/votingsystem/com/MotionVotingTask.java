package com.votingsystem.com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MotionVotingTask implements Runnable {

	private long motionStartTime;
	private long motionEndTime;
	private String motionName;
	private LinkedList<Voter> votesInQueue = new LinkedList<Voter>();
	private Map<Integer, Voter> markedVoters = new HashMap<>();

	public MotionVotingTask(String motionName) {
		super();
		this.motionName = motionName;
	}

	public void setStartAndEndTime(long startTime) {
		this.motionStartTime = startTime;
		this.motionEndTime = motionStartTime + 100000;
	}

	public void addVoter(Voter vote) {
		synchronized (votesInQueue) {
			votesInQueue.add(vote);
		}
	}

	public void run() {
		int yeas = 0;
		int nays = 0;
		int invalidVote = 0;
		long currTimeInMillis = System.currentTimeMillis();

		if (currTimeInMillis < motionStartTime) {
			System.out.println("Motion going to sleep for " + (motionStartTime - currTimeInMillis));
			try {
				Thread.sleep(motionStartTime - currTimeInMillis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while (System.currentTimeMillis() <= motionEndTime) {
			Voter voter;
			synchronized (votesInQueue) {
				voter = votesInQueue.poll();
			}
			if (voter == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (voter != null) {
				if (markedVoters.containsKey(voter.getVoterId())) {
					System.out.println(
							"Received duplicate vote from " + voter.getVoterName() + " for motion " + motionName);
				} else {
					if (voter.getVote().equalsIgnoreCase("y")) {
						yeas++;
					} else if (voter.getVote().equalsIgnoreCase("n")) {
						nays++;
					} else {
						invalidVote++;
					}
					markedVoters.put(voter.getVoterId(), voter);
				}
			}
		}

		if (yeas > nays) {
			System.out.println("Motion " + motionName + " passed!!");
			System.out.println("Number of votes for: " + yeas + ", & against: " + nays + "& invalid: " + invalidVote);
		} else if (yeas < nays) {
			System.out.println("Motion " + motionName + " failed!!");
			System.out.println("Number of votes for: " + yeas + ", & against: " + nays + "& invalid: " + invalidVote);
		} else {
			System.out.println("Motion " + motionName + " Tied yeas " + yeas + ", nays " + nays
					+ ". Vice president Vote Required(y or n)");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			long eTime = System.currentTimeMillis() + 30000;

			while (System.currentTimeMillis() <= eTime) {
				Voter voter;
				synchronized (votesInQueue) {
					voter = votesInQueue.poll();
				}
				if (voter == null) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (voter != null & voter.isVp()) {

				}
				if (voter.getVote().equalsIgnoreCase("y")) {
					System.out.println("Motion passed by VicePresident");
				} else if (voter.getVote().equalsIgnoreCase("n")) {
					System.out.println("Motion failed by VicePresident");
				} else {
					System.out.println("Invalid vote by VicePresident");
				}
			}
		}
		System.out.println("The time that " + motionName + " voting opened: " + motionStartTime);
		System.out.println("The time that " + motionName + " voting closed: " + motionEndTime);
	}
}
