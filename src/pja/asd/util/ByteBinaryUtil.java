package pja.asd.util;

public class ByteBinaryUtil {

    public static byte[] binaryString2bytes(String input, int size) {
        final int length = input.length();
        final int chunks = (int) Math.ceil((double) length / size);

        byte[] encodedBytes = new byte[chunks];

        for(int i = 0; i < chunks; i++) {
            String sub = input.substring(i * size, Math.min((i + 1) * size, length));
            byte encodedByte = 0;

            for (int j = 0; j < sub.length(); j++) {
                char bit = sub.charAt(j);

                encodedByte <<= 1;

                if (bit == '1') {
                    encodedByte |= 1;
                }
            }

            encodedBytes[i] = encodedByte;
        }

        return encodedBytes;
    }
}
