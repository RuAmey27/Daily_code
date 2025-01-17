import java.util.stream.IntStream;
class Solution {
public boolean doesValidArrayExist(int[] derived) {
    int n = derived.length;
    int[] original = new int[n];

    // Assume original[0] = 0
    original[0] = 0;

    // Calculate the rest of the elements in original using IntStream
    IntStream.range(1, n)
             .forEach(i -> original[i] = original[i - 1] ^ derived[i - 1]);

    // Verify that the derived array matches the expected values using a stream
    return IntStream.range(0, n)
                    .allMatch(i -> derived[i] == (original[i] ^ original[(i + 1) % n]));
}

}