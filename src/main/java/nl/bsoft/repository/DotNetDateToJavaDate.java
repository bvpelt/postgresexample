package nl.bsoft.repository;

import java.util.Date;

/**
 * Created by bvpelt on 4/19/17.
 */
public class DotNetDateToJavaDate {

    public static Date convert(String date) {

        Date convertedDate = null;

        if (date != null) {
            // expected input format example '/Date(1262300400000+0100)/'
            String numbers = date.replaceAll("/Date\\((\\d+)\\+(\\d+)\\)/", "$1+$2");

            String[] parts = numbers.split("\\+");

            convertedDate = new Date(Long.parseLong(parts[0]));
        }

        return convertedDate;
    }
}
