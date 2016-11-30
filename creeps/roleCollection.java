package org.myScreeps.creeps;

import def.screeps.Game;

import static def.screeps.Globals.*;
/**
 * Created by andi on 30.11.16.
 */
public final class roleCollection {
    public static void setRoles() {
        Game.spawns.$get("Overmind").memory.$set("rolePleb",new String[]{WORK,MOVE,MOVE,CARRY});
    }
}
