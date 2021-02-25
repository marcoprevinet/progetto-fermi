package it.previnet.progettofermi.repository.port;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ModelUtils {

    String DATE_FORMAT_112 = "yyyyMMdd";
    String DATE_FORMAT_103 = "dd/MM/yyyy";
    String DATE_FORMAT_121 = "yyyy-MM-dd";
    String DATE_FORMAT_HHmm = "HH:mm";

    <T> T isNullTyped(T object, T defaultValue);

    String trimToNull(String value);

    String trimToEmptyString(String value);

    String trimNullifyUpperCase(String value);

    String trimToEmptyStringUpperCase(String value);

    String trimToString(String value, String _default);

    boolean isUndefined(String value);

    boolean equals(LocalDateTime date1, LocalDateTime date2);

    /**
     * Converte una stringa in BigDecimal. Ritorna null qualora non sia
     * possibile convertire la stringa
     *
     * @param str
     *            stringa da convertire.
     *
     * @return BigDecimal.
     */
    BigDecimal toBigDecimal(String str);

    /**
     * Metodo che fa il {@code trim} di una stringa non vuota
     */
    String trimString(String s);

    /**
     * Metodo che controlla se la string passata è vuota
     *
     * @param s
     *            stringa da controllare
     * @return true se stringa null o solo spazi, false altrimenti
     */
    boolean isEmptyString(String s);

    /* a è fra b e c: esempio a=100 b=50 c=1000 ->incluso */
    boolean isBetween(BigDecimal a, BigDecimal b, BigDecimal c);

    boolean isBetweenMin(BigDecimal a, BigDecimal b, BigDecimal c);

//    <T> boolean modificato(T ultimoValido, T nuovoDaVerificare, String[] fields);
//
//    <T> boolean modificato(T ultimoValido, T nuovoDaVerificare);
//
//    <T> boolean modificato(T ultimoValido, T nuovoDaVerificare, List<String> includeFields);

    LocalDateTime getToday();

    LocalDateTime getDate112();

    String getStringDate112(LocalDateTime dataRif);

    String getStringDate103(LocalDateTime dataRif);

    String getStringDate121(LocalDateTime dataRif);

    String getStringDateHHmm(LocalDateTime dataRif);

    LocalDateTime getUltimoGiornoDelMese(LocalDateTime date);

    LocalDateTime toDate(String date);

    LocalDateTime toDate(String date, String format);

    /**
     * La data nel formato del LocalDateTimepickers non va bene, serve formattarla
     * 
     * @param ddate
     * @return String
     */
    String formatDatepickersLocalDateTime(String ddate, String format);

    LocalDateTime dateAddMonth(LocalDateTime date1, int month);

    LocalDateTime dateAddDays(LocalDateTime date1, int days);

    LocalDateTime dateAddDaysNoWeekend(LocalDateTime date1, int days);

    LocalDateTime dateAddHours(LocalDateTime date1, int hours);

    LocalDateTime dateAddMinutes(LocalDateTime date1, int minutes);

    LocalDateTime dateAddSeconds(LocalDateTime date1, int seconds);

    LocalDateTime dateAddYears(LocalDateTime date1, int years);

    long mesiTraDueDate(LocalDateTime dataInizio, LocalDateTime dataFine);

    LocalDateTime clean(LocalDateTime date);

    String getCurrentLocalDateTimeTime();

    String getCurrentTime();

    LocalDateTime getPrimoGiornoDelMese(LocalDateTime date);

    boolean isAfter(LocalDateTime date1, LocalDateTime date2);

    boolean isAfterOrEquals(LocalDateTime date1, LocalDateTime date2);

    public default LocalDateTime getDeleteDate() {
        return LocalDateTime.of(1900, 1, 1, 0, 0);
    }

    String formatLocalDateTime(LocalDateTime dataRif, String format);

    LocalDateTime parseIsoDate(String date);

}
