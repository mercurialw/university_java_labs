import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

class UpperCaseFileProcessor extends FileProcessor {
    @Override
    protected void processFilesInternal(List<BufferedReader> readers, BufferedWriter writer) throws IOException {
        for (BufferedReader reader : readers) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        }
    }
}