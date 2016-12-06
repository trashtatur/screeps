package org.myScreeps.creeps.collections;

import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */

public enum TemplateCollection {

    WORKER("worker",new String[]{WORK,CARRY,MOVE,MOVE}),

    STRONGWORKER("worker",new String[]{WORK,WORK,WORK,MOVE,MOVE,MOVE,MOVE,MOVE,CARRY,CARRY});

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
