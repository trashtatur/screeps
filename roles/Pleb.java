package org.myScreeps.roles;


import def.screeps.Creep;
import def.screeps.Game;
import org.parakoopa.screeps.api.Mapper;
import static def.screeps.Globals.*;


/**
 * Created by andi on 29.11.16.
 */
public class Pleb {

    private Creep[] plebs=new Mapper<Creep>(Game.creeps).filter(
            creep -> creep.memory.$get("role")=="pleb"
    );


    public void makeMeMoney(Creep plebcreep) {

    }

    public void makePleb() {
        if (plebs.length<2) {

        }

    }


}
