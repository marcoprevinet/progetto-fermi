package it.previnet.progettofermi.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import it.previnet.progettofermi.model.enums.TipoDocumentoIdentificazioneEntity;

@Converter(autoApply = true)
public class TipoDocumentoIdentificazioneEnumConverter implements AttributeConverter<TipoDocumentoIdentificazioneEntity, String> {

    @Override
    public String convertToDatabaseColumn(TipoDocumentoIdentificazioneEntity flagEnum) {
        if(flagEnum == null) {
            return null;
        }
        return flagEnum.getValue();
    }

    @Override
    public TipoDocumentoIdentificazioneEntity convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        for (TipoDocumentoIdentificazioneEntity tipoSessoEnum : TipoDocumentoIdentificazioneEntity.values()) {
            if (tipoSessoEnum.getValue().equals(dbData)) {
                return tipoSessoEnum;
            }
        }

        throw new IllegalArgumentException("Unknown database value:" + dbData);
    }
}
