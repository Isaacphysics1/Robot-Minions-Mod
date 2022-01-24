//Import Librys And Setup
const express = require('express');
const app = express();
const http = require('http');
const server = http.createServer(app);
const { Server } = require("socket.io");
const io = new Server(server);
const bot = require("./Atributes/Bot").bot;
const Pos = require("./Atributes/Pos").pos;
const Enums = require("./Atributes/Enums");

//Set Up Middle Ware
app.use(express.static("./public"))

//Create Array For Bots
var Bots = [];

var RemoveBotWithSocketID = function(ID){

}

//Listen For Website Connection
app.get('/', (req, res) => {
  res.send(__dirname + './public/index.html');
});

//Listen For Socket Connection
io.on('connection', (socket) => {
  console.log('a user connected');

  socket.on('disconnect', () => {
    console.log('user disconnected');
  });
});

//Start Listening on Poty 8080
server.listen(8080, () => {
  console.log('listening on *:8080');
});