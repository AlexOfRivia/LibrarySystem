import java.util.ArrayList; //Vectors
import java.util.Scanner; //gettng input
import java.io.FileInputStream; //file input stream
import java.io.FileOutputStream; //file output stream
import java.io.ObjectInputStream; //object input stream
import java.io.ObjectOutputStream; //object output stream
import java.io.IOException; //input output exception

public class LibrarySystemMain{

    //Saving the library details to a file
    public static void saveLibrary(ArrayList<Book> books, ArrayList<Client> clients)
    {
        if(books.isEmpty()==true && clients.isEmpty()==true)
        {
            System.out.println("You currently have no data in the library - Try adding some books or clients first!");
            return;
        } else {

            Scanner saveScanner = new Scanner(System.in);
            System.out.println("Enter the file name you want to save the library to: ");
            String fileName = saveScanner.next(); //Reading the file name
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(books); //Writing the books vector to the file
                oos.writeObject(clients); //Writing the clients vector to the file
                System.out.println("Library saved successfully!");
            } catch (IOException e) {   
                e.printStackTrace();
            }
        }
    }


    //Loading the library details from a file
    public static void loadLibrary(ArrayList<Book> books, ArrayList<Client> clients)
    {
        System.out.println("Enter the file name you want to load the library from: ");
        Scanner loadScanner = new Scanner(System.in);
        String fileName = loadScanner.next(); //Reading the file name
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<Book> loadedBooks = new ArrayList<Book>(); //book vector
            ArrayList<Client> loadedClients = new ArrayList<Client>(); //client vector
            loadedBooks = (ArrayList<Book>) ois.readObject(); //Reading the books vector from the file
            loadedClients = (ArrayList<Client>) ois.readObject(); //Reading the clients vector from the file
            books.clear(); //Clearing the books vector
            clients.clear(); //Clearing the clients vector
            books.addAll(loadedBooks); //Adding the loaded books to the books vector
            clients.addAll(loadedClients); //Adding the loaded clients to the clients vector
            System.out.println("Library loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        int choice=0;
        int choice2=0;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>(); //book vector
        ArrayList<Client> clients = new ArrayList<Client>(); //client vector

        while(choice!=6)
        {
            //Main menu
            System.out.println("\n  Library System");
            System.out.println("1. Show Books");
            System.out.println("2. Show Clients");
            System.out.println("3. Search Options");
            System.out.println("4. Editing Options");
            System.out.println("5. Save/Load Library");
            System.out.println("6. Exit");
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
                            System.out.println("\n"+(i+1)+".");
                            books.get(i).printBookInfo(); //print i-th book info
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
                            System.out.println("\n"+(i+1)+".");
                            clients.get(i).printClientInfo(); //print i-th client info
                        }
                    }
                    break;
                }    
                case 3:
                {
                    System.out.println("\n  Search Options");
                    System.out.println("1. Search Books");
                    System.out.println("2. Search Clients");
                    System.out.println("3. Return");
                    System.out.println("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                        {
                            //Checking wether the books vector is empty
                            if(books.isEmpty()==true)
                            {
                                System.out.println("There are no books in the system - Try adding some!");
                                break;
                            } else {
                                System.out.println("\n  Search Options");
                                System.out.println("1. Search by title");
                                System.out.println("2. Search by author");
                                System.out.println("3. Search by genre");
                                System.out.println("4. Search by year");
                                System.out.println("5. Search by ID");
                                System.out.println("6. Return");
                                System.out.println("Enter your choice: ");
                                int choice3 = scanner.nextInt();
                                switch (choice3) {
                                    case 1:
                                    {
                                        System.out.println("Enter the book title you want to search: ");
                                        String bookTitle = scanner.next();
                                        for(int i=0;i<books.size();i++)
                                        {
                                            if(books.get(i).title.equals(bookTitle)) //Checking if the title is the same
                                            {
                                                books.get(i).printBookInfo(); //Printing the book info
                                            }
                                        }
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.println("Enter the author you want to search: ");
                                        String bookAuthor = scanner.next();
                                        for(int i=0;i<books.size();i++)
                                        {
                                            if(books.get(i).author.equals(bookAuthor)) //Checking if the author is the same
                                            {
                                                books.get(i).printBookInfo(); //Printing the book info
                                            }
                                        }
                                        break;
                                    }
                                    case 3:
                                    {
                                        System.out.println("Enter the book genre you want to search: ");
                                        String bookGenre = scanner.next();
                                        for(int i=0;i<books.size();i++)
                                        {
                                            if(books.get(i).genre.equals(bookGenre)) //Checking if the genre is the same
                                            {
                                                books.get(i).printBookInfo(); //Printing the book info
                                            }
                                        }
                                        break;
                                    }
                                    case 4:
                                    {
                                        System.out.println("Enter the book year you want to search: ");
                                        int bookYear = scanner.nextInt();
                                        for(int i=0;i<books.size();i++)
                                        {
                                            if(books.get(i).year==bookYear) //Checking if the year is the same
                                            {
                                                books.get(i).printBookInfo(); //Printing the book info
                                            }
                                        }
                                        break;
                                    }
                                    case 5:
                                    {
                                        System.out.println("Enter the book ID you want to search: ");
                                        double searchID = scanner.nextDouble();
                                        for(int i=0;i<books.size();i++)
                                        {
                                            if(books.get(i).bookID==searchID)
                                            {
                                                books.get(i).printBookInfo();
                                            }
                                        }
                                        break;
                                    }
                                    case 6:
                                    {
                                        break;
                                    }
                                    default:
                                        break;
                                }
                            }
                            break;
                        }
                        case 2:
                        {
                            //Checking wether the clients vector is empty
                            if(clients.isEmpty()==true) 
                            {
                                System.out.println("There are no clients in the system - Try adding some!");
                                break;
                            } else {
                                System.out.println("\n  Search Options");
                                System.out.println("1. Search by name");
                                System.out.println("2. Search by email");
                                System.out.println("3. Search by phone number");
                                System.out.println("4. Search by ID");
                                System.out.println("5. Return");
                                System.out.println("Enter your choice: ");
                                int choice3 = scanner.nextInt();
                                switch (choice3) {
                                    case 1:
                                    {
                                        System.out.println("Enter the client name you want to search: ");
                                        String clientName = scanner.next();
                                        for(int i=0;i<clients.size();i++)
                                        {
                                            if(clients.get(i).clentName.equals(clientName))
                                            {
                                                clients.get(i).printClientInfo();
                                            }
                                        }
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.println("Enter the client email you want to search: ");
                                        String clientEmail = scanner.next();
                                        for(int i=0;i<clients.size();i++)
                                        {
                                            if(clients.get(i).email.equals(clientEmail))
                                            {
                                                clients.get(i).printClientInfo();
                                            }
                                        }
                                        break;
                                    }
                                    case 3:
                                    {
                                        int clientPhoneNumber=0;
                                        while (clientPhoneNumber <= 100000000 || clientPhoneNumber > 999999999) {
                                            System.out.println("Enter the client phone number you want to search: ");
                                            clientPhoneNumber = scanner.nextInt();
                                        }
                                        for(int i=0;i<clients.size();i++)
                                        {
                                            if(clients.get(i).phoneNumber==clientPhoneNumber)
                                            {
                                                clients.get(i).printClientInfo();
                                            }
                                        }
                                        break;
                                    }
                                    case 4:
                                    {
                                        System.out.println("Enter the client ID you want to search: ");
                                        int clientID = scanner.nextInt();
                                        for(int i=0;i<clients.size();i++)
                                        {
                                            if(clients.get(i).clientID==clientID)
                                            {
                                                clients.get(i).printClientInfo();
                                            }
                                        }
                                        break;
                                    }
                                    case 5:
                                    {
                                        break;
                                    }
                                    default:
                                        break;
                                }
                            }
                            break;
                        }
                        case 3:
                        {
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }


                case 4:
                {
                        System.out.println("\n  Editing Options");
                        System.out.println("1. Add Books");
                        System.out.println("2. Add Clients");
                        System.out.println("3. Search Options");
                        System.out.println("4. Edit Options");
                        System.out.println("5. Return");
                        System.out.println("Enter your choice: ");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                            {
                                System.out.println("How many books do you want to add?");
                                int amount = scanner.nextInt();
                                for(int i=0;i<amount;i++)
                                {
                                    books.add(new Book()); //Adding a new Book object to the books vector
                                }
                                break;
                            }
                            case 2:
                            {
                                System.out.println("How many clients do you want to add?");
                                int amount = scanner.nextInt();
                                for(int i=0;i<amount;i++)
                                {
                                    clients.add(new Client()); //Adding a new Client object to the clients vector
                                }
                                break;
                            }
                            case 3:
                            {

                                break;
                            }
                            case 4:
                            {
                                int choice3=0;
                                System.out.println("\n  Editing Options");
                                System.out.println("1. Remove Book");
                                System.out.println("2. Remove Client");
                                System.out.println("3. Return");
                                System.out.println("Enter your choice: ");
                                choice3 = scanner.nextInt();
                                switch (choice3) {
                                    case 1:
                                    {
                                        if(books.isEmpty()==true)
                                        {
                                            System.out.println("There are no books in the system - Try adding some!");
                                            break;
                                        } else {    
                                            for(int i=0;i<books.size();i++)
                                            {
                                                //Printing the book list
                                                System.out.println("\n"+(i+1)+".");
                                                books.get(i).printBookInfo();
                                            }
                                            System.out.println("Enter the book number you want to remove: ");
                                            int bookNumber = scanner.nextInt();
                                            books.remove(bookNumber-1); //remove the book
                                        }
                                        break;
                                    }
                                    case 2:
                                    {
                                        if(clients.isEmpty()==true)
                                        {
                                            System.out.println("There are no clients in the system - Try adding some!");
                                            break;
                                        } else { 
                                            for(int i=0;i<clients.size();i++)
                                            {
                                                //Printing the client list
                                                System.out.println("\n"+(i+1)+".");
                                                clients.get(i).printClientInfo(); 
                                            }
                                            System.out.println("Enter the client number you want to remove: ");
                                            int clientNumber = scanner.nextInt();
                                            clients.remove(clientNumber-1); //remove the client
                                        }
                                        break;
                                    }
                                    case 3:
                                    {
                                        break;
                                    }
                                    default:
                                        break;
                                }
                                break;
                            }
                            case 5:
                            {

                                break;
                            }

                            default:
                                break;
                        }
                    break;
                }
                case 5:
                {
                    //Saving and loading library to a file
                    System.out.println("\n  Save/Load Library");
                    System.out.println("1. Save Library");
                    System.out.println("2. Load Library");
                    System.out.println("3. Return");
                    System.out.println("Enter your choice: ");
                    choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                        {
                            LibrarySystemMain.saveLibrary(books, clients); //Saving the library
                            break;
                        }
                        case 2:
                        {
                            LibrarySystemMain.loadLibrary(books, clients); //Loading the library
                            break;
                        }
                        case 3:
                        {
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Thank you for using our library system!");
                    break;
                }
                default:
                    break;
            }
        }
        scanner.close(); //Closing the scanner
    }

}