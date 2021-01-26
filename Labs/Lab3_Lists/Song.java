import java.lang.Exception.*;

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

}
