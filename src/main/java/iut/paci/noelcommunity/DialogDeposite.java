package iut.paci.noelcommunity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

class DialogDeposite extends Dialog {
    DialogDeposite(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_deposite);
    }
}