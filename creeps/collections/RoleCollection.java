package org.myScreeps.creeps.collections;

import jsweet.lang.Object;

import static jsweet.util.Globals.$map;

/**
 * Created by andi on 30.11.16.
 */
public enum RoleCollection {

    PLEBEJUS("plebejus",$map("role","plebejus")),

    OPTIMUS("optimus", $map("role","optimus")),

    REGENERATUS("regeneratus", $map("role","regeneratus")),

    CONSTRUCTUS("constructus", $map("role","constructus"));

    //TODO Add transportus

    private String name;
    private Object role;

    RoleCollection(String name, Object role) {

        this.name = name;
        this.role = role;
    }
    @Override
    public String toString() {
        return name;
    }
    public Object getRole() { return role; }
}
