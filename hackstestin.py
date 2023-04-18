import requests
import json
import os.path
from datetime import datetime, timedelta

# API endpoint and key
api_endpoint = "https://openexchangerates.org/api/latest.json"
api_key = "a6b5d37646474c1b960f881472c93784"

response = requests.get(api_endpoint + "?app_id=" + api_key)
data = json.loads(response.text)
currencies = list(data["rates"].keys())


cache_file = "exchange_rates.json"
# Checks if the cache file exists and if it is less then 1 hour in age 
if os.path.exists(cache_file):
    with open(cache_file, "r") as f:
        cache = json.load(f)
    last_update = datetime.fromisoformat(cache["timestamp"])
    if datetime.now() - last_update < timedelta(hours=1):
        rates = cache["rates"]
else:
    rates = None
# Code states that IF the currency conversion chart is not up to date, then fetch new data from the API
if not rates:
    response = requests.get(api_endpoint + "?app_id=" + api_key)
    data = json.loads(response.text)
    rates = data["rates"]

    # Saves timestamp and current conversion rates to json file
    with open(cache_file, "w") as f:
        json.dump({"timestamp": datetime.now().isoformat(), "rates": rates}, f)

print("Here are the available currencies:")
print(currencies)

while True:
    try:
        amount = float(input("Enter the amount to convert: "))
    except ValueError:
        print("Invalid amount. Please enter a valid number.")
        continue
    source_currency = input("Enter the source currency code (e.g. USD): ").upper()
    if not source_currency or source_currency not in rates:
        print("Invalid source currency code. Please enter a valid code.")
        continue
    target_currency = input("Enter the target currency code (e.g. EUR): ").upper()
    if not target_currency or target_currency not in rates:
        print("Invalid target currency code. Please enter a valid code.")
        continue
    break

# Conversion from source to target currency
source_rate = rates[source_currency]
target_rate = rates[target_currency]
target_amount = amount * target_rate / source_rate

print("{:.2f} {} is equal to {:.2f} {}".format(amount, source_currency, target_amount, target_currency))
