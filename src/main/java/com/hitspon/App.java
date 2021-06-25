package com.hitspon;

import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;



/**
 * App world!
 */
public final class App {
    private App() {
    }

    /**
     * Says App to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception {        
        String apiHost = "https://run.mocky.io/v3/045eab51-9675-40b4-a2c2-4577d7f1e488";
        String apiKey = "";
        String charSet = "UTF-8";
        // Params
        String params = "test";
        // Format query for preventing encoding problems
        String query = String.format("s=%S", URLEncoder.encode(params, charSet));

        
        HttpResponse<JsonNode> httpResponse = Unirest.get(apiHost)
                                                     //.header("api-key", "value")
                                                     .asJson();
        System.out.println(httpResponse.getStatus());
        System.out.println(httpResponse.getHeaders().get("Content-Type"));

        // Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(httpResponse.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.print(prettyJsonString);


        
        


    }
}
