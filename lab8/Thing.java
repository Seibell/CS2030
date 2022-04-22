interface Thing {

    String identify();

    String getState();

    Thing tick();

    Action getAction();

    int getNum();

    Thing setNumState(int num);
}
