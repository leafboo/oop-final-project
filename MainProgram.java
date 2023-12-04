import java.util.Scanner;

public class MainProgram {
    static Scanner sc = new Scanner(System.in);
    static String transaction;
    static char retry;
    static char promptToRetry;
    static int adminCounter = 0;
    static int studentCounter = 0;

    static Admin[] adminDatabase = new Admin[3];
    static Student[] studentDatabase = new Student[3];
    static Book[] bookDatabase = new Book[3];
    static Media[] mediaDatabase = new Media[3];

   public static void main(String a[]) {
        // data
        
        /*
        adminDatabase[0] = new Admin("1601", "John", "0953");

        studentDatabase[0] = new Student("101", "Dal", "09523");
        */
        do {
            // prompt user to pick
            System.out.print("Choose a user: (admin) (student)  ");
            String user = sc.next().toLowerCase();

            if (!user.equals("admin") && !user.equals("student")) {
                System.out.println("Invalid input. Try again.");
                break;
            }

            //if there is no user in admin or student
            if (!thereAreUsers(user)) {
                System.out.println("No users found. Initialize user");
                addUser(user);
            } else {


                if (user.equals("admin")) {
                    adminWindow();
                } else if (user.equals(user)) {
                    studentWindow();
                } 
            }
            System.out.println("(y) go back (n) exit program  ");
            promptToRetry = sc.next().toLowerCase().charAt(0);
        } while (promptToRetry == 'y');
        
    } 














    public static void adminWindow() {
        do {
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
            System.out.print("Do you want to pick another transaction? y/n ");
            System.out.println();
            retry = sc.next().toLowerCase().charAt(0);
        } while (retry == 'y');
       

    }

    public static void studentWindow() {
        do {
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
            System.out.print("Do you want to pick another transaction? y/n ");
            System.out.println();
            retry = sc.next().toLowerCase().charAt(0);
        } while (retry == 'y');

    }

    public static void pickTransaction(String transaction, String user) {
        if (transaction.length() != 0) {
            if (user == "admin") { // admin's access

                if (transaction == "d") {
                    deleteBook();
                } else if (transaction == "au") {
                    addUser(user);
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
    public static void addUser(String user) {
        System.out.print("Enter the user id: ");
        String userId = sc.next();
        System.out.print("Enter the username: ");
        String name = sc.next();
        System.out.print("Enter the contact number: ");
        String contactNumber = sc.next();
        if (user.equals("admin") && adminCounter < 3) {
            adminDatabase[adminCounter] = new Admin(userId, name, contactNumber); // iterate throught the array
            adminCounter++;
            
        } else if (user.equals(user) && studentCounter < 3) {
            adminDatabase[adminCounter] = new Admin(userId, name, contactNumber);
            studentCounter++;
        }
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
    
    public static boolean thereAreUsers(String user) {
        if (user.equals("admin")) {
            for (Admin admin : adminDatabase) { // foreach loop
                if (admin != null) {
                    return true;
                }
            }
        } else if (user.equals("student")) {
            for (Student student : studentDatabase) {
                if (student != null) {
                    return true;
                }
            }
        }
        return false;
    }

}

