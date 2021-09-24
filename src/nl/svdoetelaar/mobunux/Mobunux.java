package nl.svdoetelaar.mobunux;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Mobunux {

    public static void main(String[] args) {
        for (Long i = 10_000_000L; i > 0; i--) {
            System.out.println(i + ": " + smartIsOdd(i));
        }
    }

    private static class OddCacheItem {
        private Long value;
        private Boolean odd;

        public OddCacheItem(Long value, Boolean odd) {
            this.value = value;
            this.odd = odd;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
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

    private static boolean smartIsOdd(Long i) {
        OddCacheItem cachedValue = cache.stream()
                .filter(oddCacheItem -> Objects.deepEquals(oddCacheItem.getValue(), i))
                .findFirst()
                .orElse(null);

        if (cachedValue == null) {
            cachedValue = new OddCacheItem(i, isOdd(i));
            cache.add(cachedValue);
        }
        return cachedValue.getOdd();
    }

    private static boolean isOdd(Long i) {
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
