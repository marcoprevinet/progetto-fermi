package it.previnet.progettofermi.repository.adapter;

import static java.util.Map.entry;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import it.previnet.progettofermi.repository.port.ModelUtils;
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.reflect.FieldUtils;

@ApplicationScoped
public class ModelUtilsImpl implements ModelUtils {
    
    /* (non-Javadoc)
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#isNullTyped(T, T)
     */
    @Override
    public <T> T isNullTyped(T object, T defaultValue) {
        return (object == null) ? defaultValue : object;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#trimToNull(
     * java.lang.String)
     */
    @Override
    public String trimToNull(String value) {
        if (value != null) {
            value = value.trim();
            if (value.length() == 0) {
                return null;
            } else {
                return value;
            }
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * trimToEmptyString(java.lang.String)
     */
    @Override
    public String trimToEmptyString(String value) {
        if (trimToNull(value) != null) {
            return trimToNull(value);
        } else {
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * trimNullifyUpperCase(java.lang.String)
     */
    @Override
    public String trimNullifyUpperCase(String value) {
        if (value != null) {
            value = value.trim();
            if (value.length() == 0) {
                return null;
            } else {
                return value.toUpperCase();
            }
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * trimToEmptyStringUpperCase(java.lang.String)
     */
    @Override
    public String trimToEmptyStringUpperCase(String value) {
        if (trimNullifyUpperCase(value) != null) {
            return trimNullifyUpperCase(value);
        } else {
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#trimToString(
     * java.lang.String, java.lang.String)
     */
    @Override
    public String trimToString(String value, String _default) {
        if (trimToNull(value) != null) {
            return trimToNull(value);
        } else {
            return _default;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#isUndefined(
     * java.lang.String)
     */
    @Override
    public boolean isUndefined(String value) {
        if (trimToNull(value) == null) {
            return true;
        }

        if ("undefined".equals(value)) {
            return true;
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#isAfter(java.
     * util.LocalDateTime, java.util.LocalDateTime)
     */
    @Override
    public boolean isAfter(LocalDateTime date1, LocalDateTime date2) {
        if (date1 == null || date2 == null) {
            return false;
        }

        return date1.isAfter(date2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * isAfterOrEquals(java.util.LocalDateTime, java.util.LocalDateTime)
     */
    @Override
    public boolean isAfterOrEquals(LocalDateTime date1, LocalDateTime date2) {
        if (date1 == null || date2 == null) {
            return false;
        }

        if (date1.isAfter(date2)) {
            return true;
        }

        return equals(date1, date2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#equals(java.
     * util.LocalDateTime, java.util.LocalDateTime)
     */
    @Override
    public boolean equals(LocalDateTime date1, LocalDateTime date2) {
        if (date1 == null || date2 == null) {
            return false;
        }

        return date1.isEqual(date2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#toBigDecimal(
     * java.lang.String)
     */
    @Override
    public BigDecimal toBigDecimal(String str) {
        if (str == null) {
            return null;
        }

        try {
            // BigDecimal i = new BigDecimal(str);

            return (new BigDecimal(str));
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#trimString(
     * java.lang.String)
     */
    @Override
    public String trimString(String s) {
        return s != null ? s.trim() : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#isEmptyString
     * (java.lang.String)
     */
    @Override
    public boolean isEmptyString(String s) {
        return s == null || "".equals(trimString(s));
    }

    /* a è fra b e c: esempio a=100 b=50 c=1000 ->incluso */
    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#isBetween(
     * java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal)
     */
    @Override
    public boolean isBetween(BigDecimal a, BigDecimal b, BigDecimal c) {
        boolean isBetween = false;
        if (a.compareTo(b) > 0 && a.compareTo(c) < 0) {
            return isBetween;
        }
        return isBetween;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#isBetweenMin(
     * java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal)
     */
    @Override
    public boolean isBetweenMin(BigDecimal a, BigDecimal b, BigDecimal c) {
        boolean isBetweenMin = false;
        if (a.compareTo(b) >= 0 && a.compareTo(c) < 0) {
            return isBetweenMin;
        }
        return isBetweenMin;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#modificato(T,
     * T, java.lang.String[])
     */
//    @Override
//    public <T> boolean modificato(T ultimoValido, T nuovoDaVerificare, String[] fields) {
//        if (ultimoValido != null && nuovoDaVerificare != null) {
//            return !EqualsBuilder.reflectionEquals(ultimoValido, nuovoDaVerificare, fields);
//        } else {
//            return true;
//        }
//    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#modificato(T,
     * T)
     */
//    @Override
//    public <T> boolean modificato(T ultimoValido, T nuovoDaVerificare) {
//        if (ultimoValido != null && nuovoDaVerificare != null) {
//            List<String> campiDaControllare = FieldUtils.getAllFieldsList(nuovoDaVerificare.getClass()).stream().filter(f -> {
//                boolean exclude = false;
//                exclude = f.getName().startsWith("id") || f.getName().startsWith("token") || f.getName().equals("serialVersionUID");// escludo
//                                                                                                                                    // dai
//                                                                                                                                    // controlli
//                                                                                                                                    // i
//                                                                                                                                    // token
//                exclude = exclude && !(Iterable.class.isAssignableFrom(f.getType()) || f.getType().isArray()); // ecluso
//                                                                                                               // dai
//                                                                                                               // controlli
//                                                                                                               // le
//                                                                                                               // liste
//                return exclude;
//            }).map(field -> field.getName()).collect(Collectors.toList());
//
//            return modificato(ultimoValido, nuovoDaVerificare, campiDaControllare.toArray(new String[campiDaControllare.size()]));
//        } else {
//            return true;
//        }
//    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#modificato(T,
     * T, java.util.List)
     */
//    @Override
//    public <T> boolean modificato(T ultimoValido, T nuovoDaVerificare, List<String> includeFields) {
//        if (ultimoValido != null && nuovoDaVerificare != null) {
//            List<String> campiDaEscludere = FieldUtils.getAllFieldsList(nuovoDaVerificare.getClass()).stream().filter(f -> {
//                boolean exclude = !includeFields.contains(f.getName());
//                return exclude;
//            }).map(field -> field.getName()).collect(Collectors.toList());
//
//            return modificato(ultimoValido, nuovoDaVerificare, campiDaEscludere.toArray(new String[campiDaEscludere.size()]));
//        } else {
//            return true;
//        }
//    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#getToday()
     */
    @Override
    public LocalDateTime getToday() {
        return clean(LocalDateTime.now());
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getLocalDateTime112()
     */
    @Override
    public LocalDateTime getDate112() {
        return getToday();
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getStringLocalDateTime112(java.util.LocalDateTime)
     */
    @Override
    public String getStringDate112(LocalDateTime dataRif) {
        if (dataRif == null) {
            dataRif = LocalDateTime.now();
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_112);
        String str = dateFormat.format(dataRif);

        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getStringLocalDateTime103(java.util.LocalDateTime)
     */
    @Override
    public String getStringDate103(LocalDateTime dataRif) {
        if (dataRif == null) {
            dataRif = LocalDateTime.now();
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_103);
        String str = dateFormat.format(dataRif);

        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getStringLocalDateTime121(java.util.LocalDateTime)
     */
    @Override
    public String getStringDate121(LocalDateTime dataRif) {
        if (dataRif == null) {
            dataRif = LocalDateTime.now();
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_121);
        String str = dateFormat.format(dataRif);

        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getStringLocalDateTimeHHmm(java.util.LocalDateTime)
     */
    @Override
    public String getStringDateHHmm(LocalDateTime dataRif) {
        if (dataRif == null) {
            dataRif = LocalDateTime.now();
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_HHmm);
        String str = dateFormat.format(dataRif);

        return str;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getUltimoGiornoDelMese(java.util.LocalDateTime)
     */
    @Override
    public LocalDateTime getUltimoGiornoDelMese(LocalDateTime date) {
        return date.withDayOfMonth(date.toLocalDate().lengthOfMonth());
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * toLocalDateTime(java.lang.String)
     */
    @Override
    public LocalDateTime toDate(String date) {
        return toDate(date, DATE_FORMAT_112);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * toLocalDateTime(java.lang.String, java.lang.String)
     */
    @Override
    public LocalDateTime toDate(String date, String format) {
        if (date == null) {
            return null;
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDate.parse(date, dateFormat).atStartOfDay();
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * formatLocalDateTimepickersLocalDateTime(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String formatDatepickersLocalDateTime(String ddate, String format) {
        if (ddate == null) {
            return null;
        }
        try {
            // formattazione della data 2020-10-15T10:00:00.000Z
            if (trimToNull(ddate) != "") {
                int anno = Integer.parseInt(ddate.substring(0, 4));
                int mese = Integer.parseInt(ddate.substring(5, 7));
                int giorno = Integer.parseInt(ddate.substring(8, 10));
                LocalDateTime data = LocalDateTime.now().withYear(anno).withMonth(mese).withDayOfMonth(giorno);

                if (DATE_FORMAT_103.equals(format))
                    ddate = getStringDate103(data);
                else
                    ddate = getStringDate112(data);
            }
        } catch (NumberFormatException ex) {
            return null;
        }

        return ddate;
    }

    @Override
    public String formatLocalDateTime(LocalDateTime dataRif, String format) {
        if (dataRif == null) {
            return null;
        }
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
            return dateFormat.format(dataRif);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#dateAddMonth(
     * java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddMonth(LocalDateTime date1, int month) {
        if (date1 == null) {
            return null;
        }

        return date1.plusMonths(month);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#dateAddDays(
     * java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddDays(LocalDateTime date1, int days) {
        if (date1 == null) {
            return null;
        }

        return date1.plusDays(days);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * dateAddDaysNoWeekend(java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddDaysNoWeekend(LocalDateTime date1, int days) {
        if (date1 == null) {
            return null;
        }

        date1 = dateAddDays(date1, days);
        if (date1.getDayOfWeek() == DayOfWeek.SATURDAY || date1.getDayOfWeek() == DayOfWeek.SUNDAY) {
            if (days < 0) {
                return dateAddDaysNoWeekend(date1, (days - 1));
            } else {
                return dateAddDaysNoWeekend(date1, (days + 1));
            }
        }

        return date1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#dateAddHours(
     * java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddHours(LocalDateTime date1, int hours) {
        if (date1 == null) {
            return null;
        }

        return date1.plusHours(hours);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * dateAddMinutes(java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddMinutes(LocalDateTime date1, int minutes) {
        if (date1 == null) {
            return null;
        }

        return date1.plusMinutes(minutes);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * dateAddSeconds(java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddSeconds(LocalDateTime date1, int seconds) {
        if (date1 == null) {
            return null;
        }

        return date1.plusSeconds(seconds);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#dateAddYears(
     * java.util.LocalDateTime, int)
     */
    @Override
    public LocalDateTime dateAddYears(LocalDateTime date1, int years) {
        if (date1 == null) {
            return null;
        }

        return date1.plusYears(years);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * mesiTraDueLocalDateTime(java.util.LocalDateTime, java.util.LocalDateTime)
     */
    @Override
    public long mesiTraDueDate(LocalDateTime dataInizio, LocalDateTime dataFine) {

        int yearC1 = dataInizio.getYear();
        int monthC1 = dataInizio.getMonthValue();

        int yearC2 = dataFine.getYear();
        int monthC2 = dataFine.getMonthValue();

        int mesiTrascorsi = 12 * (yearC2 - yearC1) + (monthC2 - monthC1);

        return mesiTrascorsi;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * it.previnet.applicationcards.repository.adapter.ModelUtilsI#clean(java.
     * util.LocalDateTime)
     */
    @Override
    public LocalDateTime clean(LocalDateTime date) {
        if (date == null) {
            return null;
        }

        return date.truncatedTo(ChronoUnit.DAYS);
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getCurrentLocalDateTimeTime()
     */
    @Override
    public String getCurrentLocalDateTimeTime() {
        DateTimeFormatter sdfLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strLocalDateTime = sdfLocalDateTime.format(LocalDateTime.now());
        return strLocalDateTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getCurrentTime()
     */
    @Override
    public String getCurrentTime() {
        DateTimeFormatter sdfLocalDateTime = DateTimeFormatter.ofPattern("HHmmss");
        String strLocalDateTime = sdfLocalDateTime.format(LocalDateTime.now());
        return strLocalDateTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see it.previnet.applicationcards.repository.adapter.ModelUtilsI#
     * getPrimoGiornoDelMese(java.util.LocalDateTime)
     */
    @Override
    public LocalDateTime getPrimoGiornoDelMese(LocalDateTime date) {
        return date.withDayOfMonth(1);
    }

    @Override
    public LocalDateTime parseIsoDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }

}
