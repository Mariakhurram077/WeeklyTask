package com.example.weeklytask

fun lengthOfLongestSubstring(s: String): Int {
    var maxLength = 0
    var start = 0
    val charIndexMap = mutableMapOf<Char, Int>()

    for (end in s.indices) {
        val currentChar = s[end]

        // If the character is already in the map, move the start position
        // right after the last occurrence of the current character.
        if (charIndexMap.containsKey(currentChar)) {
            start = maxOf(start, charIndexMap[currentChar]!! + 1)
        }

        // Update the latest index of the character
        charIndexMap[currentChar] = end

        // Calculate the current window length and update maxLength
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}

fun main() {
    val input1 = "ABCDEFGABEF"
    val input2 = "HDHSKNCHSFD"
    println("Input: \"$input1\"")
    println("Output: ${lengthOfLongestSubstring(input1)}")  // Output: 7
    println("Input: \"$input2\"")
    println("Output: ${lengthOfLongestSubstring(input2)}")  // Output: 7
}
/*

### Simplified Explanation

1. **Variables**:
- `maxLength`: Keeps track of the longest substring found.
- `start`: The starting index of the current window of unique characters.
- `charIndexMap`: A map to store the last index of each character.

2. **Loop Through String**:
- For each character in the string, check if it's already in the map.
- If it is, move the `start` index to one position after the last occurrence of the current character to ensure all characters in the current window are unique.
- Update the map with the current character and its index.
- Calculate the length of the current window (`end - start + 1`) and update `maxLength` if this window is longer.

3. **Return Result**:
- After iterating through the string, `maxLength` will hold the length of the longest substring without repeating characters.

### Time and Space Complexity

- **Time Complexity**: \(O(n)\), where \(n\) is the length of the string. Each character is processed once.
- **Space Complexity**: \(O(min(n, m))\), where \(m\) is the size of the character set. The map stores characters and their indices.
*/
