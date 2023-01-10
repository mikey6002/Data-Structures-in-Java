//File: MovieDB.java
//You are to complete this class.
package assign6_template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovieDB {

    // ----------Assign 6 Begin ----------------//
    // movie database, to be implemented as an array list (better)
    // initial capacity of the movie database (max number of movies can be stored
    // initially)
    // private static final int INITIAL_CAPACITY = 20;
    // the number of movies in the starter movie database
    private static final int STARTER_MOVIEDB_SIZE = 15;

    // decare a data field named titleIndex for the movie title index
    private List<Movie> movieDB;
    private Set<IndexEntry> titleIndex;
    // must use both Set interface and TreeSet class in Java API
    // add your code here

    // constructor of MovieDB
    public MovieDB() {
        // Add your code

        // create the object for the empty movieDB
        movieDB = new ArrayList<Movie>();
        // Create the object for the empty index tree.
        titleIndex = new TreeSet<IndexEntry>();

    }

    // create a starter movie DB:
    // use random numbers to generate STARTER_MOVIEDB_SIZE number of movies with
    // random data.
    // (e.g. Title15 Director15 2019)
    // use HashSet to test if a random number is unique.
    // append each random movie to the movieDB list.
    public void createStartMovieDB() {
        // add your own code

        // public static void main(String[] args) {
        // create a random number generator
        // Random randomNumberGenerator = new Random();
        // get a random integer between 0 (inclusive) and 200 (exclusive)
        // 0, 1, 2, ... ,199
        // int randomNumber = randomNumberGenerator.nextInt(200);
        // System.out.println(randomNumber);
        // get a random integer between 1 (inclusive) and 200 (inclusive)
        // 1, 2, 3, ...., 200
        // randomNumber = randomNumberGenerator.nextInt(200) + 1;
        // System.out.println(randomNumber);
        // }

        // }
        // initialize the counter to 0.
        // create an empty HashSet of Integers;
        Set<String> startMovies = new HashSet<String>();
        // Repeat
        // genereate a random number in the range: [0, STARTER_MOVIEDB_SIZE-1]
        // or [1, STARTER_MOVIEDB_SIZE]
        Random randNumGenerator = new Random();
        // use a HashSet to check if the randome number is unique
        while (startMovies.size() != STARTER_MOVIEDB_SIZE) {
            // if this random number is unique
            // use this random number to create a random movie with the random data:
            // like Title15 Director15 2019
            // append the random movie to the movieDB list.
            // increase counter
            int randNumber = randNumGenerator.nextInt(STARTER_MOVIEDB_SIZE) + 1;
            String title = "Title" + randNumber;
            String director = "Director" + randNumber;
            Movie newMovie = new Movie(title, director, 2019);

            if (!startMovies.contains(title)) {
                startMovies.add(title);
                movieDB.add(newMovie);
            }
        }
        // Until STARTER_MOVIEDB_SIZE number of movies have been generated.

        // Hint: see sample usage of Random number generation in the main method below

        // Must use a HashSet to check if the random number is unique

    }

    // display the movies in the database in a nice tabular format
    // like the one in the sample output
    public void showMovieDB() {
        // add your own code
        System.out.println("Movie Database: \n");

        System.out.println("          Title       Director  Year\n" + "----------------------------------------"); // I
        // counted
        // 34
        // broekn
        // lines in the asisgnment
        // page
        // Hint:
        // use a loop to iterate over all movies in the movieDB
        // Use String.format(...) to print in the desired format
        // See set_map_use.IndexGenerator covered in Lec#19 for formatting.
        for (Movie current : movieDB) {
            String currentStr = "";
            currentStr += IntStream.range(0, 15 - current.getTitle().length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            currentStr += current.getTitle();

            currentStr += IntStream.range(0, 16 - current.getDirector().length())
                    .mapToObj(i -> " ")
                    .collect(Collectors.joining(""));
            currentStr += current.getDirector();

            currentStr += " " + current.getYear();

            System.out.println(currentStr);
        }

        System.out.println("");
    }

    // create the index tree for all titles (unique) in the current movieDB
    public void createIndex() {
        // add your own code

        // Hint:
        // It’s very similar to createIndex() in the class IndexGenerator in the package
        // set_map_use_demo posted for Lec#19.
        // The difference is in handling the index entry in different stored format.
        for (int i = 0; i < movieDB.size(); ++i) {

            // for each movie in the moiveDB list
            // create an index entry for this movie using IndexEntry class
            IndexEntry newEntry = new IndexEntry(movieDB.get(i).getTitle(), i);
            // (example index entry in displayed format: Title15 0)
            // add this IndexEntry object to the data field: titleIndex
            titleIndex.add(newEntry);
        }
    }

    // display the title index in in a tabular format
    // like the one in the sample output
    public void showIndex() {
        // add your own code
        System.out.println("Title Index: \n");

        System.out.println("         Title    Location\n");
        // Hint:
        // It’s similar to showIndex() in the class IndexGenerator in the package
        // set_map_use_demo posted for Lec#19.
        // The difference is in handling the index entry in different stored format and
        // different printed format.
        // iterates through movieDB to creat titleIndex based on position
        for (IndexEntry current : titleIndex) {
            String currentStr = "";
            // for each index entry in the data field : titleIndex
            // display it using String.format(....)
            //currentStr += IntStream.range(0, 15 - current.getTitle().length())
               //     .mapToObj(i -> " ")
                 //   .collect(Collectors.joining(""));
            currentStr += current.getTitle();

            String n = (current.getLocation() < 10) ? "   " : "   ";
            currentStr += n + current.getLocation();

            System.out.println(currentStr);
        }

        System.out.println("");
    }
}

// ----------Assign 6 End ----------------//

// code below might be helpful to you.
/*
 * public static void main(String[] args) {
 * // create a random number generator
 * Random randomNumberGenerator = new Random();
 * // get a random integer between 0 (inclusive) and 200 (exclusive)
 * // 0, 1, 2, ... ,199
 * int randomNumber = randomNumberGenerator.nextInt(200);
 * System.out.println(randomNumber);
 * // get a random integer between 1 (inclusive) and 200 (inclusive)
 * // 1, 2, 3, ...., 200
 * randomNumber = randomNumberGenerator.nextInt(200) + 1;
 * System.out.println(randomNumber);
 * }
 * 
 * }
 */
