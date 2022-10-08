package JBattlefield.ElementToPrint;

import JBattlefield.Model.Player;

/**
 * This class provides a default implementation of the
 * StringOfElement funcitonal interface.
 * In fact, this class will rapresent the Battlefield and
 * the DefaultBattlePlane of a particular Player.
 */
public class PlayerString implements StringOfElement<Player> {

    /**
     * This Object is needed to provide a String
     * rapresentation of Battlefield, offered by the
     * BattlefieldSrtring class.
     */
    private final BattlefieldString stringBattle = new BattlefieldString();

    /**
     * This Object is needed to provide a String rapresentation
     * of DefaultBattlePlane, offered by the DefaultBattleString
     * class.
     */
    private final DefaultBattleString defaultBattle = new DefaultBattleString();


    @Override
    public String printOfElement(Player element) {
        return "\nPlayer " + element.getName() + "\n" + stringBattle.printOfElement(element.getBattlefield()) +
                defaultBattle.printOfElement(element.getDefaultBattlePlane());
    }
}
