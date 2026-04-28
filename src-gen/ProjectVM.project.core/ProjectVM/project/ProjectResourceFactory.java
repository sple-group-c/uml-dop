package ProjectVM.project;

import ProjectVM.project.core.resource.ProjectResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ProjectResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ProjectResourceFactory.class.getName());

    public ProjectResourceFactory() {}

    public static ProjectResource createProjectResource(String fullyQualifiedName, Object ... base) {
        ProjectResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ProjectResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ProjectResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ProjectResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ProjectResource.");
            System.exit(50);
        }
        return record;
    }
}
