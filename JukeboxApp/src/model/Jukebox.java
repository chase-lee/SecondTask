package model;

import java.util.ArrayList;

import model.Album.Genre;
import model.Interpreter.Region;

/**
 * Class that models a Jukebox
 * @author Pedro Guillermo Feijóo-García
 */
public class Jukebox 
{
	
	//--------------------------------------------------------------------------
	// Constants
	// -------------------------------------------------------------------------
	
	/**
	 * Constant that models the maximum possible number of top hits
	 */
	public final static int TOP_HITS = 10;
	
	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------
	
	/**
	 * Attribute that models the number of existing albums in the jukebox
	 */
	private int numberOfExistingAlbums;
	
	/**
	 * Attribute that models the number of existing hits in the jukebox
	 */
	private int numberOfExistingHits;
	
	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------
	
	/**
	 * Vector that models the albums in the jukebox
	 */
	private ArrayList<Album> albums;
	
	/**
	 * Array that models the albums in the jukebox
	 */
	private Song[] hits;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
     * Method that creates an object (instance) of the Jukebox class<br>
     * <b>post: </b>An instance of type Jukebox has been created<br>
     */
	public Jukebox()
	{
		numberOfExistingAlbums = 0;
		numberOfExistingHits = 0;
		hits = new Song[TOP_HITS];
		
		albums = new ArrayList<Album>();
	}
	
	/**
	 * Method that returns the number of existing albums<br>
	 * @return the number of existing albums
	 */
	public int getNumberOfExistingAlbums()
	{
		return numberOfExistingAlbums;
	}
	
	/**
	 * Method that returns the number of existing hits<br>
	 * @return the number of existing hits
	 */
	public int getNumberOfExistingHits()
	{
		return numberOfExistingHits;
	}
	
	/**
	 * Method that adds an album to the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been added to the jukebox.<br>
	 * @param pName name of the new album<br>
	 * @param genreAlbum genre of the new album<br>
	 * @param pPrice price of the new album. pPrice >= 0.0<br>
	 * @param pInterpreter interpreter of the new album. pInterpreter != null<br>
	 * @return true if the album is created. Otherwise it returns false
	 */
	public boolean addAlbum(String pName, ennumerators.Genre genreAlbum, double pPrice, Interpreter pInterpreter)
	{
		boolean response = false;
		Album existingAlbum = searchAlbum(pName);
		
		if(existingAlbum == null)
		{
			Album albumToAdd = new Album(pName, genreAlbum, pPrice, pInterpreter);
			albums.add(albumToAdd);
			response = true;
		}
		
		return response;
	}
	
	/**
	 * Method that searches for an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album it will look for. pName != null<br>
	 * @return the album if it exists. Otherwise null
	 */
	public Album searchAlbum(String pName)
	{
		Album response = null;
		
		for (int i = 0; i < albums.size(); i++) 
		{
			if(albums.get(i).getName() == pName)
			{
				response = albums.get(i);
			}
		}
		
		return response;
	}
	
	/**
	 * Method that adds a song to an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the jukebox.<br>
	 * @param pName name of the song to be added. pName != null<br>
	 * @param pDuration name of the song to be added. pDuration >= 0<br>
	 * @param pNameAlbum name of the album in which the song will be added. pNameAlbum != null<br>
	 * @return true if the song was added. Otherwise false
	 */
	public boolean addSong(String pName, int pDuration, String pNameAlbum)
	{
		boolean response = false;
		Album myAlbum = searchAlbum(pNameAlbum);
		
		if(myAlbum != null)
		{
			if(myAlbum.getNumberOfExistingSongs() < 12)
				{
					myAlbum.addSong(pName, pDuration);
				}
		}
		
		return response;
	}
	
