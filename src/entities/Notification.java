/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Sedki
 */
public class Notification {
    
    private int id ;
    private String Producer ;
    private String Receiver ;
    private String Message ;

    public Notification() {
    }

    public Notification(int id, String Producer, String Receiver, String Message) {
        this.id = id;
        this.Producer = Producer;
        this.Receiver = Receiver;
        this.Message = Message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.Producer);
        hash = 79 * hash + Objects.hashCode(this.Receiver);
        hash = 79 * hash + Objects.hashCode(this.Message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notification other = (Notification) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Producer, other.Producer)) {
            return false;
        }
        if (!Objects.equals(this.Receiver, other.Receiver)) {
            return false;
        }
        if (!Objects.equals(this.Message, other.Message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", Producer=" + Producer + ", Receiver=" + Receiver + ", Message=" + Message + '}';
    }
    
    
    
}
