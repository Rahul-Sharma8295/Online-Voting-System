import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Voting {
    private static Map<String, Integer> candidateVotes = new HashMap<>();
    private static Map<String, String> voters = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Online Voting System");
            System.out.println("1. Cast Vote");
            System.out.println("2. Display Results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    castVote(scanner);
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void castVote(Scanner scanner) {
        System.out.println("List of Candidates:");
        System.out.println("1. Candidate A");
        System.out.println("2. Candidate B");
        System.out.println("3. Candidate C");
        System.out.print("Enter your choice (1-3): ");

        int candidateChoice = scanner.nextInt();

        if (candidateChoice < 1 || candidateChoice > 3) {
            System.out.println("Invalid candidate choice. Please try again.");
            return;
        }

        System.out.print("Enter your voter ID: ");
        String voterId = scanner.next();

        if (voters.containsKey(voterId)) {
            System.out.println("You have already voted. Cannot vote again.");
        } else {
            String candidateName = getCandidateName(candidateChoice);
            candidateVotes.put(candidateName, candidateVotes.getOrDefault(candidateName, 0) + 1);
            voters.put(voterId, candidateName);
            System.out.println("Vote cast successfully!");
        }
    }

    private static void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    private static String getCandidateName(int choice) {
        switch (choice) {
            case 1:
                return "Candidate A";
            case 2:
                return "Candidate B";
            case 3:
                return "Candidate C";
            default:
                return null;
        }
    }
}
