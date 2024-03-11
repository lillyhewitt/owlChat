package owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common;

import java.io.*;

public class OwlChatResponse {
    public static void main(String[] args) {
        System.out.println("Owl Chat opened.");
    }
}

/*
import src.main.java.org.sample.aws.chatbot.temple.db.OwlChatCharacter;
import src.main.java.org.sample.aws.chatbot.temple.db.DBUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse {
    String speechText;
    String title;
    Map<String, String> sessionAttributes;

    private static final String help = "You can ask quotes, lightsaber color, Jedi or Sith questions.";

    public owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(String speechText, String title) {
        this.speechText = speechText;
        this.title = title;
        sessionAttributes = new HashMap<>();
    }

    public String getSpeechText() {
        return speechText;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, String> getSessionAttributes() {
        return sessionAttributes;
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getWelcomeResponse() {
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse("Welcome to Owl Chat Chatbot!" + help, "Owl Chat Welcome");
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getHelpResponse() {
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(help, "Owl Chat Help");
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getPlanetResponse(String name) {
        OwlChatCharacter character = DBUtil.getCharacter(name);

        String speechText;

        if (character != null && character.getName() != null) {
            String planet = character.getPlanet();

            if (null == planet || planet.equals("")) {
                speechText = character.getName() + "'s planet is not known";
            } else {
                speechText = character.getName() + " is from the planet " + planet;
            }
        } else {
            speechText = "Are you sure " + name + " was in Star Wars?";
        }

        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Planet");
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getLightsaberResponse(String name) {
        OwlChatCharacter character = DBUtil.getCharacter(name);

        String speechText;

        if (character != null && character.getName() != null) {
            if (null == character.getLightsaberColor()) {
                speechText = character.getName() + " does not have a lightsaber";
            } else {
                speechText = character.getName() +
                        "'s ligthsaber is " +
                        character.getLightsaberColor();
            }
        } else {
            speechText = "Are you sure " + name + " was in Star Wars?";
        }
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Lightsaber");
    }


    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getQuotesResponse(String name) {
        OwlChatCharacter character = DBUtil.getCharacter(name);

        String speechText;

        if (character != null && character.getName() != null) {
            List<String> list = character.getQuotes();
            Random random = new Random();
            speechText = "Here is a quote from " +
                    character.getName() +
                    ": \"" +
                    list.get(random.nextInt(list.size())) +
                            "\"";
        } else {
            speechText = "Are you sure " + name + " was in Star Wars?";
        }

        // Create the Simple card content.
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Quotes");
    }


    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getForceSensitiveResponse(String name) {
        OwlChatCharacter character = DBUtil.getCharacter(name);

        String speechText;

        if (character != null && character.getName() != null) {
            speechText = (character.isForceSensitive() ? "Yes, " : "No, ") +
                    character.getName() +
                    " is " + (character.isForceSensitive() ? "" : " not ") +
                    " sensitive to the Force.";
        } else {
            speechText = "Are you sure " + name + " was in Star Wars?";
        }

        // Create the Simple card content.
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Force Sensitive");
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getForceSideResponse(String name) {
        OwlChatCharacter character = DBUtil.getCharacter(name);

        String speechText;

        if (character != null && character.getName() != null) {
            if (character.isForceSensitive()) {
                speechText = character.getName() +
                        " is on the " +
                        character.getForceSide() +
                        " side, and so is a " +
                        (character.getForceSide().equals("light") ? "Jedi" : "Sith");
            } else {
                speechText = character.getName() + " is not sensitive to the Force";
            }
        } else {
            speechText = "Are you sure " + name + " was in Star Wars?";
        }

        // Create the Simple card content.
        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Force Side");
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getDialogueQuestion() {
        OwlChatCharacter character = DBUtil.getRandomCharacter();
        List<String> list = character.getQuotes();

        Random random = new Random();
        String speechText = "Who said \"" + list.get(random.nextInt(list.size())) + "\"";

        owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse response = new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Quote Question");
        response.sessionAttributes.put("character", character.getName());
        response.sessionAttributes.put("question", speechText);

        return response;
    }

    public static owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse getDialogueResponse() {
        String speechText = "Yep, you're right!";

        return new owlChatbot.src.main.java.org.sample.aws.chatbot.temple.common.OwlChatResponse(speechText, "Star Wars Quote Response");
    }
}
 */
