package org.myScreeps.creeps.brains;

import def.screeps.Creep;
import def.screeps.Source;
import def.screeps.Structure;
import def.screeps.StructureSpawn;
import org.myScreeps.creeps.interfaces.CreepRole;
import org.parakoopa.screeps.api.Helper;


import static def.screeps.Globals.*;

/**
 * Created by andi on 30.11.16.
 */
public class OptimusBrain implements CreepRole {

    public void workRoutine(Creep[] optimus) {

        for (Creep creep: optimus) {
            Source[] sources = creep.room.find(FIND_SOURCES);

            //Job Switcher, that defines what the Creep should do in which state.
            if (creep.carry.energy==creep.carryCapacity) {
                creep.memory.$set("harvesting",false);
                creep.memory.$set("upgrading",true);
                creep.say("upgrading");
            }

            if (creep.carry.energy==0) {
                creep.memory.$set("harvesting",true);
                creep.memory.$set("upgrading",false);
                creep.say("harvesting");
            }
            //What to do in Roles
            Braniac.leechOrHarvest(creep); // Decides if the Creep should leech energy from Spawn or harvest himself

            if ((Boolean) creep.memory.$get("upgrading")) {


                if (creep.upgradeController(creep.room.controller)==ERR_NOT_IN_RANGE) {
                    creep.moveTo(creep.room.controller.pos);
                }
            }


        }
    }


}
