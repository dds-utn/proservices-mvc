package proservices.models.entities.converters;

import proservices.models.entities.mediosdenotificacion.MedioDeNotificacion;
import proservices.models.entities.mediosdenotificacion.NotificacionViaEmail;
import proservices.models.entities.mediosdenotificacion.NotificacionViaWpp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public class MedioDeNotificacionAttributeConverter implements AttributeConverter<MedioDeNotificacion, String> {
    @Override
    public String convertToDatabaseColumn(MedioDeNotificacion medioDeNotificacion) {
        String nombreDelMedio = "";

        switch (medioDeNotificacion.getClass().getName()) {
            case "NotificacionViaWpp": nombreDelMedio = "wpp"; break;
            case "NotificacionViaEmail": nombreDelMedio = "email"; break;
        }
        return nombreDelMedio;
    }

    @Override
    public MedioDeNotificacion convertToEntityAttribute(String s) {
        MedioDeNotificacion medio = null;

        if(Objects.equals(s, "wpp"))
            medio = new NotificacionViaWpp();

        if(Objects.equals(s, "email"))
            medio = new NotificacionViaEmail();

        return medio;
    }
}
