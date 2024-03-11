<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">

<style>
*{
	
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	margin:0;
	padding: 0;
}
body{
	background-color: #ffffff;
	margin: 0;
	padding: 0;
}
.logo{
  color: rgb(255, 255, 255);
  border: 2px solid rgb(255, 255, 255);
  letter-spacing: 10px;
  display: inline;
  text-transform: uppercase;
  font-size: 30px;
  padding: 9px 12px;
  float: center
}


.main_element{
	background-color: #080808;
	color: rgb(2, 2, 2);
	width: 100%;
	height: 70px;
  line-height: 70px;
  padding: 0 50px;
}



ul{
	list-style-type: none;
  float: right;
}
.main_element > ul >li{
  padding: 0 30px;
  display: block;
  float: left;
  height: 70px;
  position: relative;
}
.main_element > ul >li:hover{
  background-color: #000000;

}
a:hover{
    color: rgb(255, 255, 255);
}
/*************************************************/
.inside_items{
  display: none;
  position: absolute;
  top:70px;
  left: 0px;
  
}
.inside_items li{
  width: 200px;
  height: 50px;
  line-height: 50px;
  padding: 0 30px;
  background-color: #6a6a6a;
}
.inside_items li:hover{
  background-color: #6d6d6d;
}
li:hover .inside_items{
  display: block;
}
a{
	text-decoration: none;
	color:rgb(243, 243, 243);
	font-size: 25px;
}
.show::after{
      content: '';
      width: 0;
      height: 0;
      border-left: 7px solid transparent;
      border-right: 7px solid transparent;
      border-top: 9px solid black;
      position: absolute;
      top: 35px;
      right:8px;
}
/********************************************************/
.father{
  position: relative;
}
.inside_items2
{
  display: none;
  position: absolute;
  left: 200px;
 }
.father:hover .inside_items2{
  display: inline-block;
}
.father::after{
      content: '';
      width: 0;
      height: 0;
      border-left: 7px solid transparent;
      border-right: 7px solid transparent;
      border-top: 9px solid black;
      position: absolute;
      top: 25px;
      right:40px;
}
.inside_items2 li{
  border-bottom: black 1px solid;
}
.inside_items2 li{
  font-size: 15px;
}
.inside_items2 li:hover{
  background-color:  #726767;
}
.inside_items2 li:hover a{
  color: white;
}
/***********************************************************/
.text{
  text-transform: uppercase;
  display: inline-block;
  font-size: 100px;
  color: #ffffff;
  width: 100%;
  text-align: center;
  margin:20px 0;
  font-family: 'Staatliches', cursive;
  letter-spacing: 20px;}
</style>

<body translate="no">
  <html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="nav.css">
	<link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
	<title>awesome nav bar with me</title>
</head>
<body>
	<nav class="main_element">
    <p class="logo"> Account Total: $<span id="accountTotal">0</span></p>
	</nav>
  </nav>
</body>
</html>
  
      <script id="rendered-js" >
/* pure css*/
//# sourceURL=pen.js
    </script>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    /* Add your CSS styles here */
  </style>
  <!-- Include Chart.js library -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>



  <div class="car">
    <h2> <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-coffee" href="#icon-coffee" />
    </svg></h2>
    <label class="input">
      <input class="input__field" type="number" id="addAmount" placeholder="$" value="" />
      <span class="input__label">Add To Total</span>
    </label>
   
    <div class="button-group">
      <button onclick="addToAccount()">Add</button>
    </div>
  </div>



  <div class="carp">
    <h2> <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-coffee" href="#icon-coffee" />
    </svg></h2>
    <label class="input">
      <input class="input__field" type="text" id="newCategory" placeholder="Name" value="" />
      <span class="input__label">New Category:</span>
    </label>
    <h4>.</h4> 
    <label class="input">
      <input class="input__field" type="number" id="categoryGoal" placeholder="$" value="" />
      <span class="input__label">Category Goal:</span>
    </label>
   
    <div class="button-group">
      <button onclick="addCategory()">Create Category</button>
    </div>
  </div>


  <div class="cari">
    <h2> <svg class="icon" aria-hidden="true">
      <use xlink:href="#icon-coffee" href="#icon-coffee" />
    </svg></h2>
    <label class="input">
      <input class="input__field" type="number" id="categoryAmount" placeholder="$" value="" />
      <span class="input__label">Add Amount:</span>
    </label>

    <div class="button-group">
      <button onclick="updateCategoryBalance()">Update Category</button>
      <label for="existingCategories">Select Category:</label>
      <select id="existingCategories"></select>
    </div>
  </div>



  <style>
    .cardd {
      box-shadow: 0 4px 8px 0 rgba(255, 255, 255, 0.2);
      max-width: 3000px;
      margin: auto;
      font-family: "Inter", sans-serif;
      position: absolute;
      top: 85px;
      right:15px;
    }
    </style>

