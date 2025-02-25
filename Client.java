public class Client {
    String clentName;
    String email;
    int phoneNumber;
    int clientID;

    public void printClientInfo()
    {
        System.out.println("Client ID: "+this.clientID);
        System.out.println("Client Name: "+this.clentName);
        System.out.println("Email: "+this.email);
        System.out.println("Phone Number: "+this.phoneNumber);
        
    }
}
