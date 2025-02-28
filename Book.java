import java.util.*;
import java.io.Serializable;

public class Book implements Serializable {
    String title;
    String author;
    String genre;
    int year=0;
    int bookID=0;
    transient Scanner bookScanner = new Scanner(System.in);

    public Book()
    {
        System.out.println("Enter Title: ");
        this.title = bookScanner.nextLine();
        System.out.println("Enter Author: ");
        this.author = bookScanner.nextLine();
        System.out.println("Enter Genre: ");
        this.genre = bookScanner.nextLine();
        while(this.year <= 0 || this.year>9999)
        {
            System.out.println("Enter Release Year: ");
            this.year = bookScanner.nextInt();
        }
        while(this.bookID <=0)
        {
            System.out.println("Enter Book ID: "); 
            bookID = bookScanner.nextInt();
        }
    }
    
    

    public void printBookInfo()
    {
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Release Year: "+this.year);
        System.out.println("Genre: "+this.genre);
        System.out.println("ID: "+this.bookID);  
    }
}
