package org.myScreeps.creeps;

import jsweet.lang.Object;

import static jsweet.util.Globals.$map;

/**
 * Created by andi on 30.11.16.
 */
public enum RoleCollection {

    PLEBEJUS("plebejus",$map("role","plebejus")),

    OPTIMUS("optimus", $map("role","plebejus")),

    CONSTRUCTUS("constructus", $map("role","plebejus"));

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
