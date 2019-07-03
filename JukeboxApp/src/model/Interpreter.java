package model;

import ennumerators.Region;

/**
 * Class that modles the Interpreter
 * @author Chase Lee
 */
public class Interpreter
{
	
	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------
	
	/**
	 * Attribute that models the name of the interpreter
	 */
	private String name;
	
	/**
	 * Attribute that models the surname of the interpreter
	 */
	private String surname;
	
	/**
	 * Attribute that models the integer age of the interpreter
	 */
	private int age;
	
	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------
	
	/**
	 * Enumeration that creates a class called region and fills it with each continent
	 */
	private ennumerators.Region region;
	
	enum Region
	{
		NORTH_AMERICA, SOUTH_AMERICA, EUROPE, AFRICA, ASIA, AUSTRALIA
	}

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * Method that allows you to create objects of the Interpreter class<br>
	 * <b>pre: </b>A class Region has already been created and enumerated<br>
	 * <b>post: </b>An object of class Interpreter has been created<br>
	 * @param pName is the name of the Interpreter. pName != null<br>
	 * @param pSurname is the surname of the Interpreter. pSurname != null<br>
	 * @param pAge is the integer age of the Interpreter. pAge != null<br>
	 * @param regionInterpreter is the enumerated region the Interpreter is from. pRegion != null
	 */
	public Interpreter(String pName, String pSurname, int pAge, ennumerators.Region regionInterpreter)
	{
		name = pName;
		surname = pSurname;
		age = pAge;
		region = regionInterpreter;
	}

	
	/**
	 * Method that returns the name of the Interpreter<br>
	 * @return the name of the Interpreter
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method that returns the surname of the Interpreter<br>
	 * @return the surname of the Interpreter
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Method that returns the integer age of the Interpreter<br>
	 * @return the age of the Interpreter
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Method that returns the region of the Interpreter<br>
	 * @return the region the Interpreter is from
	 */
	public ennumerators.Region getRegion() {
		return region;
	}
	
	
}
