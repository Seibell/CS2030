class RegisteredToken extends Token {
    
    private final Registry registry;
    private static final String TEST_CONTACT_MESSAGE = "Test Contact";

    RegisteredToken(Token t, Registry registry) {
        super(t);
        this.registry = registry;
    }

    void contact() {
        registry.store(TEST_CONTACT_MESSAGE);
    }
}
