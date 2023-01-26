import json
from flask import Flask, render_template
import requests
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/convert', methods=['POST'])
def convert():
    # Get the user's desired currency from the form
    currency = requests.form['currency']

    # Make API request and store response
    response = requests.get("https://openexchangerates.org/api/latest.json" + "?app_id=" + "a6b5d37646474c1b960f881472c93784")
    data = json.loads(response.text)

    # Get the exchange rate for USD to the user's desired currency
    exchange_rate = data["rates"][currency]

    # Render the conversion result template with the exchange rate
    return render_template('convert.html', exchange_rate=exchange_rate, currency=currency)

if __name__ == '__main__':
    app.run(debug=True)
