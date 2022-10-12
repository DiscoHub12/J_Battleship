package JBattlefield.Model;

import java.util.Objects;

/**
 * This class provides a default implementation of the
 * I_Action interface. It allows to rapresent the concept
 * of hitting an opponent's position.
 */
public class Action implements I_Action{

    private final Player playerAction;
    public Action(Player player) {
        this.playerAction = player;
    }

   @Override
    public void hitPosition(Player player, Coordinate tmp) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(tmp);
        if(!player.areShipsPresents())
            throw new IllegalArgumentException("The game are finished. Player: " + player.getName() + "lost the Battle.");
        if(this.playerAction.getDefaultBattlePlane().hitPosition().containsKey(tmp))
            throw new IllegalArgumentException("Position already fired.");
        Ship s = player.getBattlefield().getShipInThisPosition(tmp);
        partsRemoving(s, player, tmp);
    }

    private boolean checkShipDied(Player player, Coordinate tmp){
        Ship s = player.getBattlefield().getShipInThisPosition(tmp);
        if(s != null) {
            return !player.getBattlefield().containsShip(s);
        }
        return false;
    }

    private void partsRemoving(Ship s, Player player, Coordinate tmp){
        int count = 0;
        if(s != null){
            player.getBattlefield().deleteOnePosition(tmp);
            count = 1;
        }else this.playerAction.getDefaultBattlePlane().hitPosition().put(tmp, false);
        if(count == 1){
            this.playerAction.getDefaultBattlePlane().hitPosition().put(tmp, true);
            if(!player.getBattlefield().containsShip(s)){
                this.playerAction.getDefaultBattlePlane().listDeadShips().add(s);
                player.removeShip(s);
            }
        }
    }
}
