export const environment = {
  production: true,
  socketEndpoint: 'http://socketurl',
  socketIoOptions: {
    "reconnection": true,             // whether to reconnect automatically
    "reconnectionAttempts": 1000, // number of reconnection attempts before giving up
    "reconnectionDelay": 1000,        // how long to initially wait before attempting a new reconnection
    "reconnectionDelayMax": 5000,     // maximum amount of time to wait between reconnection attempts. Each attempt increases the reconnection delay by 2x along with a randomization factor
    "randomizationFactor": 0.5,
  }
};
