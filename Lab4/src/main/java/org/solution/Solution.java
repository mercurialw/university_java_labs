package org.solution;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

/**
 * Основной класс программы, отвечающий за чтение данных из CSV-файла
 * и наполнение списка людей.
 */
public class Solution {
    /**
     * Список людей, считанных из CSV-файла.
     */
    public static final List<Human> list = new ArrayList<>();

    /**
     * Точка входа в программу.
     * Читает файл CSV, парсит его строки и заполняет список {@link Solution#list}.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        char separator = ';';

        try (InputStream in = Solution.class.getClassLoader().getResourceAsStream("foreign_names.csv")) {
            if (in == null) {
                throw new FileNotFoundException("foreign_names.csv не найден");
            }

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .build();

            try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                    .withCSVParser(parser)
                    .build()) {

                String[] nextLine = reader.readNext(); // Пропускаем заголовок

                while ((nextLine = reader.readNext()) != null) {
                    Human human = new Human();
                    human.parse(nextLine);
                    list.add(human);
                }
            } catch (CsvValidationException e) {
                throw new RuntimeException("Ошибка валидации CSV-файла", e);
            }

            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
