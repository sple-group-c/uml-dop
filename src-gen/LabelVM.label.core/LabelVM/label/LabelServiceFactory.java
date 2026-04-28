package LabelVM.label;

import LabelVM.label.core.service.LabelService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class LabelServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(LabelServiceFactory.class.getName());

    public LabelServiceFactory() {}

    public static LabelService createLabelService(String fullyQualifiedName, Object ... base) {
        LabelService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (LabelService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of LabelService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to LabelService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating LabelService.");
            System.exit(50);
        }
        return record;
    }
}
