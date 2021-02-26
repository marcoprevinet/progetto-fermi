package it.previnet.progettofermi.model.enums;

public enum TipoRecapitoNominativoEntity {
    RESIDENZA("001"),
    INVIO_CORRISPONDENZA("002"),
    SEDE_LEGALE("003"),
    SEDE_AMMINISTRATIVA("004");

    private String value;

    TipoRecapitoNominativoEntity(String value) {
        this.setValue(value);
    }

    public static TipoRecapitoNominativoEntity lookup(String value) {
        if (value != null) {
            for (TipoRecapitoNominativoEntity t : values()) {
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
