import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearchFileProcessor extends FileProcessor {

    @Override
    protected void processFilesInternal(List<BufferedReader> readers, BufferedWriter writer) throws IOException {
        Set<String> wordsToSearch = new HashSet<>();
        BufferedReader firstReader = readers.getFirst();
        String line;
        while ((line = firstReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            Collections.addAll(wordsToSearch, words);
        }

        for (int i = 1; i < readers.size(); i++) {
            BufferedReader reader = readers.get(i);
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (wordsToSearch.contains(word)) {
                        writer.write(word);
                        writer.newLine();
                    }
                }
            }
        }
    }
}