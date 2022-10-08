package JBattlefield.Model;

/**
 * This class provides a default implementation of the
 * Color interface. It aims to rapresent the concept of
 * RGB color, in fact this class has three attributes,
 * the first, second and third byte of an RGB color.
 */
public class RGBColor implements Color {

    /**
     * This attributes indicates the first
     * byte for this RGBColor.
     */
    private int firstByte;

    /**
     * This attribute indicate the second
     * byte for this RGBColor.
     */
    private int secondByte;

    /**
     * This attribute indicate the third
     * byte for this RGBColor.
     */
    private int thirdByte;

    /**
     * Constructor for RGBColor class, that create
     * a new RGBColor by given an firs, second and third
     * byte. Calls the set methods for this attributes that
     * checks the correct value for this byte.
     *
     * @param red   the first byte for this RGBColor.
     * @param green the second byte for this RGBColor.
     * @param blue  the third byte for this RGBColor.
     */
    public RGBColor(int red, int green, int blue) {
        this.setFirstByte(red);
        this.setSecondByte(green);
        this.setThirdByte(blue);
    }

    @Override
    public int getFirstByte() {
        return this.firstByte;
    }

    @Override
    public void setFirstByte(int red) {
        if (!checkValue(red))
            throw new IllegalArgumentException("Illegal first byte for this RGBColor.");
        this.firstByte = red;
    }

    @Override
    public int getSecondByte() {
        return this.secondByte;
    }

    @Override
    public void setSecondByte(int green) {
        if (!checkValue(green))
            throw new IllegalArgumentException("Illegal second byte for this RGBColor,");
        this.secondByte = green;
    }

    @Override
    public int getThirdByte() {
        return this.thirdByte;
    }

    @Override
    public void setThirdByte(int blue) {
        if (!checkValue(blue))
            throw new IllegalArgumentException("Illegal third byte for this RGBColor.");
        this.thirdByte = blue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof RGBColor tmp) {
            return tmp.getFirstByte() == this.getFirstByte() && tmp.getSecondByte() == this.getSecondByte() && tmp.getThirdByte() == this.getThirdByte();
        }
        return false;
    }

    /**
     * This method allows to reduce the duplicate code,
     * as it is a check that should be done for the
     * three byte of the RGBColor.
     * In fact, it is called in the set methods,
     * and checks that the value is a greater than 0 and
     * less than 255. As an RGB color, has value in range from
     * 0 to 255.
     *
     * @param n the value to check that respects the range.
     * @return true if the value is in a range from 0 to 255,
     * false otherwise.
     */
    private boolean checkValue(int n) {
        return n >= 0 && n <= 255;
    }
}

