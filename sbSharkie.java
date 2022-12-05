import java.util.Scanner;
/*
 * Processes and analyzes data about music
 */
public class Spotbox {

  // DECLARE INSTANCE VARIABLES
  private String[] Albums = new String[498];
  private String[] Artists = new String[498];
  private String[] Genres = new String[498];
  // INTEGER USED IN EACH FILTER FUNCTION TO FIND THE NUMBER OF "CORRECTLY" FILTERED ITEMS SO AN ARRAY CAN BE CREATED WHICH WILL BE THE PROPER SIZE TO FIT ALL THE FILTERED ITEMS
  private int count;
  // STRING USED TO HOLD THE CATEGORY THE USER WANTS TO FILTER 
  int filterCategory;
  // INT USED TO DETERMINE WHEN THE PROGRAM SHOULD END
  int runNumber = 0;
  // INT USED TO DETERMINE IF THE USER WANTS TO FILTER/SEARCH FOR ANOTHER ITEM AFTER DOING SO ONCE
  int Continue = 0;


  
  //CONSTRUCTOR FOR SPOTBOX OBJECT
  public Spotbox(String[] albums, String[] artists, String[] genres){
   Albums = albums;
   Artists = artists;
   Genres = genres;
  }
  

  
  // INSTANTIATING SCANNER FOR USER INPUT
  public Scanner input = new Scanner(System.in);

  //FUNCTION WHICH USES THE USER'S DESIRED FILTER CATEGORY TO FILTER RESULTS (USES SCANNER)
  public void filterAll(){
    //WHILE LOOP USED TO CONTINUE THE PROGRAM UNTIL THE USER INDICATES THEY DON'T WANT TO FILTER ANYTHING ELSE
    while(runNumber != 1){

    System.out.println("\n" + "------------------------------------------------------------------------------------" + "\n" + "What would you like to filter?" + "\n" + "1: Genres" + "\n" + "2: Artists" + "\n" + "3: Albums" + "\n" + "-1: Close App");
    filterCategory = input.nextInt();
    input.nextLine();
    //WHEN THE USER WANTS TO FILTER FOR GENRES:
    if(filterCategory == 1){
      System.out.println("\n" + "Which Genre would you like to filter for?" + "\n\n" + "|| Rock || Pop || Soul || Blues || Electronic || Jazz || Funk ||\n\n|| Folk || Reggae || Country || World || Classical || Stage & Screen ||");
      String filterGenre = input.nextLine();
      filterGenres(filterGenre);
      System.out.println("\n------------------------------------------------------------------------------------\n Would you like to filter something else? \n 1: Yes \n-1: No");
      Continue = input.nextInt();
      if(Continue == -1){
        runNumber = 1;
      }
    }
    //WHEN THE USER WANTS TO FILTER FOR ARTISTS:
    else if(filterCategory == 2){
      System.out.println("\n" + "Which Artist would you like to filter for?  ---  (If the artist is not found, you will return to the home screen.)");
      String filterArtist = input.nextLine();
      for(int i = 0; i<Artists.length-1; i++){
        if(Artists[i].contains(filterArtist)){
          filterArtists(filterArtist);
          System.out.println("\n------------------------------------------------------------------------------------\n Would you like to filter something else? \n 1: Yes \n-1: No");
          Continue = input.nextInt();
          if(Continue == 1){
              break;
          }
          else if(Continue == -1){
            runNumber = 1;
              break;
          }

        }
      }
    }
    //WHEN THE USER WANTS TO FILTER FOR ALBUMS:
    else if(filterCategory == 3){
      System.out.println("\n" + "Which Album would you like to search for?  ---  (If the album is not found, you will return to the home screen.)");
      String filterAlbum = input.nextLine();
      for(int i = 0; i<Albums.length-1; i++){
        if(Albums[i].contains(filterAlbum)){
            filterAlbums(filterAlbum);
            System.out.println("\n------------------------------------------------------------------------------------\n Would you like to filter something else? \n 1: Yes \n-1: No");
            Continue = input.nextInt();
          if(Continue == 1){
              break;
          }
          else if(Continue == -1){
            runNumber = 1;
              break;
          }
        }
      }
  }
    //WHEN THE USER WANTS TO QUIT THE PROGRAM:
    else if(filterCategory == -1){
          System.out.println("\nClosing App...");
          runNumber=1;
        }
    }
  }

