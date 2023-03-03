<!DOCTYPE html>
<html>
<head>
  <title>Stock News</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
    /* Add some basic styles to make the page look nicer */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f2f2f2;
    }
    h1 {
      text-align: center;
      margin-top: 20px;
    }
    .news-item {
      background-color: #fff;
      padding: 10px;
      margin: 10px;
      border-radius: 5px;
    }
    .news-item h2 {
      font-size: 18px;
      margin: 0 0 5px 0;
    }
    .news-item p {
      font-size: 14px;
      margin: 0;
    }
  </style>
</head>
<body>
  <h1>Stock News</h1>
  <div id="news-container"></div>
  
  <script>
    // Set the stock symbol you want to get news for
    const stockSymbol = 'AAPL';

    // Define the Yahoo Finance API endpoint URL
    const apiUrl = `https://apidojo-yahoo-finance-v1.p.rapidapi.com/news/list?category=${stockSymbol}&region=US`;

    // Define the headers for the API request
    const headers = {
      'x-rapidapi-key': 'a887a57462msh889608deb83b3ddp11d368jsnce0092f67d7a',
      'x-rapidapi-host': 'apidojo-yahoo-finance-v1.p.rapidapi.com'
    };

    // Make the API request using jQuery's ajax method
    $.ajax({
      url: apiUrl,
      type: 'GET',
      headers: headers,
      success: function(data) {
        // Loop through the news items and create HTML elements to display them
        const newsContainer = $('#news-container');
        for (let i = 0; i < data.items.length; i++) {
          const newsItem = data.items[i];
          const newsItemElement = $('<div>').addClass('news-item');
          newsItemElement.append($('<h2>').text(newsItem.title));
          newsItemElement.append($('<p>').text(newsItem.summary));
          newsItemElement.append($('<p>').text(newsItem.pubDate));
          newsContainer.append(newsItemElement);
        }
      },
      error: function(err) {
        console.log(err);
      }
    });
  </script>
</body>
</html>
