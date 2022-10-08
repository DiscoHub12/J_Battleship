package JBattlefield.ElementToPrint;

import JBattlefield.Model.Battlefield;
import JBattlefield.Model.Ship;

import java.util.Objects;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * Provides a String rapresentation of particular Payer's
 * Battlefield. In fact, it will rapresent the data of the
 * Battlefield class, therefore its size, color and more , plus
 * the Ships inside it.
 */
public class BattlefieldString implements StringOfElement<Battlefield> {

    /**
     * This Object is needed to provide a String
     * rapresentation of Ships, offered by the
     * ShipString class.
     */
    private final ShipString stringShip = new ShipString();

    /**
     * This Object is needed to provide a String
     * rapresentation of the color (RGBColor), offered
     * by the ColorString class.
     */
    private final ColorString colorString = new ColorString();


    @Override
    public String printOfElement(Battlefield element) {
        Objects.requireNonNull(element);
        return "\nBattlefield: " +
                "\nSIZE <" + element.getBaseHeight() + "><" + element.getBaseHeight() + "><" + colorString.printOfElement(element.getColorArea()) +
                printAllShipsInside(element);
    }

    /**
     * This method allows you to return a String
     * containing all Ships within the Battlefield.
     *
     * @param element the Battlefield camp.
     * @return a String containing all Ships inside the Battlefield.
     */
    private String printAllShipsInside(Battlefield element) {
        String tmp = "";
        int count = 1;
        for (Ship s : element.getShipInside()) {
            tmp += "\nShip " + count + ": " + stringShip.printOfElement(s);
            count++;
        }
        return tmp;
    }
}
