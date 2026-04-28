package LabelVM.label;

import LabelVM.label.core.resource.LabelResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class LabelResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(LabelResourceFactory.class.getName());

    public LabelResourceFactory() {}

    public static LabelResource createLabelResource(String fullyQualifiedName, Object ... base) {
        LabelResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (LabelResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of LabelResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to LabelResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating LabelResource.");
            System.exit(50);
        }
        return record;
    }
}
