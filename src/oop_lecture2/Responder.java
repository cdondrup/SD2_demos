package oop_lecture2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings and a list of default responses. If any of the input words is found
 * in the HashMap, the corresponding response is returned. If none of the input
 * words is recognized, one of the default responses is randomly chosen.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2011.07.31)
 */
public class Responder
{
    // Used to map key words to responses.
    private ArrayList<String> responses;
    // Default responses to use if we don't recognise a word.
    private Random randomGenerator;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<String>();
        fillResponses();
    }


    /**
     * Randomly select and return one of the default responses.
     * @return     A random response
     */
    public String generateResponse()
    {
        // Pick a random number for the index in the default response list.
        // The number will be between 0 (inclusive) and the size of the list (exclusive).
        int index = randomGenerator.nextInt(responses.size());
        return responses.get(index);
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponses()
    {
        responses.add("That sounds odd. Could you describe that problem in more detail?");
        responses.add("No other customer has ever complained about this before. \n" +
                             "What is your system configuration?");
        responses.add("That sounds interesting. Tell me more...");
        responses.add("I need a bit more information on that.");
        responses.add("Have you checked that you do not have a dll conflict?");
        responses.add("That is explained in the manual. Have you read the manual?");
        responses.add("Your description is a bit wishy-washy. Have you got an expert\n" +
                             "there with you who could describe this more precisely?");
        responses.add("That's not a bug, it's a feature!");
        responses.add("Could you elaborate on that?");
    }

}
