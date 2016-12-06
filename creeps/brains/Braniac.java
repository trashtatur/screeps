package org.myScreeps.creeps.brains;




import def.screeps.Source;
import def.screeps.StructureExtension;
import def.screeps.StructureSpawn;
import org.parakoopa.screeps.api.Helper;
import org.parakoopa.screeps.api.Mapper;
import def.screeps.Creep;
import def.screeps.Game;
import def.screeps.Structure;




import static def.screeps.CONSTRUCTION_COST.spawn;
import static def.screeps.Globals.*;
/**
 * Created by Andi on 03.12.2016.
 */
public final class Braniac {
    /*
    Method Collection for all the things that multiple Creep Brains need to do.
    All these are collected in this "Super Brain" Class that then just determines
    the solution for them.
     */

    public static void leechOrHarvest(Creep creep) {

        if ((Boolean) creep.memory.$get("harvesting")) {
            //If there are 3 or more Creeps with Role of Plebejus
            if (new Mapper<Creep>(Game.creeps).filter(plebcreep -> plebcreep.memory.$get("role")=="plebejus").length>=3) {
                StructureExtension[] targets = creep.room.find(FIND_STRUCTURES,Helper.findFilter(
                        (Structure structure) -> (structure.structureType==STRUCTURE_EXTENSION
                        )));

                //Use the extensions to get Energy if they are filled to not clog the Harvesting Source
                if ( targets[0].transferEnergy(creep,50)==ERR_NOT_IN_RANGE && targets[0].energy!=0){
                    creep.say("Extleech");
                    //Move Creep to extension and fill him up with energy
                    creep.moveTo(targets[0].pos);
                }
                //If all extensions are empty, leech energy from spawn
                else if (targets.length==0) {
                        if (Game.spawns.$get("Overmind").transferEnergy(creep,50)==ERR_NOT_IN_RANGE) {
                            creep.say("Spawnleech");
                            creep.moveTo(Game.spawns.$get("Overmind").pos);
                        }
                }

            }
            //Else do a normal harvesting routine at the source
            else {
                Source[] sources = creep.room.find(FIND_SOURCES);
                if (creep.harvest(sources[0]) == ERR_NOT_IN_RANGE) {
                    creep.moveTo(sources[0].pos);
                }
                else {
                    creep.harvest(sources[0]);
                }
            }
        }


    }
}
