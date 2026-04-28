package ProjectVM.project;

import ProjectVM.project.core.service.ProjectService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ProjectServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ProjectServiceFactory.class.getName());

    public ProjectServiceFactory() {}

    public static ProjectService createProjectService(String fullyQualifiedName, Object ... base) {
        ProjectService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ProjectService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ProjectService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ProjectService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ProjectService.");
            System.exit(50);
        }
        return record;
    }
}
