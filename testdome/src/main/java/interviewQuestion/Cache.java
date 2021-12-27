package interviewQuestion;

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