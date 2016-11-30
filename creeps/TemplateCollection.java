package org.myScreeps.creeps;

import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */
public enum TemplateCollection {

    WORKER("worker"){
        @Override
        public String[] setTemplate() {
            return new String[]{WORK,CARRY,MOVE,MOVE};
        }
    };

    public String[] setTemplate(){
        return null;
    }

    private String name;

    TemplateCollection(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}
