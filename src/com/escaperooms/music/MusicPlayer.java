package com.escaperooms.music;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;


public class MusicPlayer extends Thread{
    String song;
    Clip clip;

    public MusicPlayer(String song) {
        this.song = song;
    }
    public void run() {
        URL url = getClass().getResource(song);
        File file = new File(url.getPath());
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
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