package it.previnet.progettofermi.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import it.previnet.progettofermi.model.enums.TipoSessoEntity;

@Converter(autoApply = true)
public class TipoSessoEnumConverter implements AttributeConverter<TipoSessoEntity, String> {

    @Override
    public String convertToDatabaseColumn(TipoSessoEntity flagEnum) {
        if(flagEnum == null) {
            return null;
        }
        return flagEnum.getValue();
    }

    @Override
    public TipoSessoEntity convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        for (TipoSessoEntity tipoSessoEnum : TipoSessoEntity.values()) {
            if (tipoSessoEnum.getValue().equals(dbData)) {
                return tipoSessoEnum;
            }
        }

        throw new IllegalArgumentException("Unknown database value:" + dbData);
    }
}
