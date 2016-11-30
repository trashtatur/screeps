package org.myScreeps.creeps;

import def.screeps.Game;
import jsweet.lang.Object;

import static def.screeps.Globals.*;
import static jsweet.util.Globals.$map;

/**
 * Created by andi on 30.11.16.
 */
public enum RoleCollection {

    PLEBEJUS("plebejus"){
        @Override
        public Object setRole() {
            return $map("role", "optimus");
        }
    },

    OPTIMUS("optimus"){
        @Override
        public Object setRole() {
            return $map("role","optimus");
        }
    },

    CONSTRUCTUS("constructus"){
        @Override
        public Object setRole() {
            return $map("role", "optimus");
        }
    };


    public Object setRole(){
        return null;
    }

    private String name;

    RoleCollection(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

}
