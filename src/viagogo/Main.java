package viagogo;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math; 
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.util.Pair;
import java.util.Random;
import java.text.DecimalFormat;

public class Main{
  
  private static List<Event> events_list = new ArrayList<Event>();
  
  
  public static List<Pair<Integer, Integer>> closest(int x, int y){
    
    List<Pair<Integer, Integer>> dists = new ArrayList<Pair<Integer, Integer>>();

    int i=0;
    for (Event event : events_list) {
          int dist = manhatten_dist(x,y,event.getX(), event.getY());    
      dists.add(new Pair <Integer,Integer> (i, dist));
      i++;
      
    }
    
	
    Collections.sort(dists, new ListComparator());
    
    return dists;
    
  }
  
  
  
  
  public static int manhatten_dist(int x1, int y1, int x2, int y2){
    
   	int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
    
    return dist;
  }
  
  

  
  
  public static void gen_events(){
    
	int min = 10;
    int max = 20;
	int event_num = ThreadLocalRandom.current().nextInt(min, max + 1);
    
    
    for(int i=0; i<event_num; i++){

      	int tic_nums = ThreadLocalRandom.current().nextInt(1, 3 + 1);
      	int x,y;
      
       int check=0;
      
        do{
   		     x = ThreadLocalRandom.current().nextInt(-10, 10 + 1);
             y = ThreadLocalRandom.current().nextInt(-10, 10 + 1); 
        
         		for (Event event : events_list) {
                  if(event.getX()==x && event.getY()==y){
                  check=1;
                    break;
		          }
                }
        
        
      }while(check==1);

      events_list.add(new Event(String.format("%03d", i), x, y, tic_nums));
      
    }
    
    
  }
 
  
  
  
  
  
  
  
  
  
  
  public static void gen_tickets(){
    
    for(Event event : events_list){
   
       event.setTickets();
      
     // System.out.println("name " + event.getName());
     // System.out.println("location " + event.getX() + "," + event.getY());
     // System.out.println("no of tickets " + event.getTicks());
      
     
      
    }
  }
  
  
  
  public static void print_event(Event event, int dist){
    DecimalFormat df = new DecimalFormat("#.##");
    System.out.println("Event " + event.getName() + " - $" + df.format(event.getCheapestTick()) + ", Distance " + dist + "\n");
  }
  
  
  
  
  public static void fetch_data(int x, int y, List<Pair<Integer, Integer>> dists){
    
    for(int i=0; i<5; i++){
      
      print_event(events_list.get(dists.get(i).getKey()), dists.get(i).getValue());
    
    }
  }
  
  
  public static void user_input(){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Please input coordinates:\n");
    String input = scanner.nextLine();
    int c=0, x=0, y=0;
    
    for(String s : input.split(",")){
      if(c==0){
        x = Integer.parseInt(s);
        c++;
      }
      if(c==1){
        y = Integer.parseInt(s);
      }
    }
    
    
    System.out.println("\nClosest events to (" +  x  + "," + y + "):\n");
    fetch_data(x,y, closest(x,y));
    

  }
  
  
  public static void main(String[] args){
    

    gen_events();
   gen_tickets();
   user_input();  
   
  }
  
}

