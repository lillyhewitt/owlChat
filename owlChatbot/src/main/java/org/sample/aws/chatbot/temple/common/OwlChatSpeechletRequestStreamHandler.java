package owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

// This class is the handler for AWS Lambda function.
public class OwlChatSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> SUPPORTED_APPLICATION_IDS = new HashSet<>();
    static {
        SUPPORTED_APPLICATION_IDS.add("amzn1.ask.skill.81e128e4-dd7a-4585-aa16-e3d9b1459962");
    }

    public OwlChatSpeechletRequestStreamHandler() {
        super(new OwlChatSpeechlet(), SUPPORTED_APPLICATION_IDS);
    }    
}


