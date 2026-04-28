package TaskManagementVM.taskmanagement;

import TaskManagementVM.taskmanagement.core.service.TaskManagementService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class TaskManagementServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(TaskManagementServiceFactory.class.getName());

    public TaskManagementServiceFactory() {}

    public static TaskManagementService createTaskManagementService(String fullyQualifiedName, Object ... base) {
        TaskManagementService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (TaskManagementService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of TaskManagementService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to TaskManagementService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating TaskManagementService.");
            System.exit(50);
        }
        return record;
    }
}
