package JBattlefield.ElementToPrint;

import JBattlefield.Model.RGBColor;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * Provides a String rapresentation of the coor, that is,
 * of the RGBColor class.
 */
public class ColorString implements StringOfElement<RGBColor> {

    @Override
    public String printOfElement(RGBColor element) {
        return "COLOR <" + element.getFirstByte() + "><" + element.getSecondByte() +
                "><" + element.getThirdByte() + ">";
    }
}
