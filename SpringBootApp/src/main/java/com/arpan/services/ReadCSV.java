package com.arpan.services;

import org.springframework.stereotype.Service;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.*;

@Service
public class ReadCSV {

	public void convertToMP4(File wav, String download)
			throws Exception {
		File target = new File(download);
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp4");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		encoder.encode(wav, target, attrs);
	}

}
