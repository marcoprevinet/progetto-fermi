package it.previnet.progettofermi.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import it.previnet.progettofermi.model.enums.TipoRecapitoNominativoEntity;

@Converter(autoApply = true)
public class TipoRecapitoNominativoEnumConverter implements AttributeConverter<TipoRecapitoNominativoEntity, String> {

    @Override
    public String convertToDatabaseColumn(TipoRecapitoNominativoEntity flagEnum) {
        if(flagEnum == null) {
            return null;
        }
        return flagEnum.getValue();
    }

    @Override
    public TipoRecapitoNominativoEntity convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        for (TipoRecapitoNominativoEntity tipoSessoEnum : TipoRecapitoNominativoEntity.values()) {
            if (tipoSessoEnum.getValue().equals(dbData)) {
                return tipoSessoEnum;
            }
        }

        throw new IllegalArgumentException("Unknown database value:" + dbData);
    }
}
