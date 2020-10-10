// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  backend_url: "http://localhost:8080",
  socketEndpoint: 'http://138.68.73.195:9092/',
  socketIoOptions: {
    "reconnection": true,             // whether to reconnect automatically
    "reconnectionAttempts": 1000, // number of reconnection attempts before giving up
    "reconnectionDelay": 1000,        // how long to initially wait before attempting a new reconnection
    "reconnectionDelayMax": 5000,     // maximum amount of time to wait between reconnection attempts. Each attempt increases the reconnection delay by 2x along with a randomization factor
    "randomizationFactor": 0.5,
  },
  backend_api: "http://localhost:8080/api"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
