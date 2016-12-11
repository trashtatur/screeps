package org.myScreeps.creeps.collections;

import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */

public enum TemplateCollection {

    //TODO Rework this one to be more efficient for the Harvesters
    HARVESTER("harvester",new String[]{WORK,CARRY,MOVE,MOVE}),

    //TODO Make more Templates for the other roles to differentiate them from the Harvesters more.
    //TODO Add a Transportus template, should be fast but able to carry much.

    STRONGWORKER("strongworker",new String[]{WORK,WORK,WORK,MOVE,MOVE,MOVE,MOVE,MOVE,CARRY,CARRY});
    //TODO Make this one do something that is actually useful and doesnt just look strong.

    private String name;
    private String[] template;

    TemplateCollection(String name,String[] template) {

        this.template=template;
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    public String[] getTemplate() { return template; }

}
