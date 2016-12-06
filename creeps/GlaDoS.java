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

    private  Mapper<Creep> allCreeps=new Mapper<Creep>(Game.creeps);

    public void plebBirthSubroutine() {
        //Create Plebejans
        if (allCreeps.filter((Creep creep) -> creep.memory.$get("role") == "plebejus").length < 3) {
            System.out.println("PLEBCHECK: ");
            System.out.println(allCreeps.filter((Creep creep) -> creep.memory.$get("role") == "plebejus").length < 3);
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.WORKER.getTemplate(),
                    null,
                    RoleCollection.PLEBEJUS.getRole()
            );
        }
    }
    public void optimusBirthSubroutine() {
        //Create Optimus'
        if (allCreeps.filter((Creep creep) -> creep.memory.$get("role") == "optimus").length < 2) {
            System.out.println("OPTI CHECK: ");
            System.out.println(allCreeps.filter((Creep creep) -> creep.memory.$get("role") == "optimus").length < 2);
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.WORKER.getTemplate(),
                    null,
                    RoleCollection.OPTIMUS.getRole()
            );
        }
    }
    public void constructusBirthSubroutine() {
        // Create Constructurus
        if (allCreeps.filter((Creep creep) -> creep.memory.$get("role")=="constructus").length<2) {
            System.out.println("CONSTRU CHECK");
            System.out.println(allCreeps.filter((Creep creep) -> creep.memory.$get("role")=="constructus").length<2 );
            if (this.checkConstrSites().length!=0)
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.WORKER.getTemplate(),
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
    public ConstructionSite[] checkConstrSites() {
       return Game.spawns.$get("Overmind").room.find(FIND_CONSTRUCTION_SITES);
    }

}
