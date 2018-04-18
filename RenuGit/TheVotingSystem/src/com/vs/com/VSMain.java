package com.vs.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class VSMain {

	public static String motion;
	HashSet<String> mtn = new HashSet<>();

	public void motion() {
		mtn.add("Child Labor");
		mtn.add("Foreign Visa");
		mtn.add("Unemployment");
		mtn.add("Economy");
		mtn.add("Wild Life");

		Iterator<String> iter = mtn.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<String> startedMotions = new ArrayList<>();
		Map<String, VotingImplementation> voting = new HashMap<>();
		VSMain vs = new VSMain();
		System.out.println("The available motions are ");
		vs.motion();
		int choice = 0;

		while (choice != 4) {
			System.out.println("1. Please enter the motion you'd like to start ");
			System.out.println("2. Please enter the motion you'd like to vote for");
			System.out.println("3. Please enter the vp vote");
			System.out.println("4. Terminate");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Please enter the motion you'd like to start");
				motion = sc.next();
				startedMotions.add(motion);
				long startTime = System.currentTimeMillis();
				VotingImplementation imp = new VotingImplementation(motion, startTime);
				Thread t1 = new Thread(imp);
				voting.put(motion, imp);
				t1.start();
				break;
			}
			case 2: {
				System.out.println("The motions that are currently running ");
				System.out.println(startedMotions);
				System.out.println("Please enter the motion you'd like to vote for");
				motion = sc.next();

				VotingImplementation vImp = voting.get(motion);

				System.out.println("Please enter the voter ID ");
				int id = sc.nextInt();

				System.out.println("Please enter the name ");
				String name = sc.next();

				System.out.println("Please cast your vote ");
				boolean vote = sc.nextBoolean();

				Voter voter = new Voter(id, name, vote);

				vImp.add(voter);

			}
			case 3: {

				if (VotingImplementation.countYes == VotingImplementation.countNo) {
					System.out.println("Its a Tie! The Vice President needs to vote");
					System.out.println("Please enter the credentials ");
					int vpId = sc.nextInt();
					if (vpId == 12345) {
						String vpVote = sc.next();
						if (vpVote.equals("yes")) {
							VotingImplementation.countYes++;
						} else {
							VotingImplementation.countNo++;
						}
					} else {
						System.out.println("Access Denied!");
					}
				}
			}
			case 4: {
				System.out.println("Thanks for voting!");
				break;
			}
			}
		}
		sc.close();
	}
}
