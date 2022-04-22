import java.util.List;

void serveCruises(List<Cruise> cruises) {
    
    ImList<Loader> loaders = new ImList<Loader>();

    if (cruises.size() == 0) {

    } else {

    int baseNumOfLoadersRequired = Math.max(1, cruises.get(0).getNumOfLoadersRequired());
    int count = 1;

    for (int num = 0; num < baseNumOfLoadersRequired; num++) {
        loaders = loaders.add(new Loader(count, cruises.get(0)).serve(cruises.get(0)));

        if (count % 3 == 0) {
            loaders = loaders.set(count - 1, new RecycledLoader(count, cruises.get(0)).serve(cruises.get(0)));
        }

        System.out.println(loaders.get(num));
        count++;
        
    }

    for (int i = 1; i < cruises.size(); i++) {

        int numOfLoadersRequired = cruises.get(i).getNumOfLoadersRequired();
        int falseCount = 0;

        for (int k = 0; k < loaders.size(); k++) {
            if (numOfLoadersRequired > 0 && loaders.get(k).canServe(cruises.get(i))) {

                int id = loaders.get(k).getIdentifier();
                
                if (id % 3 == 0) {
                    loaders = loaders.set(k, new RecycledLoader(id, cruises.get(i)).serve(cruises.get(i)));
                } else {
                    loaders = loaders.set(k, new Loader(id, cruises.get(i)).serve(cruises.get(i)));
                }

        	System.out.println(loaders.get(k));
                numOfLoadersRequired--;
            }

        }

            while (numOfLoadersRequired - loaders.size() > 0) {
                loaders = loaders.add(new Loader(count, cruises.get(i)).serve(cruises.get(i)));

                if (count % 3 == 0) {
                    loaders = loaders.set(count - 1, new RecycledLoader(count, cruises.get(i)).serve(cruises.get(i)));
                }

        	System.out.println(loaders.get(count - 1));
                count++;
                numOfLoadersRequired--;
            }

        for (int j = 0; j < loaders.size(); j++) {
            if (falseCount < loaders.size() && loaders.get(j).canServe(cruises.get(i)) == false) {
                falseCount++;
            }

                if (falseCount == loaders.size()) {
                    
                    while (numOfLoadersRequired > 0) {
                     
                        loaders = loaders.add(new Loader(count, cruises.get(i)).serve(cruises.get(i)));

                        if (count % 3 == 0) {
                            loaders = loaders.set(count - 1, new RecycledLoader(count, cruises.get(i)).serve(cruises.get(i)));
                        }

                        System.out.println(loaders.get(count - 1));
                        count++;
                        numOfLoadersRequired--;
                        falseCount++;
                   
                    }
                }
               
            }
        } 
    }
}
