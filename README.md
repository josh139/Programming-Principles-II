# Programming-Principles-II
The objective of this project was to implement three classes that will be used to simulate passengers queuing at a boarding gate and boarding the Eurostar train. Below I have included the brief:

## Eurostar Program.
1. You are to implement three classes for this coursework that will be used to simulate passengers queuing at a boarding gate and boarding the Eurostar train. The three classes and the relevant fields and methods are described in the **Class diagram** below. You may include additional fields and methods as required to complete the solution.

- **Passenger.** This class will contain the properties of a passenger that are relevant to our simulation.
  </br>**Fields** - ```firstName```:String, ```surname```:String, ```secondsInQueue```:int.
  </br>**Methods** - getters and setters (see class diagram).
  
- **PassengerQueue** This class will represent the queue at the boarding gate.
  </br>**Fields** - ```queueArray```: Array of Passenger, ```first```:int, ```last```:int, ```maxStayInQueue```:int.
  </br>**Methods** - ```add()```, ```remove()```, ```display()```, ```getMaxStay()```, ```isEmpty()```, ```isFull()```.

- **TrainStation** This is the main class that will drive the program.
  </br>**Fields** - ```waitingRoom```:Array of Passenger, ```trainQueue```:PassengerQueue.
  </br>**Methods** - ```main()``` and other methods you may implement.
  
![TrainStation drawio](https://user-images.githubusercontent.com/66877247/183742777-0ae72526-cf75-4cdc-8bae-9525d8c91c85.png)

