package assign2_template;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//2.2.1 Entity Class - VideoGame
public class VideoGame {

//data fields
private String title;
private String developer; // developer
private String platforms[];
private LocalDate releaseDate;

// default constructor for class Video Game
public VideoGame() {
    title = "";
    developer = "";
    platforms = null;
    releaseDate = null;
}

// constructor that takes in values for all data fields
public VideoGame(String title, String developer, String platforms[], LocalDate releaseDate){
    this.title = title;
    this.developer = developer;
    this.platforms = platforms;
    this.releaseDate = releaseDate;
}

// getter for each data field
public String getTitle(){
    return title;
}

public String getDeveloper(){
    return developer;
}

public String[] getPlatforms(){
    return platforms;
}

public LocalDate getReleaseDate(){
    return releaseDate;
}

// setter for each data field
public void setTitle(String title){
    this.title = title;
}

public void setDeveloper(String developer){
    this.developer = developer;
}

public void setPlatforms(String[] platforms){
    this.platforms = platforms;
}

public void setReleaseDate(LocalDate releaseDate){
    this.releaseDate = releaseDate;
}

// return ToString representation of the VideoGame
@Override
public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    String str = "[Title: "+title+", Developer: "+developer+", Platforms: ";
if(platforms != null && platforms.length > 0){
    for(int i=0;i<platforms.length-1;i++)
        str += platforms[i]+"/";
        str += platforms[platforms.length-1];
    }else
        str += "NONE";

    str += ", Release Date: "+dateFormatter.format(releaseDate);

    return str;
}

// comparing two VideoGame objects based only on title
// returns true if VideoGame objects are equal else returns false
@Override
public boolean equals(Object otherObject) {

// validate otherObject is an object of VideoGame
if(otherObject instanceof VideoGame){
// cast the object to VideoGame class
    VideoGame other = (VideoGame)otherObject;
        return title.equalsIgnoreCase(other.title); // compare based on title (case-insensitive)
        }
return false;
    }

}