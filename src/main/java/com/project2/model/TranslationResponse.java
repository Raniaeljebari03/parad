package com.project2.model;

public class TranslationResponse {

    private String sourceLanguage;
    private String targetLanguage;
    private String originalText;
    private String translatedText;
    private String signature; // small personal touch

    public TranslationResponse() {
    }

    public TranslationResponse(String sourceLanguage, String targetLanguage,
                               String originalText, String translatedText, String signature) {
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.originalText = originalText;
        this.translatedText = translatedText;
        this.signature = signature;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}