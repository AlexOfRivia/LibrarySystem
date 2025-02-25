import java.util.ArrayList; //Vectors
import java.util.Scanner; //gettng input

public class LibrarySystemMain{
    public static void main(String[] args){
        int choice=0;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>(); //book vector
        ArrayList<Client> clients = new ArrayList<Client>(); //client vector

        while(choice!=5)
        {
            System.out.println("\n  Library System");
            System.out.println("1. Show Books");
            System.out.println("2. Show Clients");
            System.out.println("3. Search Options");
            System.out.println("4. Edit Options");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt(); //Reading the next input int
            //TODO: create the switch loop
        }
    }
}