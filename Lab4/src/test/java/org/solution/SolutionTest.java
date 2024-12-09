package org.solution;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testHumanParse() {
        String[] csvLine = {"1", "John Doe", "Male", "15.04.1985", "A", "1000"};

        Human human = new Human();
        human.parse(csvLine);

        assertEquals(1, human.getId());
        assertEquals("John Doe", human.getName());
        assertTrue(human.isMale());
        assertEquals("A", human.getSubdivision().getName());
        assertEquals(1000, human.getSalary());
        assertEquals("15.04.1985", new SimpleDateFormat("dd.MM.yyyy").format(human.getBirthday()));
    }

    @Test
    void testSubdivisionCreation() {
        Subdivision subdivision = new Subdivision('A');

        assertEquals(0, subdivision.getId());
        assertEquals("A", subdivision.getName());
    }

    @Test
    void testCsvReading() {
        String csvData = """
                ID;Name;Gender;Birthday;Subdivision;Salary
                1;John Doe;Male;15.04.1985;A;1000
                2;Jane Smith;Female;20.07.1990;B;1200
                """;

        InputStream csvStream = new ByteArrayInputStream(csvData.getBytes());

        Solution.list.clear();

        char separator = ';';

        try {
            var parser = new CSVParserBuilder().withSeparator(separator).build();
            try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(csvStream))
                    .withCSVParser(parser)
                    .build()) {

                String[] nextLine = reader.readNext();

                while ((nextLine = reader.readNext()) != null) {
                    Human human = new Human();
                    human.parse(nextLine);
                    Solution.list.add(human);
                }
            }

            assertEquals(2, Solution.list.size());

            Human firstHuman = Solution.list.get(0);
            assertEquals(1, firstHuman.getId());
            assertEquals("John Doe", firstHuman.getName());

            Human secondHuman = Solution.list.get(1);
            assertEquals(2, secondHuman.getId());
            assertEquals("Jane Smith", secondHuman.getName());

        } catch (Exception e) {
            fail("Ошибка при чтении CSV: " + e.getMessage());
        }
    }
}
