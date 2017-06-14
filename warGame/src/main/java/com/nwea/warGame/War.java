package com.nwea.warGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents actual War game & starting point of application. Since there is
 * going to be only one War game at a time, so creating instance objects, this
 * is not yet designed to be multi-threaded.
 */
public class War {

	private Deck deck;
	private Player[] players;

	public War() {
	}

	public void initAndStartGame(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {

		deck = createDeck(numberOfSuits, numberOfRanks);
		// Create Players
		players = createPlayers(numberOfPlayers);

		deck.shuffle();
		// Distribute cards to all players
		distributeCards();

		// Play rounds
		play(players);

		// Display winner
		congratsWinner();
	}

	private void congratsWinner() {
		for (Player player : players) {
			if (player.hasCards()) {
				System.out.print("Player " + player.getPlayerName() + " has won.");
			}
		}
	}

	private Deck createDeck(int numberOfSuits, int numberOfRanks) {
		Deck deck = new SimpleDeck("SimpleDeck", new RandomShuffler());
		deck.create(numberOfSuits, numberOfRanks);
		return deck;
	}

	public Player[] createPlayers(int numberOfPlayers) {
		Player[] players = new Player[numberOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Player-" + (i + 1));
		}

		return players;
	}

	public void distributeCards() {
		Card card = deck.deal();

		int playerIdxToUse = 0;
		while (card != null) {
			Player player = players[playerIdxToUse];
			player.assignCard(card);
			if (playerIdxToUse >= players.length - 1) {
				playerIdxToUse = 0;
			} else {
				playerIdxToUse++;
			}
			card = deck.deal();
		}
	}

	// Method handling main logic of comparing and adjusting cards between
	// players.
	private void play(Player[] players) {

		List<Player> playersWithCards = getPlayersWithCards(players);
		int roundsPlayed = 0;
		while (playersWithCards.size() > 1) {

			System.out.println(
					"Starting to play round " + roundsPlayed + " between [" + logPlayerInfo(playersWithCards) + "].");

			List<PlayerCard> newCardsInPlay = getPlayersTopFaceOpenCard(playersWithCards);
			List<PlayerCard> maxPlayerCards = findMaxPlayerCards(newCardsInPlay);

			if (maxPlayerCards.size() >= 2) {
				// tie
				Player[] playersWithTie = getPlayersWithTie(maxPlayerCards);
				System.out.println(
						"Round " + roundsPlayed + " went into a tie newCardsInPlay [" + logInfo(newCardsInPlay) + "].");
				playTie(newCardsInPlay, playersWithTie);
			} else {
				Player playerWithMaxCard = maxPlayerCards.get(0).getPlayer();
				System.out.println("Round " + roundsPlayed + " won by " + playerWithMaxCard.getPlayerName() + " using ["
						+ logInfo(newCardsInPlay) + "].");

				record(newCardsInPlay, playerWithMaxCard);
			}
			roundsPlayed++;
			playersWithCards = getPlayersWithCards(players);
		}

		System.out.println("***Total number of rounds played " + roundsPlayed);
	}

	private String logPlayerInfo(List<Player> players) {
		StringBuilder sb = new StringBuilder();
		for (Player player : players) {
			sb.append("[").append(player.getPlayerName()).append(",").append(player.getCardsSize()).append(']')
					.append(",");
		}
		return sb.toString();
	}

	private String logInfo(List<PlayerCard> newCardsInPlay) {
		StringBuilder sb = new StringBuilder();
		for (PlayerCard pCard : newCardsInPlay) {
			sb.append(pCard.toString()).append(",");
		}
		return sb.toString();
	}

	private void playTie(List<PlayerCard> cardsInPlay, Player[] playersWithTie) {
		List<PlayerCard> faceDownCards = new ArrayList<>();
		List<PlayerCard> faceOpenCards = new ArrayList<>();

		for (Player player : playersWithTie) {
			PlayerCard faceDownCard = player.getNextCard();
			PlayerCard faceOpenCard = player.getNextCard();
			if (faceDownCard != null) {
				faceDownCards.add(faceDownCard);
			}
			if (faceOpenCard != null) {
				faceOpenCards.add(faceOpenCard);
			}
		}

		cardsInPlay.addAll(faceDownCards);
		cardsInPlay.addAll(faceOpenCards);

		List<PlayerCard> maxPlayerCards = findMaxPlayerCards(faceOpenCards);

		if (maxPlayerCards.size() >= 2) {
			System.out.println("Child-round went into a tie faceOpenCards [" + logInfo(faceOpenCards)
					+ "], faceDownCards [" + logInfo(faceDownCards) + "].");
			// tie
			playTie(cardsInPlay, getPlayersWithTie(maxPlayerCards));
		} else {
			Player playerWithMaxCard = maxPlayerCards.get(0).getPlayer();
			System.out.println("Tied round won by " + playerWithMaxCard.getPlayerName() + " using ["
					+ logInfo(faceOpenCards) + "].");
			record(cardsInPlay, playerWithMaxCard);
		}
	}

	private void record(List<PlayerCard> cardsInPlay, Player playerWithMaxCard) {
		for (PlayerCard cardInPlay : cardsInPlay) {
			playerWithMaxCard.assignCard(cardInPlay.getCard());
		}
	}

	private Player[] getPlayersWithTie(List<PlayerCard> maxPlayerCards) {
		// if its a tie between two or more players play between them
		// first.
		int i = 0;
		Player[] playersWithTie = new Player[maxPlayerCards.size()];
		for (PlayerCard playerWithMaxCard : maxPlayerCards) {
			playersWithTie[i] = playerWithMaxCard.getPlayer();
			i++;
		}
		return playersWithTie;
	}

	private List<Player> getPlayersWithCards(Player[] players) {
		List<Player> playersWithCards = new ArrayList<>();
		for (Player player : players) {
			if (player.hasCards()) {
				playersWithCards.add(player);
			}
		}
		return playersWithCards;
	}

	private List<PlayerCard> getPlayersTopFaceOpenCard(List<Player> playersWithCards) {
		List<PlayerCard> cardsInPlay = new ArrayList<>();
		for (Player player : players) {
			PlayerCard playerCard = player.getNextCard();
			if (playerCard != null) {
				cardsInPlay.add(playerCard);
			}
		}
		return cardsInPlay;
	}

	private List<PlayerCard> findMaxPlayerCards(List<PlayerCard> playerCards) {
		PlayerCard maxCardInPlay = null;
		List<PlayerCard> maxPlayerCards = null;

		for (PlayerCard playerCard : playerCards) {
			if (maxCardInPlay == null) {
				maxCardInPlay = playerCard;
			} else if (playerCard.getRank().compareTo(maxCardInPlay.getRank()) > 0) {
				maxCardInPlay = playerCard;
			} else if (playerCard.getRank().compareTo(maxCardInPlay.getRank()) == 0) {
				if (maxPlayerCards == null) {
					maxPlayerCards = new LinkedList<>();
					maxPlayerCards.add(maxCardInPlay);
				}
				maxPlayerCards.add(playerCard);
			}
		}

		if (maxPlayerCards == null) {
			maxPlayerCards = new LinkedList<>();
			maxPlayerCards.add(maxCardInPlay);
		}

		return maxPlayerCards;
	}

	public Deck getDeck() {
		return deck;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int suits = 0, ranks = 0, players = 0;
		try {
			System.out.print("Enter number of Suits : ");
			suits = scanner.nextInt();
			System.out.print("Enter number of Ranks : ");
			ranks = scanner.nextInt();
			System.out.print("Enter number of players, two or more : ");
			players = scanner.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("Please enter numeric value and try again.");
			System.exit(0);
		} finally {
			scanner.close();
		}

		new War().initAndStartGame(suits, ranks, players);
	}
}
