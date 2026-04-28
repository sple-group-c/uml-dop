package ReminderVM.reminder;

import ReminderVM.reminder.core.service.ReminderService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReminderServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReminderServiceFactory.class.getName());

    public ReminderServiceFactory() {}

    public static ReminderService createReminderService(String fullyQualifiedName, Object ... base) {
        ReminderService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReminderService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReminderService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReminderService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReminderService.");
            System.exit(50);
        }
        return record;
    }
}
