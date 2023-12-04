import java.util.Scanner;

public class MainProgram {
    static Scanner sc = new Scanner(System.in);
    static String transaction;
    static char retry;

    static Admin[] adminDatabase = new Admin[3];
    static Student[] studentDatabase = new Student[3];
    static Book[] bookDatabase = new Book[3];
    static Media[] mediaDatabase = new Media[3];

   public static void main(String a[]) {
        // data
        
        adminDatabase[0] = new Admin("1601", "John", "0953");
        adminDatabase[1] = new Admin("16012", "Han", "093");
        adminDatabase[2] = new Admin("160", "Dan", "292");


        
        studentDatabase[0] = new Student("101", "Dal", "09523");
        studentDatabase[1] = new Student("160", "Von", "0393");
        studentDatabase[2] = new Student("16032", "Daisy", "2952");

        
        // prompt user to pick
        System.out.print("Choose a user: (a)admin (s)student");
        char user = sc.next().charAt(0);
        if (user == 'a' || user == 'A') {
            adminWindow();

        } else if (user == 's' || user == 'S'){
            studentWindow();
        } else {
            System.out.println("Invalid, try again.");
        }
        // ask user if they want to change user. If yes then repeat.
    } 



    public static void adminWindow() {
        while (retry == 'y' || retry == 'Y') {
            String user = "admin";
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("          Welcome admin         ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(d)delete book    (au)add user  ");
            System.out.println("(sb)search book    (sm)search media item");
            System.out.println("         (su)search user        ");
            System.out.println("--------------------------------");
            System.out.print("Enter your transaction: ");
            transaction = sc.next();
            pickTransaction(transaction, user);
            System.out.print("Do you want to pick another transaction? y/n");
            retry = sc.next().charAt(0);
        }
       

    }

    public static void studentWindow() {
        while (retry == 'y' || retry == 'Y') {
            String user = "student";
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("         Welcome student        ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(sb)search book    (sm)search media item");
            System.out.println("         (l)loan a book         ");
            System.out.println("Enter your transaction: ");
            transaction = sc.next();
            pickTransaction(transaction, user);
            System.out.print("Do you want to pick another transaction? y/n");
            retry = sc.next().charAt(0);
        }

    }


    public static void pickTransaction(String transaction, String user) {
        if (transaction.length() != 0) {
            if (user == "admin") { // admin's access

                if (transaction == "d") {
                    deleteBook();
                } else if (transaction == "au") {
                    addUser();
                } else if (transaction == "su") {
                    searchUser();
                }

            } else { // student's access

                if (transaction == "l") {
                    loanABook();
                }

            }
            // both admin and user has access
            if (transaction == "sb") {
                searchBook();
            } else if (transaction == "sm") {
                searchMediaItem();
            }
        }
    }

    
    // admin abilities
    public static void deleteBook() {
        
    }
    public static void addUser() {
        
    }
    public static void searchUser() {

    }
    // user abilities
    public static void loanABook() {
        
    }
    // admin and user abilities
    public static void searchBook() {

    }
    public static void searchMediaItem() {

    }

}
