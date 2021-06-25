public class Passenger 
{
    private String firstName;
    private String surname;
    private int secondsInQueue;
    
    Passenger(String firstName, String surname)
    {
        this.firstName = firstName;
        this.surname = surname;
        secondsInQueue = 0;
    }
    
    public String getName()
    {
        return firstName + " " + surname;
    }
    
    public void setName(String firstName, String surname)
    {
        this.firstName = firstName;
        this.surname = surname;
    }
    
    public int getSeconds() //int
    {
    	return secondsInQueue;
        //return int;
    }
    
    public void setSecondsInQueue(int s)
    {
    	secondsInQueue = s;
    }
    
    public String get() 
    {
    	return firstName + " " + surname + " " + secondsInQueue+"\n";
    }
    
    public void display()
    {
        System.out.println(firstName + " " + surname + " " + secondsInQueue);
    }
    
}