<style>
  .carddd {
    box-shadow: 0 4px 8px 0 rgba(255, 255, 255, 0.2);
    width: 200px;
    margin: auto;
    font-family: "Inter", sans-serif;
    position: absolute;
    top: 100px;
    left:550px;
  }
  </style>

  <style>
    .card {
      box-shadow: 0 4px 8px 0 rgba(255, 255, 255, 0.2);
      max-width: 1000px;
      margin: auto;
      text-align: left;
      font-family: "Inter", sans-serif;
      position: absolute;
      top: 550px;
      left:10px;
    }
    </style>

    <body>
    
    <div class="card">
      <div id="log">
        <!-- Transaction log will be added here -->
      </div>
    </div>
    </body>

    <body>
    
      <div class="carddd">
        <div id="categoryList">
          <!-- Category cards will be added here -->
        </div>
      </div>
      </body>


    <body>
    
      <div class="cardd">
        <div id="accountChartContainer">
          <canvas id="accountChart" width="400" height="200"></canvas>
        </div>
        <div id="categoryCharts">
          <!-- Category charts will be added here -->
        </div>
      </div>
      </body>


  <script>
    let accountTotal = 0;
    let categories = [];
    // Initialize the chart for account total
    const accountCtx = document.getElementById('accountChart').getContext('2d');
    const accountChart = new Chart(accountCtx, {
      type: 'line',
      data: {
        labels: [],
        datasets: [{
          label: 'Account Total',
          borderColor: 'rgb(0, 0, 0)',
          data: [],
          fill: false,
        }]
      },
      options: {
        scales: {
          x: {
            type: 'linear',
            position: 'bottom'
          },
          y: {
            min: 0
          }
        }
      }
    });
    function addToAccount() {
      const addAmount = parseFloat(document.getElementById('addAmount').value);
      if (!isNaN(addAmount)) {
        accountTotal += addAmount;
        document.getElementById('accountTotal').innerText = accountTotal.toFixed(2);
        updateAccountChart(); // Update the account total chart
        logTransaction(`Added $${addAmount} to account total.`);
      }
    }
    function addCategory() {
      const newCategory = document.getElementById('newCategory').value;
      const categoryGoal = parseFloat(document.getElementById('categoryGoal').value);
      if (newCategory && !isNaN(categoryGoal)) {
        categories.push({ name: newCategory, goal: categoryGoal, balance: 0 });
        updateCategoryList();
        createCategoryChart(newCategory); // Create a chart for the new category
        logTransaction(`Created category "${newCategory}" with a goal of $${categoryGoal}.`);
      }
    }
    function updateCategoryList() {
      const selectElement = document.getElementById('existingCategories');
      selectElement.innerHTML = '';
      for (const category of categories) {
        const option = document.createElement('option');
        option.value = category.name;
        option.innerText = category.name;
        selectElement.appendChild(option);
      }
      // Update category cards
      const categoryListElement = document.getElementById('categoryList');
      categoryListElement.innerHTML = '';
      for (const category of categories) {
        const card = document.createElement('div');
        card.innerHTML = `<p>${category.name} - Goal: $${category.goal} | Balance: $${category.balance.toFixed(2)}</p>`;
        const percentage = (category.balance / category.goal) * 100;
        card.innerHTML += `<p>Progress: ${percentage.toFixed(2)}%</p>`;
        categoryListElement.appendChild(card);
      }
    }
    function createCategoryChart(categoryName) {
      const chartContainer = document.getElementById('categoryCharts');
      const canvas = document.createElement('canvas');
      canvas.id = `chart-${categoryName}`;
      canvas.width = 400;
      canvas.height = 200;
      chartContainer.appendChild(canvas);

      const ctx = canvas.getContext('2d');
      const chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: [],
          datasets: [{
            label: `${categoryName} Balance`,
            borderColor: 'rgb(0, 0, 0)',
            data: [],
            fill: false,
          }]
        },
        options: {
          scales: {
            x: {
              type: 'linear',
              position: 'bottom'
            },
            y: {
              min: 0
            }
          }
        }
      });
      // Save the chart instance in the categories array
      const category = categories.find(cat => cat.name === categoryName);
      category.chart = chart;
    }
    function updateAccountChart() {
      // Update account total chart
      const accountData = accountChart.data.datasets[0].data;
      const accountLabels = Array.from({ length: accountData.length + 1 }, (_, i) => i + 1);
      accountData.push(accountTotal);
      accountChart.data.labels = accountLabels;
      accountChart.update();
    }
    function updateCategoryBalance() {
      const selectedCategory = document.getElementById('existingCategories').value;
      const categoryAmount = parseFloat(document.getElementById('categoryAmount').value);
      if (selectedCategory && !isNaN(categoryAmount)) {
        const category = categories.find(cat => cat.name === selectedCategory);
        if (category && categoryAmount <= accountTotal) {
          category.balance += categoryAmount;
          accountTotal -= categoryAmount;
          document.getElementById('accountTotal').innerText = accountTotal.toFixed(2);
          updateCategoryList();
          updateChart(category); // Update the corresponding chart for the category
          updateAccountChart(); // Update the account total chart
          logTransaction(`Transferred $${categoryAmount} from account to category "${selectedCategory}".`);
        }
      }
    }
    function updateChart(category) {
      const ctx = category.chart.ctx;
      // Destroy existing chart to avoid duplicating
      if (category.chart) {
        category.chart.destroy();
      }
      category.chart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: Array.from({ length: category.chart.data.labels.length + 1 }, (_, i) => i + 1),
          datasets: [{
            label: `${category.name} Balance`,
            borderColor: getRandomColor(),
            data: category.chart.data.datasets[0].data.concat(category.balance),
            fill: false,
          }]
        },
        options: {
          scales: {
            x: {
              type: 'linear',
              position: 'bottom'
            },
            y: {
              min: 0
            }
          }
        }
      });
    }
    function getRandomColor() {
      const letters = '0123456789ABCDEF';
      let color = '#';
      for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
      }
      return color;
    }
    function logTransaction(message) {
      const logElement = document.getElementById('log');
      const logEntry = document.createElement('p');
      logEntry.innerText = `${new Date().toLocaleString()} - ${message}`;
      logElement.appendChild(logEntry);
    }
  </script>


  <script>
  window.console = window.console || function(t) {};
