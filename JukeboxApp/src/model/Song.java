package model;

/**
 * Class that models a Song
 * @author Chase Lee
 */
public class Song 
{
	
	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------
	
	/**
	 * Attribute that models the name of the song
	 */
	private String name;
	
	/**
	 * Attribute that models in integer duration of a song
	 */
	private int duration;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * Method that allows you to create a new object of the Song class with the specified parameters<br>
	 * <b>post: </b>An object of class Song has been created<br>
	 * @param pName is the name of the song that is being created. pName != null <br>
	 * @param pDuration is the duration of the song that is being created. pDuration != null<br>
	 */
	public Song(String pName, int pDuration)
	{
		name = pName;
		duration = pDuration;
	}

	/**
	 * Method that returns the name of the song<br>
	 * @return the name of the song
	 */
	public String getName() 
	{
		return name;
	}


	/**
	 * Method that returns the integer duration of the song<br>
	 * @return the duration of the song
	 */
	public int getDuration() 
	{
		return duration;
	}
	
	
	
}
