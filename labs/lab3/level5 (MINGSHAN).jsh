void serveCruises(List<Cruise> cruises) {
    ImList<Loader> loaders = new ImList<Loader>();
    for (Cruise c : cruises) {
        int numOfLoadersServed = 0;
        for (Loader l : loaders) {
            if (l.canServe(c)) {
                Loader newLoader = l.serve(c);
                System.out.println(newLoader);
                loaders = loaders.set(l.getIdentifier() - 1, newLoader);
                numOfLoadersServed++;
            }

            if (numOfLoadersServed == c.getNumOfLoadersRequired()) {
                break;
            }
        }
        
        if (c.getNumOfLoadersRequired() > numOfLoadersServed) {
            for (int i = 0; i < c.getNumOfLoadersRequired() - numOfLoadersServed; i++) {
                Loader newLoader = new Loader(loaders.size() + 1, c);
                System.out.println(newLoader);
                loaders = loaders.add(newLoader);
            }
        }
    }
}
