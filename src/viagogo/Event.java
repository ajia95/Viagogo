package viagogo;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Event{
    
    private String name;  
    private int[] location = new int[2];
    private int tick_types; //no of ticket types
    private List<Float> prices = new ArrayList<Float>();
      
    public Event(String name, int x, int y, int tick_types){  
     this.name = name;
     this.location[0] = x;
     this.location[1] = y;
     this.tick_types = tick_types;
    }  
  public String getName(){
    return name;
  }
  
  public int getX(){
    return location[0];
  }
    
  public int getY(){
    return location[1];
  }
  
  public int getTicks(){
    return tick_types;
  }
  
  public void setTickets(){
    //set max/min prices
    float min = 0;
    float max = 100;
    
    for(int i=0; i<getTicks(); i++){
      Random r = new Random();
      float price = min + r.nextFloat() * (max - min);
      this.prices.add(price);
    }
    
    
  }
  
  public float getCheapestTick(){
    //System.out.println(prices);
    return Collections.min(prices);
  }
  
 
  
}