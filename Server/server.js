const http = require('http').createServer()

const io =  require('socket.io')(http, {
    cors: { origin: '*' }
})

io.on('connection', (socket) => {
    console.log('Connected to client!')
    socket.emit('Connected')
    socket.emit("message","Forwards")
    socket.on("message", (arg) => {
      console.log(arg); // world
      
    });
})



http.listen(8080, () => console.log('Server running on port 8080'))