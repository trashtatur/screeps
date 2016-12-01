package org.myScreeps.creeps.brains;

import def.screeps.ConstructionSite;
import def.screeps.Creep;
import def.screeps.Source;
import org.myScreeps.creeps.interfaces.CreepRole;

import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */
public final class ConstructusBrain implements CreepRole {

    public static void workRoutine(Creep[] constructus) {

        for (Creep creep: constructus) {

            //JOBS
            if (creep.carry.energy == creep.carryCapacity) {
                creep.memory.$set("harvesting", false);
                creep.memory.$set("building", true);
                creep.say("now building");
            }

            if (creep.carry.energy == 0) {
                creep.memory.$set("harvesting", true);
                creep.memory.$set("building", false);
                creep.say("now harvesting");
            }
            //What to do in Roles
            if ((Boolean) creep.memory.$get("harvesting")) {
                Source[] sources=creep.room.find(FIND_SOURCES);
                if (creep.harvest(sources[0]) == ERR_NOT_IN_RANGE) {
                    creep.moveTo(sources[0].pos);
                } else {
                    creep.harvest(sources[0]);
                }
            }

            if ((Boolean) creep.memory.$get("building")) {
                ConstructionSite[] targets = creep.room.find(FIND_CONSTRUCTION_SITES);
                if (targets.length>0) {
                    if (creep.build(targets[0]) == ERR_NOT_IN_RANGE) {
                        creep.moveTo(targets[0].pos);
                    }
                }
            }
        }
    }
}
