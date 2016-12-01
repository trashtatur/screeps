package org.myScreeps;

import def.screeps.Game;
import def.screeps.Memory;
import org.parakoopa.screeps.api.Mapper;

/**
 * Created by andi on 29.11.16.
 */
public class MainGame {
    public void loop() {

        //Memory aufräumen
        String [] creepNames= new Mapper(Game.creeps).getKeys();
        for (String creepName : creepNames ) {
            if (Game.creeps.$get(creepName)==null) {
                Memory.creeps.$delete(creepName);
                System.out.println("Clearing out the dead body of "+creepName);
            }

        }

    }
}
