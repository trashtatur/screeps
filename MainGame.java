package org.myScreeps;

import def.screeps.Creep;
import def.screeps.Game;
import org.myScreeps.creeps.GlaDoS;
import org.myScreeps.creeps.brains.ConstructusBrain;
import org.myScreeps.creeps.brains.OptimusBrain;
import org.myScreeps.creeps.brains.PlebejusBrain;
import org.myScreeps.creeps.brains.RegeneratusBrain;
import org.myScreeps.creeps.handlers.BirthHandler;
import org.parakoopa.screeps.api.Mapper;



/**
 * Created by andi on 29.11.16.
 */
public class MainGame {
    public void loop() {

        //Create new fresh instance of central control Classes to avoid caching problems!
        GlaDoS glaDoS=new GlaDoS();
        BirthHandler birthHandler =new BirthHandler(glaDoS);
        PlebejusBrain plebejusBrain= new PlebejusBrain();
        ConstructusBrain constructusBrain=new ConstructusBrain();
        OptimusBrain optimusBrain=new OptimusBrain();
        RegeneratusBrain regeneratusBrain=new RegeneratusBrain();

        birthHandler.birthPriority();       //Birth new Creeps if needed
        glaDoS.constructusBirthSubroutine();   //GlaDOS still handles these
        glaDoS.cleanSubroutine();       //Clean Memory of dead Creeps

        //Declare workroutine for the different roles.
        plebejusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="plebejus"));
        optimusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="optimus"));
        constructusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="constructus"));
        regeneratusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="regeneratus"));
        //Check if Constructus Creeps are needed anymore. If not: kill them.
        constructusBrain.suicideCheck(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="constructus"),glaDoS);
    }
}
