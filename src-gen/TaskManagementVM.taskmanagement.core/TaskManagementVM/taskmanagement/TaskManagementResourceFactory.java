package TaskManagementVM.taskmanagement;

import TaskManagementVM.taskmanagement.core.resource.TaskManagementResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class TaskManagementResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(TaskManagementResourceFactory.class.getName());

    public TaskManagementResourceFactory() {}

    public static TaskManagementResource createTaskManagementResource(String fullyQualifiedName, Object ... base) {
        TaskManagementResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (TaskManagementResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of TaskManagementResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to TaskManagementResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating TaskManagementResource.");
            System.exit(50);
        }
        return record;
    }
}
