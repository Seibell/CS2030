class RegistryStub extends Registry {
    private static final String DEFAULT_ID = "";

    RegistryStub(String id) {
        super(id);
    }
    
    RegistryStub() {
        super(DEFAULT_ID);
    }
}
