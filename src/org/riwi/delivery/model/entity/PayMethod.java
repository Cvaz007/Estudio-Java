package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.entity.methods.Method;

public abstract class PayMethod {
    private final String type;

    public PayMethod(String type) {
        this.type = type;
    }
    public abstract Method createMethod(String type);
    public void processMethod(){
        Method method = this.createMethod(this.type);
        method.pay();
    }
}
