import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

/**
 *
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */
public class Track {
  List<Point> track = new ArrayList<>();
  List<Point> filest =new ArrayList<>();
  public int number=0;
  // TODO: Create a stub for the constructor
  public Track(){
  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename)
  throws GPSException,IOException{
    track.subList(size()-number, size()).clear();
    number =0;
    File file = new File(filename);
      Scanner scanner = new Scanner(file);
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }
  
      
      while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        String[] fields = line.split(",");
        if(fields.length != 4){
          throw new GPSException("invalid data columns");
        }
  
        ZonedDateTime time = ZonedDateTime.parse(fields[0]);
        double longitude = Double.parseDouble(fields[1]);
        double lattitude = Double.parseDouble(fields[2]);
        double elevation= Double.parseDouble(fields[3]);
        Point p = new Point(time,longitude,lattitude,elevation);
        add(p);
        number+=1;
      scanner.close();
    }

  }

  // TODO: Create a stub for add()
  public void add(Point p){
    track.add(p);
  }


  // TODO: Create a stub for get()
  public Point get(int i){

    if (i<0 || i>(size()-1)){
      throw new GPSException("invalid index");
    }
    return track.get(i);


  }


  // TODO: Create a stub for size()
  public int size(){
    return track.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    double lowest =1000.0;
    int index=0;
    int n=size();
    if(n<2){
      throw new GPSException("not enough points");
    }
    for(int i=0;i<n;i++){
      Point current = get(i);
      if(lowest >current.getElevation()){
        lowest=current.getElevation();
        index = i;
      }
    }
    return get(index);
  }


  // TODO: Create a stub for highestPoint()
  public Point highestPoint(){
    double highest =0.0;
    int index=0;
    int n=size();
    if (n<2){
      throw new GPSException("not enough points");
    }
    for(int i=0;i<n;i++){
      Point current = get(i);
      if(highest<current.getElevation()){
        highest=current.getElevation();
        index=i;
      }
    }
    return get(index);
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance(){
    double total=0.0;
    Point arbitrary = get(0);
    int n=size();
    if(n<2){
      throw new GPSException("not enough points");
    }
    for(int i=1;i<n;i++){
      Point p1=get(i);
      Point p2=get(i-1);
      total+=arbitrary.greatCircleDistance(p1, p2);
    }
    return total;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed(){
    int n =size();
    if(n<2){
      throw new GPSException("not enough points");
    }
    Point p1=get(0);
    Point p2=get(size()-1);
    ZonedDateTime first=p1.getTime();
    ZonedDateTime last=p2.getTime();
    long diff= ChronoUnit.SECONDS.between(first, last);
    double speed=totalDistance()/diff;
    return speed;
  }
}
