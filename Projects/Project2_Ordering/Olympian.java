import java.util.*;
import java.util.Random;

/** Basic Student class to hold relevant data for a college student.
Makes use of the enumerated type Major (in the file Major.java).
Must implement compareTo(), which defines the default key field (to be used with ListOrdered), and equals (to be used with ListOrdered).
*/
public class Olympian implements Comparable<Olympian> {

  enum Season { SUMMER, WINTER };
  enum Medal { GOLD, SILVER, BRONZE, NONE };

  /** Unique ID for each new Student */
  private static Integer nextId = 100100;

  /** Generate new unique id
  @return unique id
  */
  public static int getNewID() {
    ++nextId;
    return nextId;
  }

  /** unique database id */
  private Integer id = null;
  /** full name */
  private String name;
  /** competitive sport */
  private String sport;
  /** event */
  //private String event;
  /** medal earned */
  private Medal medal;
  /** athlete's age */
  private Integer age;

  /** athletes country */
  private String country;
  /** Olympic season city, year */
  private Season season;
  private String city;
  private Integer year;

	public Olympian(String csvString) throws Exception {
		// name, age, country, year, season, city, sport, event, medal
		String[] tokens = csvString.split(",");
		if (8 != tokens.length) {
			throw new Exception();
		}
		name = tokens[0];
		age = Integer.parseInt(tokens[1]);
		country = tokens[2];
		year = Integer.parseInt(tokens[3]);
		if (tokens[4].equalsIgnoreCase("summer")) {
			season = Season.SUMMER;
		} else {
			season = Season.WINTER;
		}
		city = tokens[5];
		sport = tokens[6];
		//event = tokens[7];
		switch(tokens[7]) {
			case "Gold" : medal = Medal.GOLD; break;
			case "Silver" : medal = Medal.SILVER; break;
			case "Bronze" : medal = Medal.BRONZE; break;
			default: medal = Medal.NONE; break;
		}
		id = getNewID();
	}

  /** println example: 1001001 Larson, Amy : CSC (3.821) */
  public String toString() {
    return id+" "+name+", "+country+", "+sport+" ("+medal+")";
  }

	@Override
	public int compareTo(Olympian other) {
		return name.compareTo(other.name);
	}

	@Override
	public boolean equals(Object object) {
		// From https://www.geeksforgeeks.org/overriding-equals-method-in-java/
		// If the object is compared with itself then return true
		if (object == this) {
			return true;
		}
		// Check if other is an instance of Song or not
		if (!(object instanceof Olympian)) {
			return false;
		}
		// typecast other to Song so that we can compare data members
		Olympian other = (Olympian) object;

		return id.equals(other.id);
	}

  // Getters for every member variable
  public Integer id() { return id; }
  public String name() { return name; }
  public String sport() { return sport; }
  // String event() { return event; }
  public Medal medal() { return medal; }
  public Integer age() { return age; }
  public String country() { return country; }
  public Season season() { return season; }
  public String city() { return city; }
  public Integer year() { return year; }

}