  // FOR PRINTING ARRAYS
  public void printArray(String[] Array){
    for(int i = 0; i<Array.length;i++){
      System.out.print(Array[i] + "\n");
    }
  }


  
  // FILTER FOR GENRES
  public void filterGenres(String genre){  
   int fillIndex=0; // INT USED TO KEEP TRACK OF THE INDEX WHERE CORRECTLY FILTERED ITEMS SHOULD BE PLACED IN THE FILTERED LIST
   count = 0;
    //ADDING TO COUNT EVERY TIME THERE IS AN ALBUM/ARTISTS WHOSE GENRE IS THE DESIRED FILTERED GENRE SO AN ARRAY OF THE PROPER LENGTH CAN BE CREATED
    for(int i = 0; i<Albums.length-1; i++){
      if(Genres[i].contains(genre)){
        count += 1;
      }
    }
    // CREATING EMPTY ARRAYS OF LENGTH COUNT FOR THE FILTERED ITEMS TO GO IN
    String[] filteredArtists = new String[count];
    String[] filteredAlbums = new String[count];

  //TRAVERSE GENRES AND IF THE ITEM AT THAT PLACE CONTAINS THE DESIRED GENRE, TAKE THE ALBUM AND ARTIST AT THAT INDEX AND FILL THEM INTO THEIR FILTERED ARRAYS
  for(int i = 0; i<Genres.length-1;i++){
      if(Genres[i].contains(genre)){
        filteredArtists[fillIndex] = Artists[i];
        filteredAlbums[fillIndex] = Albums[i];
           fillIndex +=1;
      }
    }
      //PRINT RESULTS
      System.out.println("\nFILTERED ARTISTS:" + "\n");
      printArray(filteredArtists);
      System.out.println("\n" + "---------------------------------------------------------" + "\n" + "FILTERED ALBUMS:" + "\n");
      printArray(filteredAlbums);
  }

  // FILTER FOR ARTISTS
  public void filterArtists(String artist){  
   int fillIndex=0; // INT USED TO KEEP TRACK OF THE INDEX WHERE CORRECTLY FILTERED ITEMS SHOULD BE PLACED IN THE FILTERED LIST
   count = 0;   
    //ADDING TO COUNT EVERY TIME THERE IS AN GENRE/ALBUM WHOSE ARTIST IS THE DESIRED ARTIST SO AN ARRAY OF THE PROPER LENGTH CAN BE CREATED
    for(int i = 0; i<Albums.length-1; i++){
      if(Artists[i].contains(artist)){
        count += 1;
      }
    }

  // CREATING EMPTY ARRAYS OF LENGTH COUNT FOR THE FILTERED ITEMS TO GO IN
  String[] filteredGenres = new String[count];
  String[] filteredAlbums = new String[count];

  //TRAVERSE ARTISTS AND IF THE ITEM AT THAT PLACE CONTAINS THE DESIRED ARTIST, TAKE THE GENRE AND ALBUM AT THAT INDEX AND FILL THEM INTO THEIR FILTERED ARRAYS
  for(int i = 0; i<Artists.length-1;i++){
      if(Artists[i].contains(artist)){
        filteredGenres[fillIndex] = Genres[i];
        filteredAlbums[fillIndex] = Albums[i];
           fillIndex +=1;
      }
    }
   
      //PRINT RESULTS
      System.out.println("FILTERED GENRES:" + "\n");
      printArray(filteredGenres);
      System.out.println("\n" + "---------------------------------------------------------" + "\n" + "FILTERED ALBUMS:" + "\n");
      printArray(filteredAlbums);
  }

  // FILTER FOR ALBUMS
  public void filterAlbums(String album){  
   int fillIndex=0; // INT USED TO KEEP TRACK OF THE INDEX WHERE CORRECTLY FILTERED ITEMS SHOULD BE PLACED IN THE FILTERED LIST
   count = 0;
    //ADDING TO COUNT EVERY TIME THERE IS AN GENRE/ARTIST WHOSE ALBUM IS THE DESIRED ALBUM SO AN ARRAY OF THE PROPER LENGTH CAN BE CREATED
    for(int i = 0; i<Albums.length-1; i++){
      if(Albums[i].contains(album)){
        count += 1;
      }
    }

    // CREATING EMPTY ARRAYS OF LENGTH COUNT FOR THE FILTERED ITEMS TO GO IN
    String[] filteredGenres = new String[count];
    String[] filteredArtists = new String[count];

  //TRAVERSE ALBUMS AND IF THE ITEM AT THAT PLACE CONTAINS THE DESIRED ALBUM, TAKE THE GENRE AND ARTIST AT THAT INDEX AND FILL THEM INTO THEIR FILTERED ARRAYS
  for(int i = 0; i<Albums.length-1;i++){
      if(Albums[i].contains(album)){
        filteredGenres[fillIndex] = Genres[i];
        filteredArtists[fillIndex] = Artists[i];
           fillIndex +=1;
      }
    }
      //PRINT RESULTS
      System.out.println("FILTERED GENRES" + "\n");
      printArray(filteredGenres);
      System.out.println("\n" + "---------------------------------------------------------" + "\n" + "FILTERED ARTISTS:" + "\n");
      printArray(filteredArtists);
  }
}
