class Tutorial extends Class {
    
    private static final int duration = 1;

    Tutorial(String moduleCode, int classID, String venueID, 
            Instructor instructor, int startTime) {
        super(moduleCode, classID, venueID, instructor, startTime);
    }

    @Override
    String getClassType() {
        return "tut";
    }

    @Override
    int getEndTime() {
        return this.getTime() + duration;
    }

    @Override
    boolean hasSameModule(Class t) {
        return this.getModule() == t.getModule();
    }

    @Override
    boolean hasSameInstructor(Class t) {
        return this.getInstructor().equals(t.getInstructor());
    }

    @Override
    boolean hasSameVenue(Class t) {
        return this.getVenueID() == t.getVenueID();
    }

    /*
    @Override
    public String toString() {
        return String.format("%s T%d @ %s [%s] %d--%d", this.getModule(), this.getClassID(),
                this.getVenueID(), this.getInstructor().toString(), this.getTime(),
                this.getTime() + duration);
    }
    */
}
