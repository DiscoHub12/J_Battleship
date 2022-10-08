package JBattlefield.Model;

/**
 * This interface provides methods necessary to rapresent
 * the concept of Color (RGB color) , in fact it will
 * be implemented by the RGBColor class.
 */
public interface Color {

    /**
     * Get method to request the first byte
     * of the RGBColor.
     *
     * @return the first byte of RGBColor.
     */
    int getFirstByte();

    /**
     * Set method to set the first byte of
     * the RGBColor.
     *
     * @param red the first byte of RGBColor.
     * @throws IllegalArgumentException if the first byte is less than 0
     *                                  or greater than 255.
     */
    void setFirstByte(int red);

    /**
     * Get method to request the second byte
     * of the RGBColor.
     *
     * @return the second byte of the RGBColor.
     */
    int getSecondByte();

    /**
     * Set method to set the second byte of
     * the RGBColor.
     *
     * @param green the second byte of RGBColor.
     * @throws IllegalArgumentException if the second byte is less than 0
     *                                  * or greater than 255.
     */
    void setSecondByte(int green);

    /**
     * Get method to request the third byte
     * of the RGBColor.
     *
     * @return the third byte of RGBColor.
     */
    int getThirdByte();

    /**
     * Set method to set the third byte of
     * the RGBColor
     *
     * @param blue the third byte of RGBColor.
     * @throws IllegalArgumentException if the third byte is less than 0
     *                                  * or greater than 255.
     */
    void setThirdByte(int blue);

    /**
     * The equals method of a RGBColor class simply
     * checks if twho RGBColor are equal, so if they have the
     * same first, second and third byte.
     *
     * @param obj the Object to compare.
     * @return true if the two RGBColor are equals, false otherwise.
     */
    boolean equals(Object obj);
}

