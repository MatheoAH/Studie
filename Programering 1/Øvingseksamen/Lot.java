/**
 * Represents a property (lot) in a Norwegian municipality.
 *
 * <p>A property is uniquely identified by the combination of municipality number,
 * lot number (gnr) and section number (bnr), written on the format
 * {@code municipalityNumber-lotNumber/sectionNumber}, e.g. {@code 1445-77/631}.</p>
 *
 * <p><b>Choice of mutator methods:</b> Only the name of the property and the name of
 * the owner can be changed after the object is created. A property can be sold, so
 * the owner must be changeable, and a property can be given a new name (or a name
 * for the first time, since not all properties have one). Municipality number,
 * municipality name, lot number and section number together form the unique ID of the
 * property, and the area is a physical attribute of the lot. These should therefore
 * never change, and the fields are declared {@code final} without any mutator methods.</p>
 *
 * @author MatheoHammer
 * @version 1.0
 */
public class Lot {
    /** The municipality number, from 101 to 5054. */
    private final int municipalityNumber;
    /** The name of the municipality. */
    private final String municipalityName;
    /** The lot number (gnr). */
    private final int lotNumber;
    /** The section number (bnr). */
    private final int sectionNumber;
    /** The name of the property, empty if the property has no name. */
    private String name;
    /** The area of the property in square meters. */
    private final double area;
    /** The name of the owner of the property. */
    private String nameOfOwner;

    /**
     * Creates a new property.
     *
     * @param municipalityNumber the municipality number, from 101 (Halden) to 5054 (Indre Fosen)
     * @param municipalityName the name of the municipality
     * @param lotNumber the lot number (gnr), must be a positive number
     * @param sectionNumber the section number (bnr), must be a positive number
     * @param name the name of the property, may be an empty string if the property has no name
     * @param area the area of the property in square meters, must be a positive number
     * @param nameOfOwner the name of the owner of the property
     * @throws IllegalArgumentException if lot number, section number or area is not positive,
     *                                  or if the municipality number is outside 101-5054
     */
    public Lot(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner){
        if (lotNumber <= 0 || sectionNumber <= 0 || area <= 0) {
            throw new IllegalArgumentException("Lot number, section number, and area must be positive.");
        }
        if(municipalityNumber < 101 || municipalityNumber > 5054){
            throw new IllegalArgumentException("Municipality number must be between 101 and 5054");
        }
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Returns the municipality number of the property.
     *
     * @return the municipality number
     */
    public int getMunicipalityNumber() {return municipalityNumber;}

    /**
     * Returns the name of the municipality the property is located in.
     *
     * @return the municipality name
     */
    public String getMunicipalityName() {return municipalityName;}

    /**
     * Returns the lot number (gnr) of the property.
     *
     * @return the lot number
     */
    public int getLotNumber() {return lotNumber;}

    /**
     * Returns the section number (bnr) of the property.
     *
     * @return the section number
     */
    public int getSectionNumber() {return sectionNumber;}

    /**
     * Returns the name of the property.
     *
     * @return the name of the property, or an empty string if the property has no name
     */
    public String getName() {return name;}

    /**
     * Returns the area of the property.
     *
     * @return the area in square meters
     */
    public double getArea() {return area;}

    /**
     * Returns the name of the owner of the property.
     *
     * @return the name of the owner
     */
    public String getNameOfOwner() {return nameOfOwner;}

    /**
     * Sets a new name for the property.
     *
     * @param name the new name of the property, may be an empty string
     */
    public void setName(String name) {this.name = name;}

    /**
     * Sets a new owner of the property, e.g. when the property is sold.
     *
     * @param nameOfOwner the name of the new owner
     */
    public void setNameOfOwner(String nameOfOwner) {this.nameOfOwner = nameOfOwner;}

    /**
     * Returns the unique ID of the property on the format
     * {@code municipalityNumber-lotNumber/sectionNumber}, e.g. {@code 1445-54/73}.
     *
     * @return the unique ID of the property as a string
     */
    public String getMuniLotSecNr() {
        return municipalityNumber +"-"+ lotNumber +"/"+sectionNumber;
    }

    /**
     * Returns a one-line text representation of the property, containing its ID,
     * municipality name, property name, area and owner.
     *
     * @return the property as a formatted string
     */
    @Override
    public String toString(){
        return String.format("%-10s, %-10s, %-10s, %-10s, %-10s", getMuniLotSecNr(),getMunicipalityName(), getName(), getArea(), getNameOfOwner());
    }

}
