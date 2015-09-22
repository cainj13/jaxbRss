package org.semper.reformanda.syndication.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rfc822DateFormatAdapter extends XmlAdapter<String, Date> {

    public static final String RFC_822_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";

    @Override
    public Date unmarshal(String dateString) throws Exception {
        return new SimpleDateFormat(RFC_822_DATE_FORMAT).parse(dateString);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat(RFC_822_DATE_FORMAT).format(date);
    }
}