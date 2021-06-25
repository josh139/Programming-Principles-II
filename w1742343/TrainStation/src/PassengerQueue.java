public class PassengerQueue 
{

    private Passenger[] queueArray = new Passenger[TrainStation.WAITING_ROOM_CAPACITY];
    private int first = 0;
    private int last = 0;
    private int maxStayInQueue = 0;
    private int maxLength = 0;
    
    void add(Passenger next)
    {
        //If the queue is not full - check for the circular queue
    	if(maxLength == TrainStation.WAITING_ROOM_CAPACITY-1) 
        {
    		System.out.println("Queue already full");
    		
    		return;
    	}
        
        //add the next passeneger
        queueArray[last] = next;
        maxLength += 1;
        last++;
        
        //check the maxlength of the queue
    }

    public Passenger remove()
    {
    	if(maxLength==0) 
        {
    		System.out.println("Queue empty.Cannot remove");
    		return null;
    	}
    	
        //if the queue array is not empty
        //remove passenger
        Passenger removedPassenger = queueArray[first];
        first += 1;
        maxLength -= 1;
        
        //inform that no passengers (return null)
        return removedPassenger;
    }
    
    public boolean isEmpty()
    {
        return maxLength == 0;
    }
    
    public boolean isFull()
    {
    	return maxLength == TrainStation.WAITING_ROOM_CAPACITY-1;
    }
    
    public String getString() 
    {
    	String toReturn = "";
        for(int x = first; x < last; x++)
         {
             toReturn += queueArray[x].get()+"\n";
         }
         return toReturn;
    }
    
    public void addwaitingtime(int t) 
    {
    	 for(int x = first; x < last; x++)
         {
             queueArray[x].setSecondsInQueue(queueArray[x].getSeconds()+t);
         }	
    }
    
    public void display()
    {
        //list elements from first to last in the queueArray
        for(int x = first; x < last; x++)
        {
            queueArray[x].display();
        }
    }
    
    public int  getLength()
    {
        return last;
    }
    
    public int  getMaxStay()
    {
        return maxStayInQueue;
    }
    
}