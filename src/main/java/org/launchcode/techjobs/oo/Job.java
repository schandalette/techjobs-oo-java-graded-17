package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    //default constructor to initialize unique ID
    public Job() {
        id = nextId;
        nextId++;
    }

    //constructor to initialize all fields and call default constructor
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Location getLocation() {
        return location;
    }

    public Employer getEmployer() {
        return employer;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String newLine = System.lineSeparator();
        if (name == null && employer == null && location == null && positionType == null &&
                coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }
        return newLine + "ID: " + id + newLine +
                "Name: " + (name != null && !name.isEmpty() ? name : "Data not available")
                + newLine +
                "Employer: " + (!employer.toString().isEmpty() && employer.toString() != null
                ? employer.toString() : "Data not available") + newLine +
                "Location: " + (!location.toString().isEmpty() && location != null ?
                location.toString() : "Data not available") + newLine +
                "Position Type: " + (!positionType.toString().isEmpty() && positionType != null
                ? positionType.toString() : "Data not available") + newLine +
                "Core Competency: " + (!coreCompetency.toString().isEmpty() && coreCompetency != null
                ? coreCompetency.toString() : "Data not available") + newLine;
    }

}
