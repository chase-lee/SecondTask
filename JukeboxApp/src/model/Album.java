package model;

import java.util.ArrayList;

import ennumerators.Genre;

/**
 * TODO Complete documentation - check Jukebox class
 */
public class Album 
{
	//--------------------------------------------------------------------------
	// Constants
	// -------------------------------------------------------------------------
	/**
	 * Constant that models the number of maximum possible songs an album can have
	 */
	public static final int NUMBER_SONGS = 12;
	
	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------
	/**
	 * Attribute that models the name of an album
	 */
	private String name;
	
	/**
	 * Attribute that models the double price of an album
	 */
	private double price;
	
	/**
	 * Attribute that models the integer number of existing songs in the album
	 */
	private int numberOfExistingSongs;
	
	/**
	 * Attribute that models the interpreter of the album
	 */
	private Interpreter interpreter;
	
	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------
	
	/**
	 * Enumeration that defines what genre the album can be
	 */
	private ennumerators.Genre genre;
	
	enum Genre
	{
		GOSPEL, SALSA, HIPHOP, RNB, CLASSICAL
	}
	
	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------
	
	/**
	 * Array that models the songs in the album
	 */
	private ArrayList<Song> songs;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	/**
	 * Method that creates an object of the class Album<br>
	 * <b>pre: </b>An interpreter of class Interpreter already exists<br>
	 * <b>post: </b>An object of class Album has been created<br>
	 * @param pName is the name of the album. pName != null<br>
	 * @param genreAlbum is the genre of the album. pGenre != null<br>
	 * @param pPrice is the double price of the album. pPrice != null<br>
	 * @param pInterpreter is the interpreter of the album
	 */
	public Album(String pName, ennumerators.Genre genreAlbum, double pPrice, Interpreter pInterpreter)
	{
		name = pName;
		genre = genreAlbum;
		price = pPrice;
		interpreter = pInterpreter;
		numberOfExistingSongs = 0;
		
		songs = new ArrayList<Song>();
	}
	
	/**
	 * Method that adds a song to the album<br>
	 * <b>pre: </b>The array of songs has already been initialized<br>	
	 * <b>post: </b>The song is added to the album<br>
	 * @param pName the name of the song. pName != null<br>
	 * @param pDuration the integer duration of the song. pDuration != null<br>
	 * @return true if the song was added to the album. Otherwise false
	 */
	public boolean addSong(String pName, int pDuration)
	{
		boolean response = false;
		
		Song existingSong = searchSong(pName);
		
		if(existingSong == null)
		{
			Song song = new Song(pName, pDuration);
			songs.add(song);
			numberOfExistingSongs++;
		}
		
		return response;
	}
	
	/**
	 * Method that searches for a song in the album<br>
	 * <b>pre </b>The array of songs has already been initialized<br>
	 * @param pName The name of the song to search for. pName != null<br>
	 * @return the song that was searched for. Otherwise returns null
	 */
	public Song searchSong(String pName)
	{
		Song response = null;
		
		for (int i = 0; i < songs.size() && response == null; i++) 
		{
			Song currentSong = songs.get(i);
			if(currentSong.getName().equals(pName))
			{
				response = currentSong;
			}
		}
		
		return response;
	}
	
	/**
	 * Method that returns the longest song in the album
	 * <b>pre: </b>The array of songs has already been initialized<br>
	 * @return the longest song of the array of songs. Return null if there are no songs in the album
	 */
	public Song getLongestSong()
	{
		Song longest = null;
		
		for (int i = 0; i < songs.size(); i++) 
		{
			Song current = songs.get(i);
			if(longest == null)
			{
				longest = current;
			}
			else if(current.getDuration()>longest.getDuration())
			{
				longest = current;
			}
		}
		
		return longest;
	}
	
	/**
	 * Method that removes a song from the album<br>
	 * <b>pre: </b>The array of songs has already been initialized<br>
	 * <b>post: </b>The song has been removed from the album<br>
	 * @param pName the name of the song to remove. pName != null<br>
	 * @return true if the song was successfully remove from the array of songs. False otherwise
	 */
	public boolean removeSong(String pName)
	{
		boolean response = false;
		
		for (int i = 0; i < songs.size() && response == false; i++) 
		{
			Song current = songs.get(i);
			if(current.getName().equals(pName))
			{
				songs.remove(i);
				response = true;
			}
		}
		
		return response;
	}
	
	/**
	 * Method that returns the name of the album
	 * @return the name of the album
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Method that returns the genre of the album
	 * @return the genre of he album
	 */
	public ennumerators.Genre getGenre() 
	{
		return genre;
	}

	/**
	 * Method that returns the price of the album
	 * @return the double price of the album
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * Method that returns the number of existing songs in the album
	 * @return the integer number of existing songs in the album
	 */
	public int getNumberOfExistingSongs() 
	{
		return numberOfExistingSongs;
	}

	/**
	 * Method that returns the interpreter of the album
	 * @return the interpreter of the album
	 */
	public Interpreter getInterpreter() 
	{
		return interpreter;
	}
	
	
}
