import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class FileProcessor {
    public void processFiles(String[] fileNames) {

        List<BufferedReader> readers = new ArrayList<>();
        BufferedWriter writer = null;

        try {
            for (int i = 0; i < fileNames.length - 1; i++) {
                readers.add(new BufferedReader(new FileReader(fileNames[i])));
            }
            writer = new BufferedWriter(new FileWriter(fileNames[fileNames.length - 1]));
            processFilesInternal(readers, writer); // выполняется внутренняя политика

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        } finally {
            for (BufferedReader reader : readers) {
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при закрытии входного файла: " + e.getMessage());
                }
            }
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии выходного файла: " + e.getMessage());
            }
        }
    }

    // реализовать неопределенную внутреннюю политику
    protected abstract void processFilesInternal(List<BufferedReader> readers, BufferedWriter writer) throws IOException;
}