package com.project2.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GeminiService {

    public String translateText(String text) {
        try {
            Client client = new Client();

            String prompt = "Translate the following English text into natural Moroccan Darija. "
                    + "Return only the translation, with no explanation:\n" + text;

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            prompt,
                            null
                    );

            return response.text();

        } catch (Exception e) {
            return "Error calling Gemini API: " + e.getMessage();
        }
    }
}