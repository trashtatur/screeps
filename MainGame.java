package org.myScreeps;

import org.myScreeps.creeps.roles.Constructus;
import org.myScreeps.creeps.roles.Optimus;
import org.myScreeps.creeps.roles.Plebejus;

/**
 * Created by andi on 29.11.16.
 */
public class MainGame {
    public void loop() {
        Plebejus plebejus =new Plebejus();
        Optimus optimus=new Optimus();
        Constructus constructus= new Constructus();
                plebejus.makeBabby();
                optimus.makeBabby();
                constructus.makeBabby();
                plebejus.makeMeMoney();
                optimus.gatherAndUpgrade();
                constructus.construct();

    }
}
