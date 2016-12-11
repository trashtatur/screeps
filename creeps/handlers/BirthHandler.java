package org.myScreeps.creeps.handlers;

import def.screeps.Creep;
import def.screeps.Game;
import org.myScreeps.creeps.GlaDoS;
import org.parakoopa.screeps.api.Mapper;

/**
 * Created by Andi on 11.12.2016.
 */
public class BirthHandler {

    private GlaDoS glaDoS;
    private Creep[] plebs=new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="plebejus");
    private Creep[] regens=new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="regeneratus");
    private Creep[] optims=new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="optimus");
    //Constructors are handled separately at the moment.


    public BirthHandler(GlaDoS glaDoS) {
        this.glaDoS=glaDoS;
    }
    // TODO this could be done more elegantly. ATM its not very modular (not at all). Fix that!
    public void birthPriority() {
        if (plebs.length<3) {
            glaDoS.plebBirthSubroutine();

            if (plebs.length>=3&&
                regens.length<2 )     {

                glaDoS.regeneratusBirthSubroutine();

                if (regens.length>=2&&
                    optims.length<2) {

                    glaDoS.optimusBirthSubroutine();
                }
            }
        }
    }
}
