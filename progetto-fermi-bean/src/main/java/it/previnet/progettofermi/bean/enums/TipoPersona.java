package it.previnet.progettofermi.bean.enums;

public enum TipoPersona {
    GIURIDICA("PG"),
    FISICA("PF");

    public final String value;

    TipoPersona(String value) {
        this.value = value;
    }

    public static TipoPersona lookup(String value) {
        if (value != null) {
            for (TipoPersona t : values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }
}
