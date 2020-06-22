import axios from "axios";
import store from "./store";
import router from "./router";
axios.interceptors.request.use(
  function(config) {
    const token = store.state.userToken;
    if (token) {
      config.headers.Authorization = `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXQiLCJzY29wZXMiOiJST0xFX01FTUJFUiIsImlhdCI6MTU4ODY0NDA5MywiZXhwIjoxNTkxMjM2MDkzfQ.AlqAVYY2VETxCf3-ocXdu8vC5T_He-lVR1Wk5p3z6Fk`;
    }

    return config;
  },
  function(err) {
    return Promise.reject(err);
  }
);

axios.interceptors.response.use(
  function(response) {
    return response;
  },
  function(error) {
    if (error.response.status === 401) {
      router.push("./login");
    }
    return Promise.reject(error);
  }
);
