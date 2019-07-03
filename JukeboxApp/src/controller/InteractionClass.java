package controller;

import java.util.Scanner;

import ennumerators.Genre;
import ennumerators.Region;
import model.Album;
import model.Interpreter;
import model.Jukebox;
import model.Song;

/**
 * Class that models the interaction window with the user.
 * @author Pedro Guillermo Feijóo-García
 */
public class InteractionClass 
{
	/**
	 * Main method of the application. It controls the excecution of the program.
	 * @param args arguments input by the Java Virtual Machine and the environment.
	 */
	public static void main(String[] args) 
	{
		Jukebox model = new Jukebox();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to JukeboxApp!");
		
		
		boolean continueExcecution = true;
		while(continueExcecution == true)
		{
			System.out.println("Please select one of the following actions:");
			System.out.println("Add a new album [1]");
			System.out.println("Add a new song to an existing album [2]");
			System.out.println("Add a new hit [3]");
			System.out.println("Search for an existing album [4]");
			System.out.println("Search for a song in an album [5]");
			System.out.println("Search for a hit [6]");
			System.out.println("Delete an album [7]");
			System.out.println("Delete a song from an existing album [8]");
			System.out.println("Delete a hit [9]");
			System.out.println("Retrieve the most expensive album [10]");
			System.out.println("Retrieve the least expensive album [11]");
			System.out.println("Retrieve the longest song in an existing album [12]");
			System.out.println("Retrieve longest hit [13]");
			System.out.println("Retrieve shortest hit [14]");
			System.out.println("Retrieve the number of existing albums [15]");
			System.out.println("Retrieve the number of existing hits [16]");
			
			
			String txtResponse = input.nextLine();
			int response = Integer.parseInt(txtResponse);
			
			if(response == 1) //Add new album
			{
				System.out.println("Let's add the interpreter first.");
				System.out.println("What is the name of the interpreter?");
				String nameInterpreter = input.nextLine();
				System.out.println("What is the surname of the interpreter?");
				String surnameInterpreter = input.nextLine();
				System.out.println("What is the age of the interpreter");
				String txtAge = input.nextLine();
				int ageInterpreter = Integer.parseInt(txtAge);
				System.out.println("What is the region of the interpreter");
				String regionText = input.nextLine();
				Region regionInterpreter = Region.valueOf(regionText);
				
				Interpreter albumInterpreter = new Interpreter(nameInterpreter, surnameInterpreter, ageInterpreter, regionInterpreter);
				
				System.out.println("Now let's create the album.");
				System.out.println("What is the name of the album?");
				String nameAlbum = input.nextLine();
				System.out.println("What is the genre of the album?");
				String genreText = input.nextLine();
				Genre genreAlbum = Genre.valueOf(genreText);
				System.out.println("What is the price of the album?");
				String txtPrice = input.nextLine();
				double priceAlbum = Double.parseDouble(txtPrice);
				
				boolean methodAnswer = model.addAlbum(nameAlbum, genreAlbum , priceAlbum, albumInterpreter);
				
				if(methodAnswer == true)
				{
					System.out.println("Your album was succesfully added to the jukebox!");
				}
				
				else
				{
					System.out.println("The album was not added to the jukebox :(");
				}
			}
			
			else if(response == 2)//Add a new song to an existing album
			{
				System.out.println("Please input the name of the album");
				String nameAlbum = input.nextLine();
				System.out.println("Please input the name of the song");
				String nameSong = input.nextLine();
				System.out.println("Please input the duration of the album");
				String txtDuration = input.nextLine();
				int durationSong = Integer.parseInt(txtDuration);
				
				boolean methodAnswer = model.addSong(nameSong, durationSong, nameAlbum);
				
				if(methodAnswer == true)
				{
					System.out.println("Your song was succesfully added to the album :)");
				}
				
				else
				{
					System.out.println("Your song could not be added to the album :(");
				}
				
			}
			
			else if(response == 3)//Add a new hit to the jukebox
			{
				System.out.println("Please input the name of the song");
				String nameSong = input.nextLine();
				System.out.println("Please input the name of the song's album");
				String nameAlbum = input.nextLine();
				
				boolean methodAnswer = model.addhit(nameSong, nameAlbum);
				
				if(methodAnswer == true)
				{
					System.out.println("Your song was successfully added to the jukebox's hits");
				}
			}
			
			else if(response == 4)//Search for an existing album
			{
				System.out.println("Please input the name of the album");
				String nameAlbum = input.nextLine();
				
				Album searchedAlbum = model.searchAlbum(nameAlbum);
				
				if(searchedAlbum == null)
				{
					System.out.println("We're sorry, but there is not an album with the name: "+ nameAlbum);
					
				}
				
				else
				{
					System.out.println("The album named " + nameAlbum + " has the following details:");
					System.out.println("\t a. Genre:" + searchedAlbum.getGenre());
					System.out.println("\t b. Price:" + searchedAlbum.getPrice());
					System.out.println("\t c. Number of Songs:" + searchedAlbum.getNumberOfExistingSongs());
					System.out.println("\t d. Interpreter: " + searchedAlbum.getInterpreter().getName());
					
				}
			}
		
			else if(response == 5)//Search for a song in an album
			{
				System.out.println("Please input the name of the album");
				String nameAlbum = input.nextLine();
				System.out.println("Please input the name of the song");
				String nameSong = input.nextLine();
				
				if(model.searchAlbum(nameAlbum) == null)
				{
					System.out.println("Sorry, but there is not an album with the name: "+ nameAlbum);
					
				}
				
				else 
				{
					if(model.searchAlbum(nameAlbum).searchSong(nameSong) != null)
					{
						System.out.println("The song" + nameSong + " in the album" + nameAlbum + "has been found");
					}
					
					else
					{
						System.out.println("The album exists but there is not a song with that name");
					}
				}
				
			}
			
			else if(response == 6)//Search for a hit in the jukebox by a name
			{
				System.out.println("Please input the name of the hit song");
				String nameSong = input.nextLine();
				
				if(model.searchHit(nameSong) != null)
				{
					System.out.println("The hit song " + nameSong + " has been found in the jukebox");
				}
				
				else
				{
					System.out.println("The song" + nameSong + " is not a hit in the jukebox");
				}
			}
			
			else if(response == 7)//Remove an album searching by its name
			{
				System.out.println("Please input the name of the album you would like to remove");
				String nameAlbum = input.nextLine();
				
				boolean methodAnswer = model.removeAlbum(nameAlbum);
				
				if(methodAnswer == false)
				{
					System.out.println("That album is not in the jukebox and cannot be removed");
				}
				
				else
				{
					System.out.println("The album" + nameAlbum + " was successfully removed from the jukebox");
				}
			}
			
			else if(response == 8)//Remove a song from an album, searching by the song's name and the album's name
			{
				System.out.println("Please input the name of the song's album you would like to remove");
				String nameAlbum = input.nextLine();
				System.out.println("Please input the name of the song you would like to remove");
				String nameSong = input.nextLine();
				
				if(model.searchAlbum(nameAlbum) == null)
				{
					System.out.println("Sorry, but there is not an album with the name: "+ nameAlbum);
					
				}
				
				else 
				{
					if(model.searchAlbum(nameAlbum).searchSong(nameSong) != null)
					{
						boolean methodAnswer = model.removeSongFromAlbum(nameSong, nameAlbum);
						
						if(methodAnswer == true)
						{
							System.out.println("The song" + nameSong +" has been removed from the album" + nameAlbum);
						}
					}
					
					else
					{
						System.out.println("The album exists but there is not a song with that name");
					}
				}
			
			}
			
			else if(response == 9)//Remove a hit by searching by its name
			{
				System.out.println("Please input the name of the hit song");
				String nameSong = input.nextLine();
				
				if(model.searchHit(nameSong) != null)
				{
					boolean methodAnswer = model.removeHit(nameSong);
					
					if(methodAnswer = true)
					{
						System.out.println("The hit song " + nameSong + " has been removed from the jukebox");
					}
				}
				
				else
				{
					System.out.println("The song" + nameSong + " is not a hit in the jukebox");
				}
			}
			
			else if(response == 10)//Get the most expensive album in the jukebox
			{
				 Album methodAnswer = model.getMostExpensiveAlbum();
				 
				 if(methodAnswer == null)
				 {
					 System.out.println("There are no albums in the jukebox yet");
				 }
				 else
				 {
					System.out.println("The most expensive album in the jukebox is" + methodAnswer);
				 }
			}
			
			else if(response == 11)//Get the least expensive album in the jukebox
			{
				 Album methodAnswer = model.getLeastExpensiveAlbum();
				 
				 if(methodAnswer == null)
				 {
					 System.out.println("There are no albums in the jukebox yet");
				 }
				 else
				 {
					System.out.println("The least expensive album in the jukebox is" + methodAnswer);
				 }
			}
			
			else if(response == 12)//Get the longest song of an album, searching by the name of the album
			{
				System.out.println("Please input the name of the album");
				String nameAlbum = input.nextLine();
				
				Album searchedAlbum = model.searchAlbum(nameAlbum);
				
				if(searchedAlbum == null)
				{
					System.out.println("That album is not in the jukebox");
				}
				
				else
				{
					System.out.println("The longest song of" + nameAlbum + "is" + searchedAlbum.getLongestSong());
				}
			}
			
			else if(response == 13)//Get the longest hit
			{
				Song longestHit = model.getLongestHit();
				
				 if(longestHit == null)
				 {
					 System.out.println("There are no hits in the jukebox yet");
				 }
				 else
				 {
					System.out.println("The longest hit in the jukebox is" + longestHit);
				 }
			}
			
			else if(response ==14)//Get the shortest hit in the jukebox 
			{
				Song shortestHit = model.getShortestHit();
				
				 if(shortestHit == null)
				 {
					 System.out.println("There are no hits in the jukebox yet");
				 }
				 else
				 {
					System.out.println("The shortest hit in the jukebox is" + shortestHit);
				 }
			}
			
			else if(response == 15)//Get the number of existing albums in the jukebox
			{
				int numberOfAlbums = model.getNumberOfExistingAlbums();
				
				if(numberOfAlbums == 0)
				{
					System.out.println("There are no albums in the jukebox");
				}
				
				else
				{
					System.out.println("There are " + numberOfAlbums + "in the jukebox");
				}
					
			}
			
			else if(response == 16)//Get the number of existing hits in the jukebox
			{
				int numberOfHits = model.getNumberOfExistingHits();
				
				if(numberOfHits == 0)
				{
					System.out.println("There are no hits in the jukebox");
				}
				
				else
				{
					System.out.println("There are " + numberOfHits + "in the jukebox");
				}
					
			}
		}
		
		input.close();
		
	}
}
