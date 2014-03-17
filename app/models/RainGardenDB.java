package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import views.formdata.RainGardenFormData;

/**
 * Stores a list of contacts in a data structure.
 */
public class RainGardenDB {

  private static HashMap<Long, RainGarden> gardens = new HashMap<Long, RainGarden>();

  /**
   * Add rain garden.
   * 
   * @param formData Data form data.
   * @return The rain garden that has been added.
   */
  public static RainGarden addRainGarden(RainGardenFormData formData) {
    RainGarden garden;
    if (formData.id == 0) {
      long id = gardens.size() + 1;
      garden = new RainGarden(id, formData.title, formData.propertyType, formData.address, formData.hideAddress, 
                              formData.description, formData.month + "/" + formData.day + "/" + formData.year);
      gardens.put(id, garden);
      return garden;
    }
    else {
      garden = new RainGarden(formData.id, formData.title, formData.propertyType, formData.address, 
          formData.hideAddress,  formData.description, formData.month + "/" + formData.day + "/" + formData.year);
      gardens.put(garden.getID(), garden);
      return garden;
    }
  }

  /**
   * Return list of rain gardens.
   * 
   * @return List of rain gardens.
   */
  public static List<RainGarden> getRainGardens() {
    return new ArrayList<RainGarden>(gardens.values());
  }

  /**
   * Return rain garden with matching ID.
   * 
   * @param id The ID to be matched.
   * @return The rain garden with the matching ID.
   */
  public static RainGarden getRainGarden(long id) {
    RainGarden garden = gardens.get(id);
    if (garden == null) {
      throw new RuntimeException("Rain Garden ID is not valid.");
    }
    else {
      return garden;
    }
  }

  /**
   * Delete a rain garden.
   * 
   * @param id ID of rain garden.
   */
  public static void deleteRainGarden(long id) {
    gardens.remove(id);
  }

}