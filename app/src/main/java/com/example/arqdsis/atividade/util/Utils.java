package com.example.arqdsis.atividade.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

public class Utils {

    private static com.example.arqdsis.atividade.util.StatusTracker mStatusTracker = com.example.arqdsis.atividade.util.StatusTracker.getInstance();

    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                
                StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if(viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0,key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if(viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }
}




