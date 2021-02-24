package it.previnet.progettofermi.application.port;

import java.util.List;

public class FermiException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected List<String> messages;

    public FermiException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
