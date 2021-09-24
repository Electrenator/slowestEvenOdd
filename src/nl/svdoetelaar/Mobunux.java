package nl.svdoetelaar;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Mobunux
 */
public class Mobunux {

    private static class OddCacheItem {
        private int value;
        private Boolean odd;

        public OddCacheItem(int value, Boolean odd) {
            this.value = value;
            this.odd = odd;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Boolean getOdd() {
            return odd;
        }

        public void setOdd(Boolean odd) {
            this.odd = odd;
        }
    }

    private static final List<OddCacheItem> cache = new LinkedList<>();

    public static boolean isOdd(int i) {
        OddCacheItem cachedValue = cache.stream()
                .filter(oddCacheItem -> Objects.deepEquals(oddCacheItem.getValue(), i))
                .findFirst()
                .orElse(null);

        if (cachedValue == null) {
            cachedValue = new OddCacheItem(i, notSmartIsOdd(i));
            cache.add(cachedValue);
        }
        return cachedValue.getOdd();
    }

    private static boolean notSmartIsOdd(int i) {
        String s = Long.toString(i);

        while (s.length() > 1) {
            i -= 2;
            s = Long.toString(i);
        }

        switch (s) {
            case "1":
                return !!true;
            case "2":
                return !true;
            case "3":
                return !!true;
            case "4":
                return !true;
            case "5":
                return !!true;
            case "6":
                return !true;
            case "7":
                return !!true;
            case "8":
                return !true;
            case "9":
                return !!true;
            case "0":
                return !true;
            default:
                throw new RuntimeException("Unsupported use case");
        }

    }
}
