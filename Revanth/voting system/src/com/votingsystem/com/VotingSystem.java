package com.votingsystem.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VotingSystem {

	private static Map<String, MotionVotingTask> motions = new HashMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> startedMotionSet = new HashSet<>();
		int i = 13;
		while (i != 0) {
			System.out.println("Enter '1' to add a new motion");
			System.out.println("Enter '2' to start a motion ");
			System.out.println("Enter '3' to vote for a motion:");
			System.out.println("Enter '4' to know about the current status of the threads");
			System.out.println("Enter '5' to vote as a VP:");
			System.out.println("Enter '0' to teminate the program ");
			i = scan.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter the motion name you would like to add");
				String newMotion = scan.next();
				createNewMotion(newMotion);
				displayMotionSet();
				break;
			case 2:
				System.out.println("Enter the name of the motion you would like to start:");
				String startMotionName = scan.next();
				if (startedMotionSet.contains(startMotionName)) {
					System.out.println("Motion already started");
				} else {
					MotionVotingTask mvt = getMotionTask(startMotionName);
					if (mvt != null) {
						mvt.setStartAndEndTime(System.currentTimeMillis());
						Thread votingThread = new Thread(mvt, startMotionName);
						startedMotionSet.add(startMotionName);
						votingThread.start();
						System.out.println("Motion " + startMotionName + " started....\n");
					} else {
						System.out.println("OOOPS!! Entered motion not found");
					}
				}
				break;

			case 3:
				System.out.println("Enter the motion name you want to vote for:");
				String motionName = scan.next();
				MotionVotingTask mvt = getMotionTask(motionName);
				if (mvt != null && startedMotionSet.contains(motionName)) {
					System.out.println("Enter the name of the Voter");
					String voterName = scan.next();
					System.out.println("Enter the Id of the Voter");
					int voterId = scan.nextInt();
					System.out.println("Cast your vote(Y or N)");
					String vote = scan.next();
					Voter voter = new Voter(voterName, voterId, vote);
					mvt.addVoter(voter);
				} else {
					System.out.println("OOOPS!! Entered motion not found");
				}
				break;
			case 4:
				ThreadGroup group = Thread.currentThread().getThreadGroup();
				Thread[] tarray = new Thread[10];
				int size = group.enumerate(tarray);
				for (int j = 0; j < size; j++) {
					System.out.println("The status of " + tarray[j].getName() + " thread is: "
							+ (tarray[j].isAlive() ? "Alive" : "Dead"));
				}
				break;
			case 5:
				System.out.println("Enter the motion name you want to vote for:");
				String motionNameVp = scan.next();
				System.out.println("Please cast the vote");
				String vpVote = scan.next();
				Voter voter = new Voter("VicePresident", 1111, vpVote, true);
				MotionVotingTask mvtp = getMotionTask(motionNameVp);
				if (mvtp != null && startedMotionSet.contains(motionNameVp)) {
					mvtp.addVoter(voter);
				}
				break;
			default:
				if (i == 0) {
					System.out.println("Program TERMINATED!!");
				} else {
					System.out.println("OOOPS!! Entered the wrong number\n");
				}
			}
		}
		scan.close();
	}

	public static MotionVotingTask getMotionTask(String motionName) {
		return motions.get(motionName);
	}

	public static void createNewMotion(String motionName) {
		MotionVotingTask mv = new MotionVotingTask(motionName);
		motions.put(motionName, mv);
	}

	public static void displayMotionSet() {
		System.out.println("Currently available motions: " + motions.keySet());
	}

}
