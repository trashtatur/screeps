package org.myScreeps.creeps.brains;


import def.screeps.Creep;
import def.screeps.Source;
import def.screeps.Structure;
import def.screeps.StructureSpawn;

import org.myScreeps.creeps.interfaces.CreepRole;
import org.parakoopa.screeps.api.Helper;

import static def.screeps.Globals.*;


/**
 * Created by andi on 29.11.16.
 */
public class PlebejusBrain implements CreepRole {


    public void workRoutine(Creep[] plebejus) {

        /*
        TODO Need to rewrite the Routine so that only one worker harvests one source.
        TODO Their Template needs an Update! They need to harvest more efficiently.
         */

        for (Creep creep: plebejus) {


            if (creep.carry.energy<creep.carryCapacity) {
                Source[] sources=creep.room.find(FIND_SOURCES);
                if (creep.harvest(sources[0])==ERR_NOT_IN_RANGE) {
                    creep.moveTo(sources[0].pos);
                }
                else {
                    creep.harvest(sources[0]);
                }
            }
            else {
                Structure[] targets = creep.room.find(FIND_STRUCTURES, Helper.findFilter(
                        (Structure structure) -> (structure.structureType == STRUCTURE_SPAWN ||
                                structure.structureType == STRUCTURE_EXTENSION) &&
                                ((StructureSpawn)structure).energy < ((StructureSpawn)structure).energyCapacity
                ));
                if (creep.transfer(targets[0],RESOURCE_ENERGY)==ERR_NOT_IN_RANGE) {
                    creep.moveTo(targets[0].pos);
                }
            }
        }
    }
}