	/**
	 * Method that returns the most expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the most expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getMostExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;
		double maxPrice = 0;
		
		for (int i = 0; i < albums.size(); i++) 
		{
			if(albums.get(i).getPrice() > maxPrice)
			{
				mostExpensiveAlbum = albums.get(i);
			}
		}
		
		return mostExpensiveAlbum;
	}
	
	/**
	 * Method that returns the least expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the least expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getLeastExpensiveAlbum()
	{
		Album leastExpensiveAlbum = albums.get(0);

		for (int i = 0; i < albums.size(); i++) 
		{
			if(albums.get(i).getPrice() < leastExpensiveAlbum.getPrice())
			{
				leastExpensiveAlbum = albums.get(i);
			}
		}
		
		return leastExpensiveAlbum;
	}
	
	/**
	 * Method that returns the longest song of an existing album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album of interest. pName != null<br>
	 * @return the longest song in the album in the jukebox. If there are no albums, it should return null
	 */
	public Song getLongestSongInAlbum(String pName)
	{
		Song longestSong = null;
		
		Album theAlbum = searchAlbum(pName);
		
		if(theAlbum != null)
		{
			longestSong = theAlbum.getLongestSong();
		}
		
		return longestSong;
	}
	
	/**
	 * Method that removes an album from the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been removed from the jukebox.<br>
	 * @param pName name of the album to remove. pName != null<br>
	 * @return true if the album was successfully removed. Otherwise false.
	 */
	public boolean removeAlbum(String pName)
	{
		boolean response = false;
		
		for (int i = 0; i < albums.size(); i++) 
		{
			if(albums.get(i).getName() == pName)
			{
				Album albumToRemove = albums.get(i);
				albums.set(i, albumToRemove);
				response = true;
			}
		}
		
		return response;
	}
	
	/**
	 * Method that removes a song from an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the jukebox.<br>
	 * @param pNameSong name of the song to remove. pNameSong != null<br>
	 * @param pNameAlbum name of the album to remove the song from. pNameAlbum != null<br>
	 * @return true if the song was successfully removed. Otherwise false.
	 */
	public boolean removeSongFromAlbum(String pNameSong, String pNameAlbum)
	{
		boolean response = false;
		for (int i = 0; i < albums.size(); i++) 
		{
			if(albums.get(i).getName() == pNameAlbum)
			{
				albums.get(i).removeSong(pNameSong);
				response = true;
			}
		}
		
		return response;
	}
	
	/**
	 * Method that searches for a hit in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @param pName The name of the hit. pName != null<br>
	 * @return the hit (type Song) if it exists. Otherwise it returns null
	 */
	public Song searchHit(String pName)
	{
		Song response = null;

		for (int i = 0; i < hits.length; i++) 
		{
			if (hits[i]!=null)
			{
				if (hits[i].getName() == pName)
				{
					response = hits[i];
				}
			}
		}
		
		return response;
	}
	
	/**
	 * Method that adds an existing song to the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the array of hits in the jukebox.<br>
	 * @param pNameSong name of the song that will be added to the hits array. pNameSong != null <br>
	 * @param pNameAlbum name of the album that has the song to be added to the array of hits. pNameAlbum != null <br>
	 * @return true if it was successfully added. Otherwise false
	 */
	public boolean addhit(String pNameSong, String pNameAlbum)
	{
		boolean response = false;
		
		Album myAlbum = searchAlbum(pNameAlbum);
		
		if(myAlbum != null)
		{
			Song hitToAdd = myAlbum.searchSong(pNameSong);
			if(hitToAdd != null)
				for (int i = 0; i < hits.length; i++) 
				{
					if (hits[i]!=null)
					{
						hits[i] = hitToAdd;
						response = true;
					}
				}
		}
		
		return response;
	}
	
	/**
	 * Method that removes a song from the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the array of hits in the jukebox.<br>
	 * @param pName name of the song to be removed. pName != null<br>
	 * @return true if the song was successfully removed from the array of hits. Otherwise false
	 */
	public boolean removeHit(String pName)
	{
		boolean response = false;
		
		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current.getName() == pName)
			{
			hits[i] = null;
			response = true;
			}
		}
		return response;
	}
	
	/**
	 * Method that returns the longest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the longest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getLongestHit()
	{
		Song longest = null;
		
		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current != null)
			{
				if(longest == null)
				{
					longest = current;
				}
				
				else if(current.getDuration() > longest.getDuration())
				{
					longest = current;
				}
			}
		}
		
		return longest;
	}
	
	/**
	 * Method that returns the shortest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the shortest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getShortestHit()
	{
		Song shortest = null;
		
		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];
			if(current != null)
			{
				if(shortest == null)
				{
					shortest = current;
				}
				
				else if(current.getDuration() < shortest.getDuration())
				{
					shortest = current;
				}
			}
		}
		return shortest;
	}
}
	

