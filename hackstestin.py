from flask import Flask, request
import requests
import json

# API endpoint and key
api_endpoint = "https://openexchangerates.org/api/latest.json"
api_key = "a6b5d37646474c1b960f881472c93784"

# Prompt user for desired currency
currency = input("Enter the currency you want to exchange to (e.g. EUR): ")

# Make API request and store response
response = requests.get(api_endpoint + "?app_id=" + api_key)
data = json.loads(response.text)

# Print exchange rate for USD to user's desired currency
print("1 USD is equal to", data["rates"][currency], currency)
