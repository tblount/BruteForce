package com.escaperooms.music;

import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.*;


public class MusicPlayer extends Thread{
    String song;
    Clip clip;

    public MusicPlayer(String song) {
        this.song = song;
    }
    public void run() {
        try {
            URL url = MusicPlayer.class.getResource("/resources/" + song);
            AudioInputStream audioStream;
            audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
            {
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stopMusic() {
        clip.stop();
        this.interrupt();
    }

    public void waitToDie() {
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}