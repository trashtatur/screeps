package org.myScreeps.creeps;

import def.screeps.ConstructionSite;
import def.screeps.Creep;
import def.screeps.Game;
import def.screeps.Memory;
import org.myScreeps.creeps.collections.RoleCollection;
import org.myScreeps.creeps.collections.TemplateCollection;
import org.parakoopa.screeps.api.Mapper;


import static def.screeps.Globals.FIND_CONSTRUCTION_SITES;

/**
 * Created by Andi on 30.11.2016.
 */
public class GlaDoS {

    //TODO As soon as the if clause from constructus is outsourced remoge this Array.
    private  Mapper<Creep> allCreeps=new Mapper<Creep>(Game.creeps);

    public void plebBirthSubroutine() {
        //Create Plebejans
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.HARVESTER.getTemplate(),
                    null,
                    RoleCollection.PLEBEJUS.getRole()
            );
    }
    public void optimusBirthSubroutine() {
        //Create Optimus'

            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.HARVESTER.getTemplate(),
                    null,
                    RoleCollection.OPTIMUS.getRole()
            );
    }

    public void regeneratusBirthSubroutine() {
        //Create Regeneratus'
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.HARVESTER.getTemplate(),
                    null,
                    RoleCollection.REGENERATUS.getRole()
            );
    }

    public void constructusBirthSubroutine() {
        //TODO this needs to be integrated in a Priority Handler somehow. Meaning it should just birth if the handler allows it.
        // Create Constructurus
        if (allCreeps.filter((Creep creep) -> creep.memory.$get("role")=="constructus").length<2) {
            if (this.checkConstrSites().length!=0)
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.HARVESTER.getTemplate(),
                    null,
                    RoleCollection.CONSTRUCTUS.getRole()
            );
        }
    }
    public void cleanSubroutine() {
        String [] memcreepNames= new Mapper(Memory.creeps).getKeys();
        for (String creepName: memcreepNames) {
            if (Game.creeps.$get(creepName)==null) {
                Memory.creeps.$delete(creepName);
                System.out.println("Dragging out the dead body of "+creepName);
            }
        }
    }
    //TODO Dont forget to change this method when removing the if-clause in constructusBirthSubroutine
    public ConstructionSite[] checkConstrSites() {
       return Game.spawns.$get("Overmind").room.find(FIND_CONSTRUCTION_SITES);
    }

}
