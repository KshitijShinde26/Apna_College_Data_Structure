public class IndianCoins {
    public static void main(String[] args) {
        int[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int amount = 121; // Example amount

        System.out.println("Amount: " + amount);
        System.out.println("Denominations used:");

        for (int denomination : denominations) {
            if (amount >= denomination) {
                int count = amount / denomination;
                amount = amount % denomination;
                System.out.println(denomination + " x " + count);
            }
        }
    }
}
