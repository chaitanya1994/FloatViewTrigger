package com.example.chaitanya.floatview;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.ImageView;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by chaitanya on 30/03/16.
 */
public class FloatingService extends Service implements FloatingViewListener {
    @Override
    public void onFinishFloatingView() {
        stopSelf();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createFloatingIcon();
    }

    private void createFloatingIcon() {
        final ImageView iconView = new ImageView(this);
        iconView.setImageResource(R.drawable.chat_heads_icon);


        FloatingViewManager floatingViewManager = new FloatingViewManager(this, this);
        floatingViewManager.setFixedTrashIconImage(R.drawable.icon_trash);
        floatingViewManager.setActionTrashIconImage(R.drawable.icon_trash);
        final FloatingViewManager.Options options = new FloatingViewManager.Options();
        options.shape = FloatingViewManager.SHAPE_CIRCLE;
        floatingViewManager.addViewToWindow(iconView, options);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
