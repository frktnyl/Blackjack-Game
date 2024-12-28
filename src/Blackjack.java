import java.util.Scanner;

public class Blackjack {
    static int playersScore = 0;
    static int dealersScore = 0;

    public static void main(String[] args) {
         while (true){
             System.out.println("\nWelcome to Blackjack!\n");
             Scanner inputs = new Scanner(System.in);
             blackjack(inputs);
             System.out.println("Would you like to play again? ");
             String answer = inputs.nextLine();
             if(!answer.equalsIgnoreCase("Yes")){
                 System.out.println();
                 System.out.println("Game is over.");
                 break;
             }
         }
    }

    public static void blackjack(Scanner inputs) {
        int deck[] = new int[52];
        String rank[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String species[] = {"Spades", "Hearts", "Diamonds", "Clubs"};

        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        shuffleTheDeck(deck);
        int winner = 0;
        int counterDealer = 0;
        int k;
        int cardIndex = 0;
        int aceCounterPlayer = 0;
        int aceCounterDealer = 0;

        if (cardIndex < deck.length) {
            String x = rank[deck[cardIndex] % 13];
            String y = species[deck[cardIndex] / 13];
            System.out.println("Dealer gets: " + x + " of " + y);
            char c = x.charAt(0);
            if (50 <= c && c <= 57) {
                k = c - 48;
            } else if (c == 65) {
                k = 11;
                aceCounterDealer++;
            } else {
                k = 10;
            }
            counterDealer = counterDealer + k;
            cardIndex++;
        }
        System.out.println();

        int counter = 0;
        int j;

        for (int i = 0; i < 2; i++) {
            if (cardIndex < deck.length) {
                String x = rank[deck[cardIndex] % 13];
                String y = species[deck[cardIndex] / 13];
                System.out.println("Player gets: " + x + " of " + y);
                char c = x.charAt(0);
                if (50 <= c && c <= 57) {
                    j = c - 48;
                } else if (c == 65) {
                    j = 11;
                    aceCounterPlayer++;
                } else {
                    j = 10;
                }
                counter = counter + j;
                cardIndex++;
            }
        }
        if (counter == 22) {
            counter = counter - 10;
            aceCounterPlayer--;
        }
        System.out.println();
        System.out.println("Your current hand is: " + counter);

        if (counter == 21) {
            System.out.println();
            System.out.println("Player's hand is: 21! ");
            if (cardIndex < deck.length) {
                String x = rank[deck[cardIndex] % 13];
                String y = species[deck[cardIndex] / 13];
                System.out.println("Dealer gets: " + x + " of " + y);
                char c = x.charAt(0);
                if (50 <= c && c <= 57) {
                    k = c - 48;
                } else if (c == 65) {
                    k = 11;
                    aceCounterDealer++;
                } else {
                    k = 10;
                }
                counterDealer = counterDealer + k;
                cardIndex++;
            }
            if (counterDealer == 21) {
                System.out.println("Dealer's hand is: 21!");
                System.out.println();
                System.out.println("It's a tie.");
                winner = winner + 3;
                score(winner);
            } else {
                System.out.println("Dealer's hand is: " + counterDealer);
                System.out.println();
                System.out.println("You win!");
                winner = winner + 1;
                score(winner);
            }
            return;
        }

            while (counter < 21) {
                Scanner input = new Scanner(System.in);
                System.out.println();
                System.out.println("Hit or Stand?");
                String operation = input.next();

                if (operation.equalsIgnoreCase("Hit")) {
                    if (cardIndex < deck.length) {
                        String x = rank[deck[cardIndex] % 13];
                        String y = species[deck[cardIndex] / 13];
                        System.out.println("Player gets: " + x + " of " + y);
                        char c = x.charAt(0);
                        if (50 <= c && c <= 57) {
                            j = c - 48;
                        } else if (c == 65) {
                            j = 11;
                            aceCounterPlayer++;
                        } else {
                            j = 10;
                        }
                        counter = counter + j;
                        cardIndex++;
                    }
                    if (counter == 21) {
                        System.out.println();
                        System.out.println("Player's hand is: 21! ");
                        if (cardIndex < deck.length) {
                            String x = rank[deck[cardIndex] % 13];
                            String y = species[deck[cardIndex] / 13];
                            System.out.println("Dealer gets: " + x + " of " + y);
                            char c = x.charAt(0);
                            if (50 <= c && c <= 57) {
                                k = c - 48;
                            } else if (c == 65) {
                                k = 11;
                                aceCounterDealer++;
                            } else {
                                k = 10;
                            }
                            counterDealer = counterDealer + k;
                            cardIndex++;
                        }
                        if (counterDealer == 21) {
                            System.out.println("Dealer's hand is: 21!");
                            System.out.println();
                            System.out.println("It's a tie.");
                            winner = winner + 3;
                            score(winner);
                        } else {
                            System.out.println("Dealer's hand is: " + counterDealer);
                            System.out.println();
                            System.out.println("You win!");
                            winner = winner + 1;
                            score(winner);
                        }
                        return;
                    } else if (counter > 21) {
                        if (aceCounterPlayer != 0) {
                            counter = counter - 10;
                            aceCounterPlayer--;
                        } else {
                            System.out.println();
                            System.out.println("Player hits " + counter + ". Dealer wins!");
                            winner = winner + 2;
                            score(winner);
                            return;
                        }
                    }
                    System.out.println("Your current hand is: " + counter);
                } else if (operation.equalsIgnoreCase("Stand")) {
                    break;
                }
            }
            System.out.println();
            System.out.println("Dealer's turn...");
            System.out.println();

            while (counterDealer < 17) {
                if (cardIndex < deck.length) {
                    String x = rank[deck[cardIndex] % 13];
                    String y = species[deck[cardIndex] / 13];
                    System.out.println("Dealer gets: " + x + " of " + y);
                    char c = x.charAt(0);
                    if (50 <= c && c <= 57) {
                        k = c - 48;
                    } else if (c == 65) {
                        k = 11;
                        aceCounterDealer++;
                    } else {
                        k = 10;
                    }
                    counterDealer += k;
                    cardIndex++;
                }
            }
            if (counterDealer > 21) {
                if (aceCounterDealer != 0) {
                    counterDealer = counterDealer - 10;
                    aceCounterDealer--;
                    while (counterDealer < 17) {
                        if (cardIndex < deck.length) {
                            String x = rank[deck[cardIndex] % 13];
                            String y = species[deck[cardIndex] / 13];
                            System.out.println("Dealer gets: " + x + " of " + y);
                            char c = x.charAt(0);
                            if (50 <= c && c <= 57) {
                                k = c - 48;
                            } else if (c == 65) {
                                k = 11;
                                aceCounterDealer++;
                            } else {
                                k = 10;
                            }
                            counterDealer += k;
                            cardIndex++;
                        }
                    }
                } else {
                    System.out.println();
                    System.out.println("Dealer hits " + counterDealer + ". Player wins!");
                    winner = winner + 1;
                    score(winner);
                    return;
                }
            } else if (counterDealer == 21) {
                System.out.println();
                System.out.println("Dealer hits 21! Dealer wins!");
                winner = winner + 2;
                score(winner);
                return;
            }

            System.out.println();
            System.out.println("Dealer's final hand value: " + counterDealer);
            System.out.println("Player's final hand value: " + counter);
            System.out.println();

            if (counter > 21) {
                System.out.println("Player busted! Dealer wins!");
                winner = winner + 2;
                score(winner);
            } else if (counterDealer > 21) {
                System.out.println("Dealer busted! Player wins!");
                winner = winner + 1;
                score(winner);
            } else if (counter > counterDealer) {
                System.out.println("Player wins!");
                winner = winner + 1;
                score(winner);
            } else if (counterDealer > counter) {
                System.out.println("Dealer wins!");
                winner = winner + 2;
                score(winner);
            } else {
                System.out.println("It's a tie!");
                winner = winner + 3;
                score(winner);
            }
        }

        public static void score(int winner) {

            if (winner == 1){
                playersScore++;
            } else if (winner == 2){
                dealersScore++;
            } else if (winner == 3){
                playersScore++;
                dealersScore++;
            }
            System.out.println("\nScore is: \nPlayer = " + playersScore + "\nDealer = " + dealersScore + "\n");
        }

        public static boolean shuffleTheDeck (int[] deck){
            for (int i = 0; i < deck.length; i++) {
                int index = (int) (Math.random() * deck.length);
                int temp = deck[i];
                deck[i] = deck[index];
                deck[index] = temp;
            }
            return true;
        }
}