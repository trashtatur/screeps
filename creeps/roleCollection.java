package org.myScreeps.creeps;

import org.myScreeps.creeps.interfaces.CreepRole;
import org.myScreeps.creeps.roles.ConstructusRole;
import org.myScreeps.creeps.roles.OptimusRole;
import org.myScreeps.creeps.roles.PlebejusRole;

/**
 * Created by andi on 30.11.16.
 */
//TODO entweder Methode finden dieses Enum zum Laufen zu kriegen, oder es wieder in ne Utility Klasse ändern
public enum RoleCollection {

    PLEBEJUS("plebejus",new PlebejusRole("plebejus")),

    OPTIMUS("optimus", new OptimusRole("optimus")),

    CONSTRUCTUS("constructus", new ConstructusRole("constructus")){

    };

    private String name;
    private CreepRole role;

    RoleCollection(String name, CreepRole role) {

        this.name = name;
        this.role = role;
    }
    @Override
    public String toString() {
        return name;
    }

}
