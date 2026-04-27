package com.sos.blinksoundwidget;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class SoundPlayer {
    private static final Set<MediaPlayer> ACTIVE_PLAYERS = Collections.synchronizedSet(new HashSet<>());

    private SoundPlayer() {
        // Utility class.
    }

    public static void play(Context context) {
        Context appContext = context.getApplicationContext();
        MediaPlayer player = MediaPlayer.create(appContext, R.raw.blink_sound);
        if (player == null) {
            return;
        }

        ACTIVE_PLAYERS.add(player);

        player.setOnCompletionListener(mediaPlayer -> release(mediaPlayer));
        player.setOnErrorListener((mediaPlayer, what, extra) -> {
            release(mediaPlayer);
            return true;
        });

        player.start();
    }

    private static void release(MediaPlayer player) {
        ACTIVE_PLAYERS.remove(player);
        try {
            player.release();
        } catch (RuntimeException ignored) {
            // Already released or in an invalid state.
        }
    }
}
