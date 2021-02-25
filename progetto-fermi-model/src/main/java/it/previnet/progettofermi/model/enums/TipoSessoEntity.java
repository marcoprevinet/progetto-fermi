package it.previnet.progettofermi.model.enums;

public enum TipoSessoEntity {
    GIURIDICO("G"),
    FEMMINA("F"),
    MASCHIO("M");

    public final String value;

    TipoSessoEntity(String value) {
        this.value = value;
    }

    public static TipoSessoEntity lookup(String value) {
        if (value != null) {
            for (TipoSessoEntity t : values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }
}
