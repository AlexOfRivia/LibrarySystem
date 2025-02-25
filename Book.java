public class Book {
    int ISBN;
    String title;
    String author;
    int year;
    String genre;

    public void printBookInfo()
    {
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Release Year: "+this.year);
        System.out.println("Genre: "+this.genre);
        System.out.println("ISBN: "+this.ISBN);  
    }
}
