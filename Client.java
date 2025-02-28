import java.util.*;
import java.io.Serializable;

public class Client implements Serializable{
    String clentName;
    String email;
    int phoneNumber;
    int clientID;
    transient Scanner clientScanner = new Scanner(System.in);

    public Client()
    {
        System.out.println("Enter Name: ");
        this.clentName = clientScanner.nextLine();
        System.out.println("Enter E-mail: ");
        this.email = clientScanner.nextLine();
        while(this.clientID <= 0 || this.clientID>9999)
        {
            System.out.println("Enter Client ID: ");
            this.clientID = clientScanner.nextInt();
        }
        while(this.phoneNumber < 100000000 || this.phoneNumber>999999999)
        {
            System.out.println("Enter Phone Number: ");
            this.phoneNumber = clientScanner.nextInt();
        }
        
    }
    public void printClientInfo()
    {
        System.out.println("Client ID: "+this.clientID);
        System.out.println("Client Name: "+this.clentName);
        System.out.println("Email: "+this.email);
        System.out.println("Phone Number: "+this.phoneNumber);
        
    }
}
