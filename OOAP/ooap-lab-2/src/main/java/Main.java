import java.util.*;

public class Main {
    public static void main(String[] args) { // args: type (upper | search) file1 file2 ... outerFile
        if (args.length < 3) {
            return;
        }

        String type = args[0];
        String[] fileNames = Arrays.copyOfRange(args, 1, args.length);

        FileProcessor processor;
        switch (type.toLowerCase()) {
            case "upper":
                processor = new UpperCaseFileProcessor();
                break;
            case "search":
                processor = new WordSearchFileProcessor();
                break;
            default:
                System.out.println("Неизвестный тип обработки: " + type);
                return;
        }

        processor.processFiles(fileNames);
    }
}