package BeritaBoardVM.beritaboard;

import BeritaBoardVM.beritaboard.core.resource.BeritaBoardResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BeritaBoardResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(BeritaBoardResourceFactory.class.getName());

    public BeritaBoardResourceFactory() {}

    public static BeritaBoardResource createBeritaBoardResource(String fullyQualifiedName, Object ... base) {
        BeritaBoardResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (BeritaBoardResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of BeritaBoardResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to BeritaBoardResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating BeritaBoardResource.");
            System.exit(50);
        }
        return record;
    }
}
