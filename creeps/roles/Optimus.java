package org.myScreeps.creeps.roles;

import def.screeps.Creep;
import def.screeps.Game;
import def.screeps.Source;
import jsweet.lang.Object;
import org.myScreeps.creeps.RoleCollection;
import org.myScreeps.creeps.TemplateCollection;
import org.myScreeps.creeps.interfaces.CreepInterface;
import org.parakoopa.screeps.api.Mapper;

import static def.screeps.Globals.*;

/**
 * Created by andi on 30.11.16.
 */
public class Optimus implements CreepInterface {

    private Creep[] optimus=new Mapper<Creep>(Game.creeps).filter(
            creep -> creep.memory.$get("role")=="optimus"
    );


    public void gatherAndUpgrade() {
        for (Creep creep: optimus) {
            Source[] sources = creep.room.find(FIND_SOURCES);

            //ROLES
            if (creep.carry.energy==creep.carryCapacity) {
                creep.memory.$set("harvesting",false);
                creep.memory.$set("upgrading",true);
                creep.say("now upgrading");
            }

            if (creep.carry.energy==0) {
                creep.memory.$set("harvesting",true);
                creep.memory.$set("upgrading",false);
                creep.say("now harvesting");
            }
            //What to do in Roles
            if ((Boolean) creep.memory.$get("harvesting")) {
                if (creep.harvest(sources[0])==ERR_NOT_IN_RANGE) {
                    creep.moveTo(sources[0].pos);
                }
                else {
                    creep.harvest(sources[0]);
                }
            }

            if ((Boolean) creep.memory.$get("upgrading")) {
                if (creep.upgradeController(creep.room.controller)==ERR_NOT_IN_RANGE) {
                    creep.moveTo(creep.room.controller.pos);
                }
            }


        }
    }


    @Override
    public boolean checkPop() {
        return optimus.length<2;
    }

    @Override
    public void makeBabby() {
        if (checkPop()) {
            Game.spawns.$get("Overmind")
                    .createCreep(TemplateCollection.WORKER.setTemplate(), null,RoleCollection.OPTIMUS.setRole());
        }

    }

}
