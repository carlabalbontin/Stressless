package com.cbalt.stressless.data;

import com.cbalt.stressless.models.Pending;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    // Esta clase va a obtener la info de la base de datos
    // La va a convertir a una lista para pasársela al RecyclerView

    public List<Pending> pendings() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.listAll(Pending.class);

        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;
    }
}
