import requests
import json
#  endpoint & key
api_endpoint = "https://openexchangerates.org/api/latest.json"
api_key = "a6b5d37646474c1b960f881472c93784"
# Making list of common currencies to be converted
valid_currencies = ["USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "HKD"]
# Prompts user to put in currency that is requested to be coverted and what they wish to be coverted to
while True:
    base_currency = input("Enter the base currency (e.g. USD): ")
    if base_currency.upper() not in valid_currencies:
        print("Invalid currency code. Please try again.")
        continue
    break
    
while True:
    desired_currency = input("Enter the desired currency (e.g. EUR): ")
    if desired_currency.upper() not in valid_currencies:
        print("Invalid currency code. Please try again.")
        continue
    break

# API req & store response
response = requests.get(api_endpoint + "?app_id=" + api_key)
data = json.loads(response.text)

# fucntion that coverts the inputed currency
def convert_currency(base_currency, desired_currency, amount):
    if base_currency == "USD":
        exchange_rate = data["rates"][desired_currency]
        converted_amount = amount * exchange_rate
        return converted_amount
    else:
        base_rate = data["rates"][base_currency]
        desired_rate = data["rates"][desired_currency]
        exchange_rate = desired_rate / base_rate
        converted_amount = amount * exchange_rate
        return converted_amount

# Ask the amount they want to be coverted
while True:
    amount_str = input("Enter the amount to convert: ")
    try:
        amount = float(amount_str)
        break
    except ValueError:
        print("Invalid input. Please enter a number.")

# Conversion then output 
result = convert_currency(base_currency.upper(), desired_currency.upper(), amount)
print("{:.2f} {} is equal to {:.2f} {}".format(amount, base_currency.upper(), result, desired_currency.upper()))
