const convertButton = document.getElementById('convert-button');
convertButton.addEventListener('click', handleConversion);
async function handleConversion() {
  const input = document.getElementById('w3review').value;
  const response = await fetch(`/convert?input=${input}`);
  const data = await response.json();
  console.log(data);
}

async function handleConversion() {
  const input = document.getElementById('w3review').value;
  const response = await fetch(`/convert?input=${input}`);
  const data = await response.json();
  // update page with conversion rate
  const result = document.getElementById('result');
  result.innerHTML = `1 ${input} = ${data} USD`;
}
