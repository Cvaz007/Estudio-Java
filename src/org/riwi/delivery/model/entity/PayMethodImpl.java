package org.riwi.delivery.model.entity;

import org.riwi.delivery.model.entity.methods.Card;
import org.riwi.delivery.model.entity.methods.Cash;
import org.riwi.delivery.model.entity.methods.Method;

public class PayMethodImpl extends PayMethod{
    public PayMethodImpl(String type) {
        super(type);
    }
    @Override
    public Method createMethod(String type) {
        if (type.equalsIgnoreCase("card")){
            return new Card();
        } else if (type.equalsIgnoreCase("cash")) {
            return new Cash();
        }else return null;
    }
}
