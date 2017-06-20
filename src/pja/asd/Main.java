package pja.asd;

import pja.asd.huffman.Huffman;
import pja.asd.util.ByteBinaryUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static Huffman huffman = new Huffman();

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("java -jar Huffman.jar inputFile outputFile");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (null == inputFile || null == outputFile) {
            return;
        }

        String uncompressedString = new String(Files.readAllBytes(Paths.get(inputFile)));
        String huffmanCompressedString = huffman.compress(uncompressedString);
        byte[] bytes = ByteBinaryUtil.binaryString2bytes(huffmanCompressedString, 8);

        OutputStream os = Files.newOutputStream(Paths.get(outputFile));
        os.write(bytes);
        os.flush();
        os.close();


        String summary = String.format("Before compression: %d bytes\nAfter compression: %d bytes\nRatio: %.0f%%",
                uncompressedString.length(), bytes.length,
                ((float) uncompressedString.length() / bytes.length) * 100);

        System.out.println(summary);
    }

}
