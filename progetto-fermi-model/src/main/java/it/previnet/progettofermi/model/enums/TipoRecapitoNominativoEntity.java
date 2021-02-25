package it.previnet.progettofermi.model.enums;

public enum TipoRecapitoNominativoEntity {
    RESIDENZA("001"),
    INVIO_CORRISPONDENZA("002"),
    SEDE_LEGALE("003"),
    SEDE_AMMINISTRATIVA("004");

    public final String value;

    TipoRecapitoNominativoEntity(String value) {
        this.value = value;
    }

    public static TipoRecapitoNominativoEntity lookup(String value) {
        if (value != null) {
            for (TipoRecapitoNominativoEntity t : values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }
}
