package com.project2.resource;

import com.project2.model.TranslationRequest;
import com.project2.model.TranslationResponse;
import com.project2.service.GeminiService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class TranslatorResource {

    private final GeminiService geminiService = new GeminiService();

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "LLM Translator Service is running!";
    }

    @POST
    @Path("translate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TranslationResponse translate(TranslationRequest request) {

        String input = request.getText();
        String translated = geminiService.translateText(input);

        return new TranslationResponse(
                "English",
                "Darija",
                input,
                translated,
                "Translated by Rania ✨"
        );
    }
}