package iut.paci.noelcommunity;

import java.util.Date;

class Store extends Place {
    int treeCount;

    Store(int id, String name, double latitude, double longitude, Date openingTime, Date closingTime, int treeCount) {
        super(id, name, latitude, longitude, openingTime, closingTime);
        this.treeCount = treeCount;
    }
}
