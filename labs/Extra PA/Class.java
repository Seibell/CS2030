abstract class Class {
    private final String moduleCode;
    private final int classID;
    private final String venueID;
    private final int startTime;
    private final Instructor instructor;

    Class(String moduleCode, int classID, String venueID, Instructor instructor,
            int startTime) {
        this.moduleCode = moduleCode;
        this.classID = classID;
        this.venueID = venueID;
        this.startTime = startTime;
        this.instructor = instructor;
    }

    public String getModule() {
        return this.moduleCode;
    }

    public String getVenueID() {
        return this.venueID;
    }

    public int getClassID() {
        return this.classID;
    }

    Instructor getInstructor() {
        return this.instructor;
    }

    int getTime() {
        return this.startTime;
    }

    boolean clashWith(Class other) {
        if (this.hasSameModule(other) == false &&
                this.hasSameVenue(other) == false &&
                this.hasSameInstructor(other) == false) {
            return false;
        }

        if (this.getClassType() == "tut" && other.getClassType() == "tut") {
            if (this.hasSameInstructor(other) == false && this.hasSameVenue(other) == false) {
                return false;
            }
        }
        if (this.getEndTime() <= other.getTime() || this.getTime() >= other.getEndTime()) {
            return false;
        }
        return true;
    }

    abstract String getClassType();

    abstract int getEndTime();

    abstract boolean hasSameModule(Class other);
    abstract boolean hasSameInstructor(Class other);
    abstract boolean hasSameVenue(Class other);

}
