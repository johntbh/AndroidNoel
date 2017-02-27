package iut.paci.noelcommunity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

class DialogStore extends Dialog {
    DialogStore(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_store);
    }
}