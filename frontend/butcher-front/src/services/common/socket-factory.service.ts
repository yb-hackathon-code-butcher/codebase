import { Injectable } from '@angular/core';
import io from 'socket.io-client';
import {SocketConfig} from "../../SocketConfig";
import {environment} from "../../environments/environment";

const configs:SocketConfig = require("/src/socket_config.json");

@Injectable({
  providedIn: 'root'
})
export class SocketFactoryService {

  constructor() {

  }

  new(path:string): SocketIOClient.Socket{
    let c = configs.options;
    c.path=path;
    let socket = io(environment.backend_url,c);
    socket.on("connect", ()=> console.log("Successfully connected (path: '"+path+"')"));
    socket.on('error', (error) => console.log("Error occured (path: '"+path+"'): " + error));
    socket.on('disconnect', (reason) => {
      if (reason === "io server disconnect (path: '"+path+"')") {
        socket.connect();
      }
    });
    socket.on('connect_error', (error) => console.log("Connection error (path: '"+path+"'): " + error));
    socket.on('connect_timeout', (timeout) => console.log("Connection timeout (path: '"+path+"'): " + timeout));
    socket.on('reconnect_attempt', (attemptNumber) => console.log("Reconnection attempt (path: '"+path+"'): " + attemptNumber));
    socket.on('reconnect', () => console.log("Reconnect successfully (path: '"+path+"')"));
    socket.on('reconnect_error', (error) => console.log("Reconnection error (path: '"+path+"'): " + error));
    socket.on('ping', () => console.log("Ping sent to server (path: '"+path+"')"));
    socket.on('pong', (latency) => console.log("Pong received from server (path: '"+path+"'): "+ latency +" ms"));
    c.send("ping");
    return socket;
  }
}
