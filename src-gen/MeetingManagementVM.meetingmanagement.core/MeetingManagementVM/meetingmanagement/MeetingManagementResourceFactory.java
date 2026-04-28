package MeetingManagementVM.meetingmanagement;

import MeetingManagementVM.meetingmanagement.core.resource.MeetingManagementResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MeetingManagementResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(MeetingManagementResourceFactory.class.getName());

    public MeetingManagementResourceFactory() {}

    public static MeetingManagementResource createMeetingManagementResource(String fullyQualifiedName, Object ... base) {
        MeetingManagementResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (MeetingManagementResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of MeetingManagementResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to MeetingManagementResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating MeetingManagementResource.");
            System.exit(50);
        }
        return record;
    }
}
