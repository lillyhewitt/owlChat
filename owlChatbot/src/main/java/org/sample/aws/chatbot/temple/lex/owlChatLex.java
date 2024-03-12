package org.sample.aws.chatbot.temple.lex;

/*
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.sample.aws.chatbot.starwars.common.StarWarsIntent;
import org.sample.aws.chatbot.starwars.common.StarWarsResponse;
import org.sample.aws.lex.request.LexRequest;
import org.sample.aws.lex.response.DialogAction;
import org.sample.aws.lex.response.LexResponse;
import org.sample.aws.lex.response.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 */

import java.util.Map;

public class owlChatLex { }
    //implements RequestHandler<LexRequest, LexResponse> {

    /*
    private static final System.Logger log = LoggerFactory.getLogger(OwlChatLex.class);

    @Override
    public LexResponse handleRequest(LexRequest request, Context context) {
        log.info("onIntent requestId={} intent={}", context.getAwsRequestId(), request.getCurrentIntent().getName());

        String intent = request.getCurrentIntent().getName();
        String character = request.getCurrentIntent().getSlots().get("character");

        if (StarWarsIntent.QUOTES_INTENT.equals(intent)) {
            return getQuotesResponse(character);
        } else if (StarWarsIntent.PLANET_INTENT.equals(intent)) {
            return getPlanetResponse(character);
        } else if (StarWarsIntent.LIGHTSABER_INTENT.equals(intent)) {
            return getLightsaberResponse(character);
        } else if (StarWarsIntent.FORCE_SENSITIVE_INTENT.equals(intent)) {
            return getForceSensitiveResponse(character);
        } else if (StarWarsIntent.FORCE_SIDE_INTENT.equals(intent)) {
            return getForceSideResponse(character);
        } else if (StarWarsIntent.QUESTION_INTENT.equals(intent)) {

            String actualCharacter = request.getInputTranscript();

            if (request.getSessionAttributes() == null)
                throw new RuntimeException("Session attributes are null");
            String expectedCharacter = request.getSessionAttributes().get("character");
            String question = request.getSessionAttributes().get("question");

            System.out.println("expected/character: " + expectedCharacter);
            System.out.println("actual: " + actualCharacter);
            System.out.println("question: " + question);

            if (null != expectedCharacter &&
                    null != actualCharacter &&
                    expectedCharacter.toLowerCase().equals(actualCharacter.toLowerCase())) {
                return getDialogueResponse();
            } else {
                return getDialogueQuestion(request.getSessionAttributes());
            }
        } else {
            throw new RuntimeException("Invalid Intent: " + request.getCurrentIntent().getName());
        }
    }

    private LexResponse getHelpResponse() {
        OwlChatResponse response = OwlChatResponse.getHelpResponse();
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getQuotesResponse(String name) {
        OwlChatResponse response = OwlChatResponse.getQuotesResponse(name);
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getPlanetResponse(String name) {
        OwlChatResponse response = OwlChatResponse.getPlanetResponse(name);
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getLightsaberResponse(String name) {
        OwlChatResponse response = OwlChatResponse.getLightsaberResponse(name);
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getForceSensitiveResponse(String name) {
        OwlChatResponse response = OwlChatResponse.getForceSensitiveResponse(name);
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getForceSideResponse(String name) {
        OwlChatResponse response = OwlChatResponse.getForceSideResponse(name);
        return getLexResponse(response.getSpeechText(), response.getTitle());
    }

    private LexResponse getDialogueQuestion(Map<String, String> sessionAttributes) {
        System.out.println("getDialogueQuestion");

        LexResponse lexResponse = new LexResponse();

        String answered = "";
        String question = "";

        if (sessionAttributes != null) {
            answered = sessionAttributes.get("answered");
            question = sessionAttributes.get("question");
        }

        if ((null == question) ||
                (null != answered && answered.equals("yes"))) {
            System.out.println("Getting a new question");
            StarWarsResponse response = StarWarsResponse.getDialogueQuestion();
            String character = response.getSessionAttributes().get("character");
            question = response.getSessionAttributes().get("question");

            lexResponse.addAttribute("character", character);
            lexResponse.addAttribute("question", question);
            lexResponse.addAttribute("answered", "no");
        }

        DialogAction dialogAction = new DialogAction();
        dialogAction.setType(DialogAction.ELICIT_SLOT_TYPE);
        Message message = new Message();
        message.setContentType(Message.CONTENT_TYPE_PLAIN_TEXT);
        message.setContent(question);
        dialogAction.setMessage(message);
        dialogAction.setIntentName(StarWarsIntent.QUESTION_INTENT);
        dialogAction.setSlotToElicit("AnswerSlot");
        dialogAction.addSlots("AnswerSlot", "");

        lexResponse.setDialogAction(dialogAction);

        return lexResponse;
    }

    private LexResponse getDialogueResponse() {
        OwlChatResponse response = OwlChatResponse.getDialogueResponse();
        LexResponse lexResponse = getLexResponse(response.getSpeechText(), response.getTitle());
        lexResponse.addAttribute("answered", "yes");
        lexResponse.clearAttributes();
        return lexResponse;
    }

    private LexResponse getLexResponse(String speechText, String title) {
        Message message = new Message(Message.CONTENT_TYPE_PLAIN_TEXT, speechText);
        DialogAction dialogAction = new DialogAction(DialogAction.CLOSE_TYPE, DialogAction.FULFILLMENT_STATE_FULFILLED, message);

        return new LexResponse(dialogAction);
    }
}


     */

