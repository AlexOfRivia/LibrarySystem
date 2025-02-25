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
            //Main menu
            System.out.println("\n  Library System");
            System.out.println("1. Show Books");
            System.out.println("2. Show Clients");
            System.out.println("3. Search Options");
            System.out.println("4. Edit Options");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt(); //Reading the next input int
            switch (choice) {
                case 1:
                {
                    //Checking wether the books vector is empty
                    if(books.isEmpty()==true)
                    {
                        System.out.println("There are no books in the system - Try adding some!");
                        break;
                    } else {
                        for(int i=0;i<books.size();i++)
                        {
                            System.out.println(i+1);
                            clients.get(i).printClientInfo(); //print i-th book info
                        }
                    }
                    break;
                }

                case 2:
                {
                    //Checkiing wether the clients vector is empty
                    if(clients.isEmpty()==true)
                    {
                        System.out.println("There are no clients in the system - Try adding some!");
                        break;
                    } else {
                        for(int i=0; i<clients.size(); i++)
                        {
                            System.out.println(i+1);
                            clients.get(i).printClientInfo(); //print i-th client info
                        }
                    }
                    break;
                }    
                case 3:

                break;

                case 4:
                break;

                case 5:
                System.out.println("Thank you for using our library system!");
                break;
                default:
                    break;
            }
        }
    }
}