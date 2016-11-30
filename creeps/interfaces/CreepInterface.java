package org.myScreeps.creeps.interfaces;

import def.screeps.Creep;
import jsweet.lang.Object;

/**
 * Created by andi on 30.11.16.
 */
public interface CreepInterface {

    boolean checkPop();
    //Checks the population to see if babbies need to be made

    void makeBabby();
}
