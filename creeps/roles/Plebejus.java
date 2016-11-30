package org.myScreeps.creeps.roles;





import def.screeps.Creep;
import def.screeps.Game;
import def.screeps.Source;
import def.screeps.Structure;
import def.screeps.StructureSpawn;

import org.myScreeps.creeps.RoleCollection;
import org.myScreeps.creeps.TemplateCollection;
import org.myScreeps.creeps.interfaces.CreepInterface;
import org.parakoopa.screeps.api.Helper;
import org.parakoopa.screeps.api.Mapper;

import static def.screeps.Globals.*;


/**
 * Created by andi on 29.11.16.
 */
public class Plebejus implements CreepInterface {

    private Creep[] plebejus =new Mapper<Creep>(Game.creeps).filter(
            creep -> creep.memory.$get("role")=="pleb"
    );

    public void makeMeMoney() {
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
                    creep.moveTo(Game.spawns.$get("Overmind").pos);
                }
            }
        }
    }

    @Override
    public boolean checkPop() {
        return plebejus.length<2;
    }

    @Override
    public void makeBabby() {
        if (checkPop()) {
            Game.spawns.$get("Overmind")
                    .createCreep(TemplateCollection.WORKER.setTemplate(),null, RoleCollection.PLEBEJUS.setRole());
            System.out.println("Made new Pleb");
        }
    }


}
