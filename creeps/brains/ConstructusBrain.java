package org.myScreeps.creeps.brains;


import def.screeps.ConstructionSite;
import def.screeps.Creep;

import org.myScreeps.creeps.GlaDoS;
import org.myScreeps.creeps.interfaces.CreepRole;


import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */
public class ConstructusBrain implements CreepRole  {

    public void workRoutine(Creep[] constructus) {


        for (Creep creep: constructus) {

            //Job Switcher, that defines what the Creep should do in which state.
            if (creep.carry.energy == creep.carryCapacity) {
                creep.memory.$set("harvesting", false);
                creep.memory.$set("building", true);
                creep.say("building");
            }

            if (creep.carry.energy == 0) {
                creep.memory.$set("harvesting", true);
                creep.memory.$set("building", false);
                creep.say("harvesting");
            }
            //What to do in Roles
            Braniac.leechOrHarvest(creep); // Decides if the Creep should leech energy from Spawn or harvest himself

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
    //Checks if there are things to build at the Moment. if there are no Construction Sites, the Constructus Creeps will commit suicide.
    public void suicideCheck(Creep [] constructus, GlaDoS glaDoS) {
        if (glaDoS.checkConstrSites().length==0) {
            for (Creep creep: constructus) {
                creep.say("Signing Off");
                creep.suicide();
            }
        }
    }




}
