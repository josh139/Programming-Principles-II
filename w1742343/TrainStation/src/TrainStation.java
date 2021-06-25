import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TrainStation 
{
    static int WAITING_ROOM_CAPACITY = 30;
    
    private static Passenger [] waitingRoom = new Passenger[WAITING_ROOM_CAPACITY];    
    private static PassengerQueue trainQueue = new PassengerQueue();

    public static void main(String[] args) throws IOException 
    {              
        Scanner in = new Scanner(System.in);
        char choice;
        do

        {
            displayMenu();
            System.out.print("Enter a choice (Q) to exit: ");
            choice = in.next().toUpperCase().charAt(0);

            switch(choice)
            {
                case 'A' : add();
                break;
                case 'V' : display();
                break;
                case 'D' : remove();
                break;
                case 'S': storeData();
                break;
                case 'L': loadData();
                break;
                case 'R': runReport(); //not working properly
                break;
                default: System.out.println("You entered an invalid choice.");
            }

        } while (choice != 'Q');
        
        System.out.println("Thanks for using the program. Good Bye!");
    
    }

    private static void displayMenu() 
    {
        System.out.println("A : to add a passenger to the trainQueue");
        System.out.println("----------------------------");
        System.out.println("V : to view the trainQueue");
        System.out.println("----------------------------");
        System.out.println("D : Delete passenger from the trainQueue");
        System.out.println("----------------------------");
        System.out.println("S : Store train Queue data into a plain text file");
        System.out.println("----------------------------");
        System.out.println("L : Load  data back from the file into the trainQueue");
        System.out.println("----------------------------");
        System.out.println("R : Run the simulation and produce report");
        System.out.println("----------------------------");
    }
    
    private static void add() 
    {  
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter firstname : ");
    	String firstName = in.nextLine();
    	System.out.println("Enter surname : ");
    	String surname = in.nextLine();
        Passenger p = new Passenger(firstName, surname);
        trainQueue.add(p);
        System.out.println("Passenger added to train queue successfully");       
    }
    
    private static void display() 
    {
        trainQueue.display();   	
    }
    
    private static void remove()
    {
        trainQueue.remove(); //removes first element in trainQueue
    }
    
    private static void storeData() throws IOException 
    {
    	String data = trainQueue.getString();
    	FileWriter myWriter = new FileWriter("store.txt",true);
        myWriter.write(data);
        myWriter.close();
        System.out.println("Data added succesfully");
    }

    private static void loadData() throws IOException 
    {
    	BufferedReader reader;
    	
			reader = new BufferedReader(new FileReader("store.txt"));
			String line = reader.readLine();
			while (line != null && !line.equals("")) 
                        {
				String data[] = line.split(" ");
				Passenger p = new Passenger(data[0],data[1]);
				System.out.println("----------------------------");
				trainQueue.add(p);
				System.out.println("Loaded from file");
				// read next line
				line = reader.readLine();
			}
    }

    private static void runReport() throws IOException //this method doesn't work properly however I have made an attempt
    {
    	BufferedReader reader;
    	
		reader = new BufferedReader(new FileReader("passengers.txt"));
		int l = 0;
		String line = reader.readLine();
                
		while (line != null&&!line.equals("")) 
                {
			String data[] = line.split(" ");
			Passenger p = new Passenger(data[0],data[1]);
			System.out.println("----------------------------");
			waitingRoom[l] = p;
			System.out.println("Loaded from file");
			// read next line
			line = reader.readLine();
			l += 1;
		}
		
		//add data from passengers.txt added to waiting room
		
		while(!trainQueue.isEmpty()) 
                {
			Random rand = new Random();

                        int waitingpersonsstartindex=0;
                        int randomNum = rand.nextInt((7 - 1) + 1) + 1;//Generate random number between 1 and 6
		    
                        for(int i=0;i<randomNum;++i) 
                        {
                            trainQueue.add(waitingRoom[waitingpersonsstartindex]);//add person from waiting to train queue
		    	 
                            waitingpersonsstartindex += 1;
                        }
                        int delay = rand.nextInt((4 - 1) + 1) + 1;//Generate random number between 1 and 3
	    	  
                        trainQueue.addwaitingtime(delay);//add the waiting time for all passenger in train queue
                        trainQueue.remove();//remove next passenger    
                }
    }
    
    }