package MeetingManagementVM.meetingmanagement;

import MeetingManagementVM.meetingmanagement.core.service.MeetingManagementService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MeetingManagementServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(MeetingManagementServiceFactory.class.getName());

    public MeetingManagementServiceFactory() {}

    public static MeetingManagementService createMeetingManagementService(String fullyQualifiedName, Object ... base) {
        MeetingManagementService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (MeetingManagementService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of MeetingManagementService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to MeetingManagementService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating MeetingManagementService.");
            System.exit(50);
        }
        return record;
    }
}
