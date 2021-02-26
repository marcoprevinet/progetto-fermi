package it.previnet.progettofermi.model.enums;

public enum TipoDocumentoIdentificazioneEntity {
    CARTA_IDENTITA("01"),
    PATENTE("02"),
    PASSAPORTO("03"),
    VISURA_CAMERALE("04");

    private String value;

    TipoDocumentoIdentificazioneEntity(String value) {
        this.setValue(value);
    }

    public static TipoDocumentoIdentificazioneEntity lookup(String value) {
        if (value != null) {
            for (TipoDocumentoIdentificazioneEntity t : values()) {
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
