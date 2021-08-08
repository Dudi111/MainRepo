package com.example.progressbarthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerThread extends HandlerThread {
    private Handler mainhandler;

    public WorkerThread(String name, Handler mainhandler) {
        super(name);
        this.mainhandler=mainhandler;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress=0;
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
                progress=progress+10;
                Message message=Message.obtain();
                message.obj=progress;
                mainhandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