</script>

  
  
</head>
  
</body>

</html>


<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
    
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
  
<style>
@import url("https://rsms.me/inter/inter.css");
:root {
  --color-light: white;
  --color-dark: #212121;
  --color-signal: #fab700;
  --color-background: var(--color-light);
  --color-text: var(--color-dark);
  --color-accent: var(--color-signal);
  --size-bezel: .5rem;
  --size-radius: 4px;
  line-height: 1.4;
  font-family: "Inter", sans-serif;
  font-size: calc(.6rem + .4vw);
  color: var(--color-text);
  background: var(--color-background);
  font-weight: 300;
  padding: 0 calc(var(--size-bezel) * 0);
}

h1, h2, h3 {
  font-weight: 900;
}

h4 {
  font-weight: 100;
  --color-light: white;
}

mark {
  background: var(--color-accent);
  color: var(--color-text);
  font-weight: bold;
  padding: 0 0.2em;
}
.carp {
  background: var(--color-background);
  padding: calc(0 * var(--size-bezel));
  margin-top: calc(2 * var(--size-bezel));
  border-radius: var(--size-radius);
  border: 0px solid var(--color-shadow, currentColor);
  box-shadow: 0rem 0rem 0 var(--color-shadow, currentColor);
  width: 50%;
  position: absolute;
  left:30px;
  top:200px;
    }
    .cari {
  background: var(--color-background);
  padding: calc(0 * var(--size-bezel));
  margin-top: calc(2 * var(--size-bezel));
  border-radius: var(--size-radius);
  border: 0px solid var(--color-shadow, currentColor);
  box-shadow: 0rem 0rem 0 var(--color-shadow, currentColor);
  width: 50%;
  position: absolute;
  left:30px;
  top:400px;
    }
