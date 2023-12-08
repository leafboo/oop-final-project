import java.util.Scanner;

public class MainProgram {
    static Scanner sc = new Scanner(System.in);
    static String transaction;
    static char retry;
    static char promptToRetry;

    static int adminCounter = 0;
    static int studentCounter = 0;
    static int bookCounter = 0;
    static int mediaCounter = 0;

    static Admin[] adminDatabase = new Admin[3];
    static Student[] studentDatabase = new Student[3];
    static Book[] bookDatabase = new Book[3];
    static Media[] mediaDatabase = new Media[3];

   public static void main(String a[]) {
        // data
        
        /*
        adminDatabase[0] = new Admin("1601", "John", "0953");

        studentDatabase[0] = new Student("101", "Dal", "09523")
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
                    // search the name of the admin
                    adminWindow();
                } else if (user.equals("student")) {
                    // search the name of the student
                    studentWindow();
                } 
            }
            System.out.println("(y) go back (n) exit program  ");
            promptToRetry = sc.next().toLowerCase().charAt(0);
        } while (promptToRetry == 'y');
        
    } 














    public static void adminWindow() {
        do {

            // note: if the user picks add user and the adminDatabase is not 0, 
            String user = "admin";
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("          Welcome admin         ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(db)delete book    (du)delete user  ");
            System.out.println("(sb)search book   (sm)search media item");
            System.out.println("(su)search user   (au)add user  ");
            System.out.println("(am)add media     (ab)add book  ");
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
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("         Welcome student        ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            System.out.println("(sb)search book    (sm)search media item");
            System.out.println("         (lb)loan a book         ");
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

                if (transaction.equals("db")) {
                    deleteBook();
                } else if (transaction.equals("au")) {
                    addUser(user);
                } else if (transaction.equals("ab")) {
                    addBook();
                } else if (transaction.equals("am")) {
                    addMedia();
                } else if (transaction.equals("su")) {
                    searchUser();
                }

            } else { // student's access
                if (transaction.equals("lb")) {
                    loanABook();
                }
            }
            // both admin and user has access
            if (transaction.equals("sb")) {
                searchBook();
            } else if (transaction.equals("sm")) {
                searchMediaItem();
            }
        }
    }

    
    // admin abilities
    public static void addUser(String user) {
        System.out.print("Enter the user id: ");
        String userId = sc.next();
        System.out.print("Enter the username: ");
        String name = sc.next();
        System.out.print("Enter the contact number: ");
        String contactNumber = sc.next();
        if (user.equals("admin") && adminCounter < 3) {
            adminDatabase[adminCounter] = new Admin(userId, name, contactNumber); // iterate throught the array
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("          Added an admin user          ");
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("user id: " + adminDatabase[adminCounter].userId );
            System.out.println("name: " + adminDatabase[adminCounter].name);
            System.out.println("contact number: " + adminDatabase[adminCounter].contactNumber);
            System.out.println("current admins: " + (adminCounter + 1) + " / 3");
             System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println();
            adminCounter++;
            
            
        } else if (user.equals(user) && studentCounter < 3) {
            studentDatabase[studentCounter] = new Student(userId, name, contactNumber);
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("          Added a student user        ");
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("user id: " + studentDatabase[studentCounter].userId );
            System.out.println("name: " + studentDatabase[studentCounter].name);
            System.out.println("contact number: " + studentDatabase[studentCounter].contactNumber);
            System.out.println("current users: " + (studentCounter + 1) + " / 3");
             System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println();
            studentCounter++;
        }
    }
    public static void addBook() {
        System.out.print("Enter the book title: ");
        String title = sc.next();
        System.out.println("Enter the book author: ");
        String author = sc.next();
        System.out.print("Enter the ISBN: ");
        String ISBN = sc.next();
        System.out.println("Is the book available? (true)yes (false)no ");
        boolean availabilityStatus = sc.nextBoolean();

        bookDatabase[bookCounter] = new Book(title, author, ISBN, availabilityStatus);
        bookCounter++;
    }
    public static void addMedia() {
        System.out.println("Input the media title: ");
        String mediaTitle = sc.next();
        System.out.println("Inpput the serial number: ");
        String serialNumber = sc.next();

        mediaDatabase[mediaCounter] = new Media(mediaTitle, serialNumber);
        mediaCounter++;
    }

    public static void deleteBook() {
        
    }

    public static String searchUser() {
        System.out.print("Input the book title you want to find: ");
        String title = sc.next();
        for (int i = 0; i < bookCounter; i++) {
            if (bookDatabase[i].equals(title)) {
                return bookDatabase[i].title;
            }    
        }
        return "User not found.";
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

