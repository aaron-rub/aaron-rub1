import requests
import json

# API endpoint and key
api_endpoint = "https://openexchangerates.org/api/latest.json"
api_key = "a6b5d37646474c1b960f881472c93784"

# Make API request and store response
response = requests.get(api_endpoint + "?app_id=" + api_key)
data = json.loads(response.text)

# Print exchange rate for USD to EUR
print("1 USD is equal to", data["rates"]["EUR"], "EUR")
# print("1 USD is equal to", data["rates"]["CNY"], "CNY")
# print("1 USD is equal to", data["rates"]["JPY"], "JPY")
# print("1 USD is equal to", data["rates"]["CHF"], "CHF")
# print("1 USD is equal to", data["rates"]["PHP"], "PHP")
# print("1 USD is equal to", data["rates"]["JMD"], "JMD")
# print("1 USD is equal to", data["rates"]["INR"], "INR")
# print("1 USD is equal to", data["rates"]["MXN"], "MXN")
