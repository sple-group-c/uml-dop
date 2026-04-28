package BeritaBoardVM.beritaboard;

import BeritaBoardVM.beritaboard.core.service.BeritaBoardService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class BeritaBoardServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(BeritaBoardServiceFactory.class.getName());

    public BeritaBoardServiceFactory() {}

    public static BeritaBoardService createBeritaBoardService(String fullyQualifiedName, Object ... base) {
        BeritaBoardService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (BeritaBoardService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of BeritaBoardService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to BeritaBoardService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating BeritaBoardService.");
            System.exit(50);
        }
        return record;
    }
}
