package org.myScreeps.creeps;

import static def.screeps.Globals.*;

/**
 * Created by Andi on 30.11.2016.
 */
//TODO entweder Methode finden dieses Enum zum Laufen zu kriegen, oder es wieder in ne Utility Klasse ändern
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
