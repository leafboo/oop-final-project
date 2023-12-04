import java.util.Scanner;

public class MainProgram {
    static Scanner sc = new Scanner(System.in);
    static String transaction;
    static char retry;

   public static void main(String a[]) {
        // data
        Admin[] adminDatabase = new Admin[3];
        adminDatabase[0] = new Admin("1601", "John", "0953");
        adminDatabase[1] = new Admin("16012", "Han", "093");
        adminDatabase[2] = new Admin("160", "Dan", "292");


        Student[] studentDatabase = new Student[3];
        studentDatabase[0] = new Student("101", "Dal", "09523");
        studentDatabase[1] = new Student("160", "Von", "0393");
        studentDatabase[2] = new Student("16032", "Daisy", "2952");

        Book[] bookDatabase = new Book[3];
        
        Media[] mediaDatabase = new Media[3];

        // prompt user to pick
        System.out.print("Choose a user: (a)admin (s)student");
        char user = sc.next().charAt(0);
        if (user == 'a' || user == 'A') {
            adminWindow();

        } else if (user == 's' || user == 'S'){
            userWindow();
        } else {
            System.out.println("Invalid, try again.");
        }
        // ask user if they want to change user. If yes then repeat.
    } 



    public static void adminWindow() {
        while (retry == 'y' || retry == 'Y') {
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("          Welcome admin         ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(d)delete book    (au)add user  ");
            System.out.println("(s)search book    (sm)search media item");
            System.out.println("         (su)search user        ");
            System.out.println("--------------------------------");
            System.out.print("Enter your transaction: ");
            transaction = sc.next();
            pickTransaction(transaction);
            System.out.print("Do you want to pick another transaction? y/n");
            retry = sc.next().charAt(0);
        }
       

    }

    public static void userWindow() {
        while (retry == 'y' || retry == 'Y') {
             System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("         Welcome student        ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(s)search book    (sm)search media item");
            System.out.println("         (l)loan a book         ");
            System.out.println("Enter your transaction: ");
            transaction = sc.next();
            pickTransaction(transaction);
            System.out.print("Do you want to pick another transaction? y/n");
            retry = sc.next().charAt(0);
        }

    }


    public static void pickTransaction(String transaction) {
        switch (transaction) {
            case "d":
                deleteBook();
                break;
            case "au":
                addUser();
                break;
            case "s":
                searchBook();
                break;
            case "sm":
                searchMediaItem();
                break;
            case "su":
                searchUser();
                break;
            case "l":
                loanABook();
                break;
        
            default:
                break;
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
