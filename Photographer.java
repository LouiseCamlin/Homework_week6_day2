import java.util.*;

public class Photographer {

  private ArrayList<Printable> bag;

  public Photographer() {
    this.bag = new ArrayList<Printable>();
  }

  public int cameraCount() {
    return this.bag.size();
  }

  public void addCamera(Printable camera) {
    this.bag.add(camera);
  }

  public Printable removeCamera() {
    if (cameraCount() > 0) {
      return bag.remove(0);
    }
    return null; 
  }

  public String allPrintDetails() {
    String allDetails = ""; 
      for(Printable camera : this.bag) {
        allDetails += camera.printDetails() + " / ";
      }
    return allDetails;

  }






}