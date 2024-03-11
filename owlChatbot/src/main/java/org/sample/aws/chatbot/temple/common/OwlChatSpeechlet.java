package owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common;

/*
import src.main.java.org.slf4j.Logger;
import src.main.java.org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class OwlChatSpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(OwlChatSpeechlet.class);

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any initialization logic goes here
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return getWelcomeResponse();
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any cleanup logic goes here
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
        String character = intent.getSlot("character").getValue();

        if (OwlChatIntent.QUOTES_INTENT.equals(intentName)) {
            return getQuotesResponse(character);
        } else if (OwlChatIntent.PLANET_INTENT.equals(intentName)) {
            return getPlanetResponse(character);
        } else if (OwlChatIntent.LIGHTSABER_INTENT.equals(intentName)) {
            return getLightsaberResponse(character);
        } else if (OwlChatIntent.FORCE_SENSITIVE_INTENT.equals(intentName)) {
            return getForceSensitiveResponse(character);
        } else if (OwlChatIntent.FORCE_SIDE_INTENT.equals(intentName)) {
            return getForceSideResponse(character);
        } else {
            throw new SpeechletException("Invalid Intent: " + intentName);
        }
    }

    // Creates and returns a {@code SpeechletResponse} with a welcome message.
     //@return SpeechletResponse spoken and visual response for the given intent

    private SpeechletResponse getWelcomeResponse() {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getWelcomeResponse();
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    //Creates a {@code SpeechletResponse} for the help intent.

     //@return SpeechletResponse spoken and visual response for the given intent

    private SpeechletResponse getHelpResponse() {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getWelcomeResponse();
        return getSpeechletResponse(response.getSpeechText(), response.getTitle());
    }

    private SpeechletResponse getQuotesResponse(String character) {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getQuotesResponse(character);
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    private SpeechletResponse getPlanetResponse(String character) {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getPlanetResponse(character);
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    private SpeechletResponse getLightsaberResponse(String character) {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getLightsaberResponse(character);
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    private SpeechletResponse getForceSensitiveResponse(String name) {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getForceSensitiveResponse(name);
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    private SpeechletResponse getForceSideResponse(String name) {
        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse.getForceSideResponse(name);
        return getSpeechletResponseWithReprompt(response.getSpeechText(), response.getTitle());
    }

    private SimpleCard getCard(String title, String speechText) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle(title);
        card.setContent(speechText);
        return card;
    }

    private PlainTextOutputSpeech getSpeech(String speechText) {
        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return speech;
    }

    private SpeechletResponse getSpeechletResponse(String speechText, String title) {
        return SpeechletResponse.newTellResponse(getSpeech(speechText), getCard(speechText, title));
    }

    private SpeechletResponse getSpeechletResponseWithReprompt(String speechText, String title) {
        // Create the plain text output.
        PlainTextOutputSpeech speech = getSpeech(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, getCard(speechText, title));
    }
}

 */
