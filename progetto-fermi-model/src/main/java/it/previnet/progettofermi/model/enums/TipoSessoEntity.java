package it.previnet.progettofermi.model.enums;

public enum TipoSessoEntity {
    GIURIDICO("G"),
    FEMMINA("F"),
    MASCHIO("M");

    private String value;

    TipoSessoEntity(String value) {
        this.setValue(value);
    }

    public static TipoSessoEntity lookup(String value) {
        if (value != null) {
            for (TipoSessoEntity t : values()) {
                if (t.getValue().equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }
}
