package org.myScreeps;

import def.screeps.Creep;
import def.screeps.Game;
import org.myScreeps.creeps.GlaDoS;
import org.myScreeps.creeps.brains.ConstructusBrain;
import org.myScreeps.creeps.brains.OptimusBrain;
import org.myScreeps.creeps.brains.PlebejusBrain;
import org.myScreeps.creeps.brains.RegeneratusBrain;
import org.parakoopa.screeps.api.Mapper;



/**
 * Created by andi on 29.11.16.
 */
public class MainGame {
    public void loop() {

        //Create new fresh instance of central control Classes to avoid caching problems!
        GlaDoS glaDoS=new GlaDoS();
        PlebejusBrain plebejusBrain= new PlebejusBrain();
        ConstructusBrain constructusBrain=new ConstructusBrain();
        OptimusBrain optimusBrain=new OptimusBrain();
        RegeneratusBrain regeneratusBrain=new RegeneratusBrain();
        //-------------------------------------------------------------------------------

        //GLadOS Routines ---------------------------------------------------------------
        glaDoS.plebBirthSubroutine();       //Birth new Creeps if needed
        glaDoS.constructusBirthSubroutine();
        glaDoS.optimusBirthSubroutine();
        glaDoS.regeneratusBirthSubroutine();
        glaDoS.cleanSubroutine();       //Clean Memory of dead Creeps
        //-------------------------------------------------------------------------------


        //SubBrain Routines -------------------------------------------------------------
        plebejusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="plebejus"));
        optimusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="optimus"));
        constructusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="constructus"));
        regeneratusBrain.workRoutine(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="regeneratus"));
        //Check if Constructus Creeps are needed anymore. If not: kill them.
        constructusBrain.suicideCheck(new Mapper<Creep>(Game.creeps).filter(creep -> creep.memory.$get("role")=="constructus"),glaDoS);
        //--------------------------------------------------------------------------------

    }
}
