class Lecture extends Class {
    
    private static final int duration = 2;

    Lecture(String moduleCode, int classID, String venueID, 
            Instructor instructor, int startTime) {
        super(moduleCode, classID, venueID, instructor, startTime);
    }

    @Override
    String getClassType() {
        return "lec";
    }

    @Override
    int getEndTime() {
        return this.getTime() + duration;
    }

    @Override
    boolean hasSameModule(Class l) {
        return this.getModule() == l.getModule();
    }

    @Override
    boolean hasSameInstructor(Class l) {
        return this.getInstructor().equals(l.getInstructor());
    }

    @Override
    boolean hasSameVenue(Class l) {
        return this.getVenueID() == l.getVenueID();
    }

    /*
    @Override
    public String toString() {
        return String.format("%s L%d @ %s [%s] %d--%d", this.getModule(), this.getClassID(),
                this.getVenueID(), this.getInstructor().toString(), this.getTime(),
                this.getTime() + duration);
    }
    */
}
