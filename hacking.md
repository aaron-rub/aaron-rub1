
<!DOCTYPE html>
<html>
  <head>
    <title>Conversion Result</title>
  </head>
  <body>
    <h1>Conversion Result</h1>
    <p>1 USD is equal to {{ exchange_rate }} {{ currency }}</p>
  </body>
</html>


<!DOCTYPE html>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
    <h1>Currency Converter</h1>
    <form action="/convert" method="post">
      <label for="currency">Enter the currency you want to convert to (e.g. EUR):</label>
      <input type="text" id="currency" name="currency">
      <input type="submit" value="Convert">
    </form>
  </body>
</html>