<?php
$resultHtml = "";
$inputValue = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $text = $_POST["text"] ?? "";
    $inputValue = htmlspecialchars($text);

    $url = "http://localhost:8080/api/translate";

    $data = array("text" => $text);
    $jsonData = json_encode($data);

    $ch = curl_init($url);

    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonData);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        "Content-Type: application/json"
    ));

    curl_setopt($ch, CURLOPT_USERPWD, "rania:project2");

    $response = curl_exec($ch);

    if ($response === false) {
        $resultHtml = "<div class='error'>Error: " . htmlspecialchars(curl_error($ch)) . "</div>";
    } else {
        $decoded = json_decode($response, true);

        if (isset($decoded["translatedText"])) {
            $original = htmlspecialchars($decoded["originalText"]);
            $translated = htmlspecialchars($decoded["translatedText"]);
            $signature = htmlspecialchars($decoded["signature"]);

            $resultHtml = "
                <div class='card'>
                    <div class='row'><span>Original</span><p>$original</p></div>
                    <div class='row'><span>Translated</span><p>$translated</p></div>
                    <div class='row signature'>$signature</div>
                </div>
            ";
        } else {
            $resultHtml = "<div class='error'>Invalid response</div>";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>LLM Translator</title>

<style>
body {
    margin: 0;
    background: #0f0f0f;
    font-family: "Helvetica Neue", Arial, sans-serif;
    color: #fff;
}

/* Layout */
.container {
    max-width: 650px;
    margin: 100px auto;
    padding: 40px;
}

/* Header */
.brand {
    font-size: 14px;
    letter-spacing: 3px;
    color: #c9a96e;
    margin-bottom: 10px;
}

h1 {
    font-size: 32px;
    margin: 0 0 30px 0;
    font-weight: 500;
}

/* Form */
form {
    display: flex;
    gap: 10px;
    margin-bottom: 30px;
}

input {
    flex: 1;
    padding: 14px;
    border: 1px solid #333;
    background: #111;
    color: white;
    font-size: 14px;
}

input:focus {
    outline: none;
    border-color: #c9a96e;
}

button {
    padding: 14px 20px;
    background: #c9a96e;
    color: black;
    border: none;
    font-weight: bold;
    cursor: pointer;
}

button:hover {
    opacity: 0.9;
}

/* Result card */
.card {
    border: 1px solid #2a2a2a;
    padding: 20px;
    background: #141414;
}

.row {
    margin-bottom: 15px;
}

.row span {
    display: block;
    font-size: 12px;
    color: #888;
    margin-bottom: 5px;
    letter-spacing: 1px;
}

.row p {
    margin: 0;
    font-size: 16px;
}

.signature {
    margin-top: 20px;
    font-size: 13px;
    color: #c9a96e;
}

/* Error */
.error {
    color: #ff6b6b;
    margin-top: 20px;
}
</style>
</head>

<body>

<div class="container">

    <div class="brand">RANIA EL JEBARI</div>

    <h1>LLM Translator</h1>

    <form method="POST">
        <input 
            type="text" 
            name="text" 
            placeholder="Enter text to translate..." 
            value="<?php echo $inputValue; ?>"
            required
        >
        <button>Translate</button>
    </form>

    <?php echo $resultHtml; ?>

</div>

</body>
</html>