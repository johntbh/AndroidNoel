package iut.paci.noelcommunity;

import java.util.Date;

class Deposite extends Place {
    int emptyCount;

    Deposite(int id, String name, double latitude, double longitude, Date openingTime, Date closingTime, int emptyCount) {
        super(id, name, latitude, longitude, openingTime, closingTime, R.layout.dialog_deposite, R.drawable.ic_delete_black_24dp);
        this.emptyCount = emptyCount;
    }
}