.car {
  background: var(--color-background);
  padding: calc(0 * var(--size-bezel));
  margin-top: calc(2 * var(--size-bezel));
  border-radius: var(--size-radius);
  border: 0px solid var(--color-shadow, currentColor);
  box-shadow: 0rem 0rem 0 var(--color-shadow, currentColor);
  width: 50%;
  position: absolute;
  left:30px;
  top:55px;
    }
.card--inverted {
  --color-background: var(--color-dark);
  color: var(--color-light);
  --color-shadow: var(--color-accent);
}
.card--accent {
  --color-background: var(--color-signal);
  --color-accent: var(--color-light);
  color: var(--color-dark);
}
.card *:first-child {
  margin-top: 0;
}

.l-design-widht {
  max-width: 30rem;
  padding: 0rem;
}

.input {
  position: relative;
}
.input__label {
  position: absolute;
  left: 0;
  top: 0;
  padding: calc(var(--size-bezel) * 0.75) calc(var(--size-bezel) * .5);
  margin: calc(var(--size-bezel) * 0.75 + 3px) calc(var(--size-bezel) * .5);
  background: pink;
  white-space: nowrap;
  transform: translate(0, 0);
  transform-origin: 0 0;
  background: var(--color-background);
  transition: transform 120ms ease-in;
  font-weight: bold;
  line-height: 1.2;
}
.input__field {
  box-sizing: border-box;
  display: block;
  width: 70%;
  border: 3px solid currentColor;
  padding: calc(var(--size-bezel) * 1.5) var(--size-bezel);
  color: currentColor;
  background: transparent;
  border-radius: var(--size-radius);
}
.input__field:not(:-moz-placeholder-shown) + .input__label {
  transform: translate(0.25rem, -65%) scale(0.8);
  color: var(--color-accent);
}
.input__field:not(:-ms-input-placeholder) + .input__label {
  transform: translate(0.25rem, -65%) scale(0.8);
  color: var(--color-accent);
}
.input__field:focus + .input__label, .input__field:not(:placeholder-shown) + .input__label {
  transform: translate(0.25rem, -65%) scale(0.8);
  color: var(--color-accent);
}

.button-group {
  margin-top: calc(var(--size-bezel) * 2.5);
}

button {
  color: currentColor;
  padding: var(--size-bezel) calc(var(--size-bezel) * 2);
  background: var(--color-accent);
  border: none;
  border-radius: var(--size-radius);
  font-weight: 900;
}
button[type=reset] {
  background: var(--color-background);
  font-weight: 200;
}

button + button {
  margin-right: calc(var(--size-bezel) * 2);
}

.icon {
  display: inline-block;
  width: 1em;
  height: 1em;
  margin-right: 0.5em;
}

.hidden {
  display: none;
}
</style>

  <script>
  window.console = window.console || function(t) {};
</script>

  
<script>
  // Previous JavaScript code for handling button clicks and interactions
  
  function fetchTransactions() {
    fetch('http://localhost:8085/api/transactions')
      .then(response => response.json())
      .then(data => {
          console.log(data);
          // Here, instead of just logging the data, you could update the UI
          // For example, updating the account total or populating a list of transactions
      })
      .catch(error => console.error('Error:', error));
  }
  
  // Call fetchTransactions to load initial transaction data
  document.addEventListener('DOMContentLoaded', function() {
      // Existing event listeners setup
      fetchTransactions(); // Fetch transactions when the page loads
  });
  </script>
    

</head>

  
</body>

</html>