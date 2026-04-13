import requests

URL = "http://localhost:8080/api/translate"
USERNAME = "rania"
PASSWORD = "project2"


def translate_text(text):
    try:
        response = requests.post(
            URL,
            json={"text": text},
            auth=(USERNAME, PASSWORD),
            timeout=30
        )

        if response.status_code == 200:
            data = response.json()
            print("\nOriginal Text:", data.get("originalText"))
            print("Translated Text:", data.get("translatedText"))
            print("Signature:", data.get("signature"))
        else:
            print("Error:", response.status_code)
            print(response.text)

    except Exception as e:
        print("Connection error:", str(e))


if __name__ == "__main__":
    print("=== LLM Translator Python Client ===")

    while True:
        text = input("\nEnter text to translate (or type 'exit'): ").strip()

        if text.lower() == "exit":
            print("Goodbye.")
            break

        if not text:
            print("Please enter some text.")
            continue

        translate_text(text)