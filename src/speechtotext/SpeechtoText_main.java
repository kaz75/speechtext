package speechtotext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;

public class SpeechtoText_main {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpeechToText service = new SpeechToText();
		    service.setUsernameAndPassword("1618037", "1618037");

		    File audio = new File("audio/katou.wav");
		    RecognizeOptions options = null;
				   try {
					   options = new RecognizeOptions.Builder()
						.model("ja-JP_BroadbandModel")
					    .audio(audio)
				        .contentType(RecognizeOptions.ContentType.AUDIO_WAV)
				        .build();
				   } catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   SpeechRecognitionResults transcript = service.recognize(options).execute();
					   
					   System.out.println(transcript);
			}
		private static void writeToFile(InputStream in, File file) {
			   try {
			     OutputStream out = new FileOutputStream(file);
			     byte[] buf = new byte[1024];
			     int len;
			     while ((len = in.read(buf)) > 0) {
			       out.write(buf, 0, len);
			     }
			     out.close();
			     in.close();
			   } catch (Exception e) {
			     e.printStackTrace();
			   }
			 }

	}
