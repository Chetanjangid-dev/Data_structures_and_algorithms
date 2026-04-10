function canConstruct(ransomNote, magazine) {
    let freq = {};

    for (let ch of magazine) {
        freq[ch] = (freq[ch] || 0) + 1;
    }

    for (let ch of ransomNote) {
        if (!freq[ch]) return false;
        freq[ch]--;
    }

    return true;
}
