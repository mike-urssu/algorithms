package interviewQuestion;

/**
 * Select all the answers that will result in a runtime exception.
 * <p>
 * (Select all acceptable answers.)
 * <p>
 * <p>
 * OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
 * Cache cache = (Cache) optimizedDiskCache;
 * <p>
 * MemoryCache memoryCache = new MemoryCache();
 * Cache cache = (Cache) memoryCache;
 * DiskCache diskCache = (DiskCache) cache;
 * <p>
 * DiskCache diskCache = new DiskCache();
 * OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;
 * <p>
 * OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
 * DiskCache diskCache = (DiskCache) optimizedDiskCache;
 * <p>
 * Cache cache = new Cache();
 * MemoryCache memoryCache = (MemoryCache) cache;
 * <p>
 * OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
 * Cache cache = (Cache) optimizedDiskCache;
 * DiskCache diskCache = (DiskCache) cache;
 */

public class Cache {
    public static void main(String[] args) {
        // OK
//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        Cache cache = (Cache) optimizedDiskCache;

        // X
//        MemoryCache memoryCache = new MemoryCache();
//        Cache cache = (Cache) memoryCache; // OK
//        DiskCache diskCache = (DiskCache) cache; // X

        // X
//        DiskCache diskCache = new DiskCache();
//        OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;

        // OK
//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        DiskCache diskCache = (DiskCache) optimizedDiskCache;

        // X
//        Cache cache = new Cache();
//        MemoryCache memoryCache = (MemoryCache) cache;

        // OK
//        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        Cache cache = (Cache) optimizedDiskCache; // OK
//        DiskCache diskCache = (DiskCache) cache;
    }
}

class DiskCache extends Cache {
}

class MemoryCache extends Cache {
}

class OptimizedDiskCache extends DiskCache {
}