import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;

public class PhotographerTest {
  Photographer photographer;
  AnalogCamera analogCamera;
  DigitalCamera digitalCamera;

  @Before
  public void before(){
    photographer = new Photographer();
    analogCamera = new AnalogCamera();
    digitalCamera = new DigitalCamera();
  }

  @Test
  public void bagStartsEmpty() {
    assertEquals(0, photographer.cameraCount());
  }

  @Test
  public void canAddCamera() {
    photographer.addCamera(analogCamera);
    assertEquals(1, photographer.cameraCount());
  }

  @Test
  public void canAddMoreThanOneCamera() {
    photographer.addCamera(analogCamera);
    photographer.addCamera(digitalCamera);
    assertEquals(2, photographer.cameraCount());
  }

  @Test
  public void canRemoveCamera() {
    photographer.addCamera(analogCamera);
    Printable camera = photographer.removeCamera();
    assertNotNull(camera);
  }

  @Test
  public void canRemoveDigitalCamera() {
    photographer.addCamera(digitalCamera);
    Printable camera = photographer.removeCamera();
    DigitalCamera original = (DigitalCamera) camera;
    assertEquals("Sony ILCE5100L, No noise reduciton, Lo-resolution", original.printDetails());
  }

  @Test
  public void canPrintAllDetails() {
    photographer.addCamera(digitalCamera);
    photographer.addCamera(analogCamera);
    assertEquals("Sony ILCE5100L, No noise reduciton, Lo-resolution / Pentax Program A 35mm SLR Film / " , photographer.allPrintDetails());
  }

}