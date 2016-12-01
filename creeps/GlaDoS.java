package org.myScreeps.creeps;

import def.screeps.Creep;
import def.screeps.Game;
import org.myScreeps.creeps.brains.ConstructusBrain;
import org.myScreeps.creeps.brains.OptimusBrain;
import org.myScreeps.creeps.brains.PlebejusBrain;
import org.myScreeps.creeps.interfaces.CreepRole;
import org.parakoopa.screeps.api.Mapper;

import java.util.ArrayList;

/**
 * Created by Andi on 30.11.2016.
 */
public final class GlaDoS {

    private static Mapper<Creep> allCreeps=new Mapper<Creep>(Game.creeps);


    public static void birthSubroutine() {
        //Create Plebejans
        if (checkPop(allCreeps.filter(creep -> creep.memory.$get("role")=="plebejus"))) {
           Game.spawns.$get("Overmind").createCreep(
                   TemplateCollection.WORKER.getTemplate(),
                   null,
                   RoleCollection.PLEBEJUS.getRole()
           );
        }
        //Create Optimus'
        if (checkPop(allCreeps.filter(creep -> creep.memory.$get("role")=="optimus"))) {
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.WORKER.getTemplate(),
                    null,
                    RoleCollection.OPTIMUS.getRole()
            );
        }
        // Create Constructurus
        if (checkPop(allCreeps.filter(creep -> creep.memory.$get("role")=="constructus"))) {
            Game.spawns.$get("Overmind").createCreep(
                    TemplateCollection.WORKER.getTemplate(),
                    null,
                    RoleCollection.CONSTRUCTUS.getRole()
            );
        }

    }

    public static void workSubroutine() {
        //Sage den einzelnen Brains dass sie arbeiten sollen mit den jeweiligen zu Ihnen
        //passenden Creeps aus der Map aller Creeps.
        PlebejusBrain.workRoutine(allCreeps.filter(creep -> creep.$get("role")=="plebejus"));
        OptimusBrain.workRoutine(allCreeps.filter(creep -> creep.$get("role")=="optimus"));
        ConstructusBrain.workRoutine(allCreeps.filter(creep -> creep.$get("role")=="constructus"));
    }

    //Checks the Population
    private static boolean checkPop(Creep[] creeps) {

        return creeps.length<2;
    }




}
