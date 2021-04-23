package escaperooms.music;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.*;


public class MusicPlayer extends Thread{
    String song;
    long milliseconds;

    public MusicPlayer(String song, long milliseconds) {
        this.song = song;
        this.milliseconds = milliseconds;
    }
    public void run() {
        URL url = getClass().getResource(song);
        File file = new File(url.getPath());
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    static public void stopMusicIn(MusicPlayer musicPlayer, long stopTime) {
        try {
            Thread.sleep(stopTime);
        } catch (InterruptedException e) {
            musicPlayer.interrupt();
        }
        musicPlayer.interrupt();
    }

    static public void stopMusic(MusicPlayer musicPlayer) {
        musicPlayer.interrupt();
    }

    public void waitToDie() {
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}