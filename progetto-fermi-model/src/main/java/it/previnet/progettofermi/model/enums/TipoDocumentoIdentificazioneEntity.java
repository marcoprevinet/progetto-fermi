package it.previnet.progettofermi.model.enums;

public enum TipoDocumentoIdentificazioneEntity {
    CARTA_IDENTITA("01"),
    PATENTE("02"),
    PASSAPORTO("03"),
    VISURA_CAMERALE("04");

    public final String value;

    TipoDocumentoIdentificazioneEntity(String value) {
        this.value = value;
    }

    public static TipoDocumentoIdentificazioneEntity lookup(String value) {
        if (value != null) {
            for (TipoDocumentoIdentificazioneEntity t : values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }
}
