import java.lang.Exception.*;

/**
 * The Song class represents a song's metadata.
 * 
 * @param title the songs title
 * @param artist artist of the song
 * @param album the album title which the song resides on
 * @param year the year which the song was published
 */
public class Song {

  private String title = "undefined";
  private String artist = "undefined";
  private String album = "undefined";
  private Integer year = null;

  public Song() {
    // sets all member variables to defaults defined above.
  }

  public Song(String title, String artist, String album, Integer year) {
    this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
  }

  public Song(String title, String artist, String album) {
    this(title, artist, album, null);
  }

  @Override
  public String toString() {
    if (null==year) {
      return String.format("%20s by %s. %s",title,artist,album);
    }
    else {
      return String.format("%20s by %s. %s (%d)",title,artist,album,year);
    }
  }

	public String title() { return title; }
	public String artist() { return artist; }
	public String album() { return album; }
	public Integer year() { return year; }

	public void title(String inTitle) { title = inTitle; }
	public void artist(String inArtist) { artist = inArtist; }
	public void album(String inAlbum) { album = inAlbum; }
	public void year(Integer inYear) { year = inYear; }

	public void set(String field, Integer year) {
		if (field.equalsIgnoreCase("year")) {
			year(year);
		} else {
			throw new IllegalArgumentException("Field "+field+" not recognized.");
		}
	}
  public void set(String field, String value) {
    if (field.equalsIgnoreCase("title")) {
      title(value);
			return;
		}
    if (field.equalsIgnoreCase("artist")) {
      artist(value);
			return;
		}
    if (field.equalsIgnoreCase("album")) {
      album(value);
			return;
		}
    throw new IllegalArgumentException("Field "+field+" not recognized.");
  }

  /**
   * Tests equality of two songs, NOT case sensitive.
   * @param s to be compared with implicit song
   * @return if songs are equal
   */
  @Override
  public boolean equals(Object s) { 

      // If the object is compared with itself then return true   
      if (s == this) { 
          return true; 
      } 

      /* Check if o is an instance of Song or not 
        "null instanceof [type]" also returns false */
      if (!(s instanceof Song)) { 
          return false; 
      } 
        
      // typecast o to Song so that we can compare data members  
      Song c = (Song) s; 
        
      // Compare the data members and return accordingly  
      return ((this.title.equalsIgnoreCase(c.title)) && (this.album.equalsIgnoreCase(c.album)) && (this.artist.equalsIgnoreCase(c.artist)) && (this.year.equals(c.year)));
  }

}
