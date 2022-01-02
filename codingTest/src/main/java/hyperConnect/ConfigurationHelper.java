package hyperConnect;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// given
class BaseConfigElement {
}

class ConfigElement extends BaseConfigElement {
}

class DynamicConfigElement extends ConfigElement {
}

class ConfigCreator {
    OutputStream createConfig(List<? extends ConfigElement> elements) {
        // returns stream
        return null;
    }
}

/**
 * Question 2.
 * In the following code snippet, select all the types that the data argument can be declared, so that code still compiles:
 * <p>
 * 1. ArrayList<Object>
 * 2. ArrayList<DynamicConfigElement>
 * 3. List<DynamicConfigElement>
 * 4. List<BaseConfigElement>
 * 5. List<Object>
 * 6. List<ConfigElement>
 * 7. ArrayList<ConfigElement>
 * 8. ArrayList<BaseConfigElement>
 * <p>
 * Answer 1.
 * 2, 3, 6, 7
 */

public class ConfigurationHelper {
    public OutputStream createConfiguration(/* data type */ data) {
        ConfigCreator creator = new ConfigCreator();
        return creator.createConfig(data);
    }
}
