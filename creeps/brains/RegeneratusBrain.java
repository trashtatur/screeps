package org.myScreeps.creeps.brains;

import def.screeps.Creep;
import def.screeps.Structure;
import org.myScreeps.creeps.interfaces.CreepRole;
import org.parakoopa.screeps.api.Helper;

import static def.screeps.Globals.ERR_NOT_IN_RANGE;
import static def.screeps.Globals.FIND_STRUCTURES;

/**
 * Created by Andi on 06.12.2016.
 */
public class RegeneratusBrain implements CreepRole {


    public void workRoutine(Creep[] creeps) {
        for (Creep creep: creeps) {
            //Job Switcher, that defines what the Creep should do in which state.
            if (creep.carry.energy==creep.carryCapacity) {
                creep.memory.$set("harvesting",false);
                creep.memory.$set("repairing",true);
                creep.say("repairing");
            }

            if (creep.carry.energy==0) {
                creep.memory.$set("harvesting",true);
                creep.memory.$set("repairing",false);
                creep.say("harvesting");
            }

            //What to do in Roles
            Braniac.leechOrHarvest(creep); // Decides if the Creep should leech energy from Spawn or harvest himself

            if ((Boolean) creep.memory.$get("repairing")) {
                Structure[] target=creep.room.find(FIND_STRUCTURES, Helper.findFilter(
                        (Structure structure) -> structure.hitsMax>structure.hits
                ));
                if (creep.repair(target[0])==ERR_NOT_IN_RANGE) {
                    creep.moveTo(target[0].pos);
                }
            }


        }



    }

}
