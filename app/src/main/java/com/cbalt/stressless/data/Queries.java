package com.cbalt.stressless.data;

import com.cbalt.stressless.models.Pending;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    // Esta clase va a obtener la info de la base de datos
    // La va a convertir a una lista para pasársela al RecyclerView

    public List<Pending> pendings() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");

        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;
    }

    public List<Pending> done(){
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 1");

        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;
    }

    public List<String> names(){
        List<String> names = new ArrayList<>();
        List<Pending> pendings = pendings();
        for (int i = 0; i < pendings.size(); i++) {
            names.add(pendings.get(i).getName());
        }

        return names;
    }

    public List<Pending> byName(String name){
        List<Pending> pendings = new ArrayList<>();
        String query = "done = 0 AND name LIKE '"+name+"'";
        List<Pending> pendingList = Pending.find(Pending.class, query);
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;

    }
}
