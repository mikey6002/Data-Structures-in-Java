package assign2_template;
import java.time.LocalDate;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageVideoGames {
    static Scanner input = new Scanner(System.in);

public static void main(String[] args) {
    //2.2.2 Application Class - ManageVideoGames

    //create an empty list of VideoGames    
    List<VideoGame> gameList = new LinkedList();
  

    while(true){
        //1. display menu
        displayMenu();

        //2. get user choice
        int choice = getUserChoice();

        //3. take action based on user choice
    if(choice==6){
        break;
    }else if(choice==1){
        System.out.println("Add game");
        addNewGame(gameList);
    }else if(choice==2){
        System.out.println("Remove game");
        removeGame(gameList);
    }else if(choice==3){
        System.out.println("Game list");
    for(int i=0; i<gameList.size(); i++){
        System.out.println(gameList.get(i));
        }
    }
    else if(choice==4){
        System.out.println("Latest game");
        VideoGame game = getLatestGame(gameList);
        System.out.println(game);
    }
    else if(choice==5){
        System.out.println("Add game");
        AlphNewGame(gameList);
        }
    }

}

    //define other methods for modularization, samples are listed below.
    //method to display menu
    public static void displayMenu() {
    System.out.println("***MENU***");
    System.out.println("1. Add a new game");
    System.out.println("2. Remove an existing game");
    System.out.println("3. Display the games in the order they were inserted");
    System.out.println("4. Find the games with latest release");
    System.out.println("5. Add a new game in the alphabetical order of title");
    System.out.println("6. Exit");
    }

    //method to get user choice
    public static int getUserChoice() {
    
    // keep reading user input until user enters correct input
    while(true){
        System.out.println("Enter a number to make your selection");
        int choice = input.nextInt();
    if(choice<1 || choice>6)
        continue;
        input.nextLine();
        return choice;
        }
    }

    //method to get user input, create and return a video game
    public static VideoGame getNewGame() {
        //get new game based on user input:
        // keyboard input
        VideoGame newGame = new VideoGame();

        //game title:
        //use nextLine() to avoid problems caused by newline character
        System.out.print("Enter the game title: ");
        newGame.setTitle(input.nextLine());
        System.out.print("Enter the lead developer: ");
        newGame.setDeveloper(input.nextLine());

        //platforms:
        //get how-many:
        System.out.print("Enter the number of platforms: ");
        int n = input.nextInt();
        input.nextLine();
        String platforms[] = new String[n];
        
        //use loop to get each platform.
        for(int i=0; i<n; i++){
            System.out.print("Enter the platform: ");
            platforms[i] = input.nextLine();
        }
        newGame.setPlatforms(platforms);
        //date value:
        //get 3 integers: month, day, year
        //use LocaleDate.of(year, month, day) to create a date TestDate.java 
        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter day: ");
        int day = input.nextInt();
        System.out.print("Enter Year: ");
        int year = input.nextInt();
        input.nextLine();
        LocalDate date1 = LocalDate.of(year, month, day);
        newGame.setReleaseDate(date1);
        return newGame;
        }

    //method to add a video game without maintaining sorted order
    public static void addNewGame( List<VideoGame> gameList){
        VideoGame newGame = getNewGame();
        gameList.add(newGame);
    }
    
    //method to remove a game based on user input
    public static int removeGame( List<VideoGame> gameList){
            System.out.print("Enter the game title: ");
            String title = input.nextLine();
        for(int i=0; i<gameList.size(); i++){
        if(title.equalsIgnoreCase(gameList.get(i).getTitle())){
            gameList.remove(gameList.get(i));
            System.out.println("Game removed");
        return 1;
            }
        }
        System.out.println("Game not found");
        return -1;
    }

    //method to find the game with latest release date
    /* simple assumption: only one game has the latest release date.
       need to loop through the collection and find the latest release date                                                        (largest)
            while looping, 
               record and update the current latest release date value 
                   and the corresponding VideoGame object.

       compare dates: isBefore, isAfter, or compareTo
           TestDate.java  */
    public static VideoGame getLatestGame( List<VideoGame> gameList){
        VideoGame latest = null;
        if(gameList.size()>0)
            latest = gameList.get(0);
        for(int i=1; i<gameList.size(); i++){
        if(gameList.get(i).getReleaseDate().isAfter(latest.getReleaseDate()))
            latest = gameList.get(i);
        }
        return latest;
    }


 
    // method to add a video game in alphabetical order of game titles
     /*    
     add new game in alphabetical order of game titles
        Do not append the new game to the current collection and then sort the entire collection. 
	Instead,
           start with the first game, 
           loop through the collection and 
               find the first game whose title is alphabetically larger than the new game. 
               Then insert the new game at the location of this target.
           If no existing game title is larger than the new game,
               append the new game to the end of game collection list.    
    
   */  
    public static int AlphNewGame( List<VideoGame> gameList){
        VideoGame newGame = getNewGame();
        for(int i=0; i<gameList.size(); i++){
        if(newGame.compareTo(gameList.get(i))<0){
            gameList.add(i, newGame);
            return 1;
            }
        }
            gameList.add(newGame);
            return 1;
    }

}
