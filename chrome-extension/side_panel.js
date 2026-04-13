document.addEventListener("DOMContentLoaded", () => {
  const originalDiv = document.getElementById("original");
  const resultDiv = document.getElementById("result");
  const button = document.getElementById("translateBtn");

  let selectedText = "";

  chrome.storage.local.get(["selectedText"], (data) => {
    if (data && data.selectedText) {
      selectedText = data.selectedText;
      originalDiv.textContent = "Text: " + selectedText;
    } else {
      originalDiv.textContent = "No text selected yet.";
    }
  });

  button.addEventListener("click", async () => {
    if (!selectedText.trim()) {
      resultDiv.textContent = "Please select text first.";
      return;
    }

    resultDiv.textContent = "Translating...";

    try {
      const response = await fetch("http://localhost:8080/api/translate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Basic " + btoa("rania:project2")
        },
        body: JSON.stringify({ text: selectedText })
      });

      if (!response.ok) {
        const errorText = await response.text();
        resultDiv.textContent = "Error: " + errorText;
        return;
      }

      const data = await response.json();
      resultDiv.textContent = "Result: " + data.translatedText;
    } catch (error) {
      resultDiv.textContent = "Error: " + error.message;
    }
  });
});