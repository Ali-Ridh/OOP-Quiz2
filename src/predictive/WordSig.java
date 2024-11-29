package predictive;

public class WordSig implements Comparable<WordSig> {
    private String word;
    private String signature;

    public WordSig(String word, String signature) {
        this.word = word.toLowerCase();
        this.signature = signature;
    }

    public String getWord() {
        return word;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public int compareTo(WordSig ws) {
        return this.signature.compareTo(ws.signature);
    }

    @Override
    public String toString() {
        return "(" + word + ", " + signature + ")";
    }
}
