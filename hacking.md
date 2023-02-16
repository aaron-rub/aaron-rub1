<html>
  <head>
    <title>Exchange Rate Calculator</title>
    <script> 
      function calculateExchangeRate() {
        // Get the user's desired currency
        var currency = document.getElementById("currency").value;
        // Make API request and store response
        var api_endpoint = "https://openexchangerates.org/api/latest.json";
        var api_key = "a6b5d37646474c1b960f881472c93784";
        var response = new XMLHttpRequest();
        response.open("GET", api_endpoint + "?app_id=" + api_key, false);
        response.send();
        // Parse the API response
        var data = JSON.parse(response.responseText);
        // Calculate the exchange rate for USD to the user's desired currency
        var exchangeRate = data["rates"][currency];
        // Update the output div with the exchange rate
        document.getElementById("output").innerHTML = "1 USD is equal to " + exchangeRate + " " + currency;
        // Update the outCurrency span with the user's desired currency
        document.getElementById("outCurrency").innerHTML = currency;
      }
  </script>
  </head>
  <body onload="calculateExchangeRate()">
    <h1>Exchange Rate Calculator</h1>
    <form>
      <label for="currency">Enter Currency:</label>
      <input type="text" id="currency" name="currency">
      <br><br>
      <input id="inCurrency" type="button" value="Submit" onclick="calculateExchangeRate()">
    </form>
    <div id="output"></div>
    <h1>
      the value for currency is:
      <span id="outCurrency"></span>
    </h1>
  </body>
</html>

``` python
from flask import Flask, request
import requests
import json 

# API endpoint and key.
api_endpoint = "https://openexchangerates.org/api/latest.json"
api_key = "a6b5d37646474c1b960f881472c93784"

# Make API request and store response
response = requests.get(api_endpoint + "?app_id=" + api_key)
data = json.loads(response.text)

# Prompt user for desired currency
currency = input("Enter the currency you want to exchange to (e.g. EUR): ")

# Print exchange rate for USD to user's desired currency
print("1 USD is equal to", data["rates"][currency], currency)
```