const express = require('express')
const path = require('path');

const app = express()
const port = 3000

app.use(express.static(path.join(__dirname, 'public')));
app.use(express.urlencoded({extended: true}))

app.get('/', (req, res) => res.sendFile('index.html'))

app.post('/', (req, res) => {
  console.log('Got a post request');

  console.log('----- Data -----');
  console.log(`First Name: ${req.body.firstname}`);
  console.log(`Last Name: ${req.body.lastname}`);
  console.log('----------------')

  res.redirect('/');
});

app.listen(port, () => console.log(`Example app listening on port ${port}!`))