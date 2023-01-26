from flask import Flask, request
import requests
import json

app = Flask(__name__)

@app.route('/convert')
def convert():
    input = request.args.get('input')
    # call API with the input and retrieve conversion rate
    api_response = requests.get(f'https://api.exchangerate-api.com/v4/latest/{input}')
    rate = api_response.json()['rates']['USD']
    return rate
