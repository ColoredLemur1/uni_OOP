import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 *
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */
public class Track {

  List<Point> track = new ArrayList<>();

  // TODO: Create a stub for the constructor
  public Track(String filen){
    String filename =filen;

  }

  // TODO: Create a stub for readFile()
  public void readFile(){
    try{
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
    
      if (scanner.hasNextLine()) {
        scanner.nextLine();
      }
    }catch(FileNotFoundException e){

    }
    
    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      String[] fields = line.split(",");
      if(fields.length != 4){
        GPSException exception= new GPSException("invalid data");
        return;
      }

      ZonedDateTime time = ZonedDateTime.parse(fields[0]);
      double longitude = Double.parseDouble(fields[1]);
      double lattitude = Double.parseDouble(fields[2]);
      double elevation= Double.parseDouble(fields[3]);
      track.add(new Point(time,longitude,lattitude,elevation));
    }
  }

  // TODO: Create a stub for add()
  public Point(Point p){

  }


  // TODO: Create a stub for get()


  // TODO: Create a stub for size()
  public int size(){
    return track.size();
  }

  // TODO: Create a stub for lowestPoint()

  // TODO: Create a stub for highestPoint()

  // TODO: Create a stub for totalDistance()

  // TODO: Create a stub for averageSpeed()
}
