/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu4java.minitennis8;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {
	public static void main(String[] args) throws Exception {

//		System.out.println("1");
//		URL url = new URL("https://ia800504.us.archive.org/33/items/TetrisThemeMusic/Tetris.mp3");
//              
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//		URL url = new URL(""C:\Users\mohamed.mohamoud1\Documents\Tetris.mp3"");

		URL url = Sound.class.getResource("mainmusic.wav");
		AudioClip clip = Applet.newAudioClip(url);
		AudioClip clip2 = Applet.newAudioClip(url);
		clip.play();
		Thread.sleep(1000);
		clip2.loop();
		Thread.sleep(20000);
		clip2.stop();
		
		System.out.println("end");
	}
}
