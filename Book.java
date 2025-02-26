import java.util.Scanner;

public class Book {
    String title;
    String author;
    String genre;
    int year=0;
    double ISBN=0;
    Scanner bookScanner = new Scanner(System.in);

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
        while(this.ISBN > 9999999999999.0 || this.ISBN<1000000000000.0)
        {
            System.out.println("Enter ISBN: "); 
            ISBN = bookScanner.nextDouble();
        }
    }
    
    public void printBookInfo()
    {
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Release Year: "+this.year);
        System.out.println("Genre: "+this.genre);
        System.out.println("ISBN: "+this.ISBN);  
    }
}
