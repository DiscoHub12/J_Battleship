package JBattlefield.Model;

@FunctionalInterface
public interface I_Action {

    /**
     * This method allow s a Player to hit a
     * certain Position (Coordinate). If in the
     * opponent's Battle Area it hits a Ships, this
     * will be taken into consideration, both by the
     * opponent, therefore the Ship will be
     * deteriorated, and by the Player who must
     * save himsel the Coordinate he has just hit and a boolean
     * value that indicates whether the fired position has
     * taken a Ship or not.
     * If a Player hits the last position (Coordinate) of the Ship,
     * the Ship is sunk, so this too determines a
     * factor both of the Player (who must take into Account the
     * Sunken Ship) and the opponent who must eliminate his Ship inside
     * the Area.
     *
     * @param tmp the Position that the Player wishes to hit.
     * @throws NullPointerException if the player or tmp is null.
     */
    void hitPosition(Player player, Coordinate tmp);

}
