package it.previnet.progettofermi.bean.enums;

public enum TipoDocumentoIdentificazione {
    CARTA_IDENTITA("01"),
    PATENTE("02"),
    PASSAPORTO("03"),
    VISURA_CAMERALE("04");

    public final String value;

    TipoDocumentoIdentificazione(String value) {
        this.value = value;
    }

    public static TipoDocumentoIdentificazione lookup(String value) {
        if (value != null) {
            for (TipoDocumentoIdentificazione t : values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
        }

        return null;
    }
}
