package org.myScreeps.creeps;

import def.screeps.Creep;
import def.screeps.Game;
import org.parakoopa.screeps.api.Mapper;

/**
 * Created by Andi on 30.11.2016.
 */
public final class GlaDoS {

    private static Mapper<Creep> allCreeps=new Mapper<Creep>(Game.creeps);

    public static RoleCollection scanRoles(Mapper<Creep> creeps) {
        if (checkPop(creeps.filter(creep -> creep.memory.$get("role")=="plebejus"))) {
           return RoleCollection.PLEBEJUS;
        }

        if (checkPop(creeps.filter(creep -> creep.memory.$get("role")=="optimus"))) {
            return RoleCollection.OPTIMUS;
        }

        if (checkPop(creeps.filter(creep -> creep.memory.$get("role")=="constructus"))) {
            return RoleCollection.CONSTRUCTUS;
        }
        return null;

    }

    private static boolean checkPop(Creep[] creeps) {
        return creeps.length<2;
    }


}
