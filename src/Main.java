import java.util.Scanner;

public class Main {
    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        insertTestNames();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();
            if (option == 1) {
                addGuest();
            }
            else if (option == 2) {
                removeGuest();
            }
            else if (option == 3) {
                renameGuest();
            }
            else if (option == 4) {
                insertGuest();
            }
            else if (option == 5) {
                System.out.println("Exiting...");
                break;
            }
        } while (true);

    }

    public static void displayGuests() {
        System.out.println("_____________");
        System.out.println("- GUESTS -");
        boolean isEmpty = true; // flag variable
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Guest list is empty.");
        }
    }

    public static void displayMenu() {
        System.out.println("_____________");
        System.out.println("- MENU -");
        System.out.println();
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Rename Guest");
        System.out.println("4 - Insert Guest");
        System.out.println("5 - Exit");
    }

    public static int getOption() {
        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();     // consumes the \n input by the user upon pressing Enter key
        System.out.println();
        return option;
    }

    public static void addGuest() {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine();
                break;
            }
        }
    }

    public static void removeGuest() {
        System.out.print("Guest number: ");
        int guestNumber = scanner.nextInt();
        scanner.nextLine();
        if (guestNumber < 1 || guestNumber > guests.length || guests[guestNumber - 1] == null) {
            System.out.println("\nError: there is no guest with that number.");
        }
        else {
            guests[guestNumber - 1] = null;

            String[] temp = new String[guests.length];
            int ti = 0;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;
                }
            }
            guests = temp;
        }
    }

    public static void renameGuest() {
        removeGuest();
        addGuest();
    }

    public static void insertGuest() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Number: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = guests.length - 1; i > num - 1; i--) {
            guests[i] = guests[i-1];
        }

        guests[num - 1] = name;
    }

    public static void insertTestNames() {
        guests[0] = "Jacob";
        guests[1] = "Edward";
        guests[3] = "Rose";
        guests[5] = "Molly";
        guests[7] = "Christopher";
    }
}

