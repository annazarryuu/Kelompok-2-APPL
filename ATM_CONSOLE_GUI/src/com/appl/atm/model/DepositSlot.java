/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Tio
 */
public class DepositSlot {
    
    private int envelopeAmount = 100;
    
    private final int ENVELOPE_RECEIVED = 0;
    private final int ENVELOPE_NOT_RECEIVED = -1;
    
    public int isEnvelopeReceived () {
        if ( envelopeAmount > 0 ) {
            envelopeAmount -= 1;
            return ENVELOPE_RECEIVED;
        } else {
            return ENVELOPE_NOT_RECEIVED;
        }
    }
    
    /**
     * @return the envelopeAmount
     */
    public int getEnvelopeAmount() {
        return envelopeAmount;
    }

    /**
     * @param envelopeAmount the envelopeAmount to set
     */
    public void setEnvelopeAmount(int envelopeAmount) {
        this.envelopeAmount = envelopeAmount;
    }
    
}
