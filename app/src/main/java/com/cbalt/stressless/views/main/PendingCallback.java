package com.cbalt.stressless.views.main;

import com.cbalt.stressless.models.Pending;

public interface PendingCallback {

    void created(Pending pending);
    void noName();

}
