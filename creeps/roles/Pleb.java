package org.myScreeps.creeps.roles;


import def.screeps.Creep;
import def.screeps.Game;
import def.screeps.Source;
import jsweet.lang.Array;
import jsweet.lang.Object;
import org.myScreeps.creeps.interfaces.CreepInterface;
import org.parakoopa.screeps.api.Mapper;

import static def.screeps.Globals.*;
import static jsweet.util.Globals.$map;


/**
 * Created by andi on 29.11.16.
 */
public class Pleb implements CreepInterface {

    private Creep[] plebs=new Mapper<Creep>(Game.creeps).filter(
            creep -> creep.memory.$get("role")=="pleb"
    );

    public void makeMeMoney() {
        for (Creep creep: plebs) {
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
                creep.transfer(Game.spawns.$get("Overmind"),RESOURCE_ENERGY);
            }
        }
    }


    @Override
    public boolean checkPop() {
        return plebs.length<2;
    }

    @Override
    public void makeBabby() {
        if (checkPop()) {
            Game.spawns.$get("Overmind")
                    .createCreep(new String[]{WORK,CARRY,MOVE,MOVE},null,assignRole());
        }
    }

    @Override
    public Object assignRole() { //JSweet Object nicht Java Object
        return $map("role","pleb");
    }


}
