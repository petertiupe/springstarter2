package de.tiupe.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "NewsApp:type=JMX,name=Users")
public class UserMonitor {
    @Autowired
    private UserRepository userRepo;

    @ManagedAttribute
        public long getRegisteredUserCount() {
        return this.userRepo.count();
    }
}
