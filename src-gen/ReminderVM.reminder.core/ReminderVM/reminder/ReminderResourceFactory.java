package ReminderVM.reminder;

import ReminderVM.reminder.core.resource.ReminderResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReminderResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReminderResourceFactory.class.getName());

    public ReminderResourceFactory() {}

    public static ReminderResource createReminderResource(String fullyQualifiedName, Object ... base) {
        ReminderResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReminderResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReminderResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReminderResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReminderResource.");
            System.exit(50);
        }
        return record;
    }
}
