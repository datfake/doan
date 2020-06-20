import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";
import VueAxios from "vue-axios";
import router from "./../router";

Vue.use(Vuex);
Vue.use(VueAxios, axios);

export const authStore = {
  namespaced: true,

  state: {
    userToken: {},
  },

  getters: {
    getUserToken: (state) => state.userToken,
  },

  mutations: {
    setToken(state, token) {
      state.userToken = token;
    },
  },

  actions: {
    fetchToken({ commit }) {
      commit(
        "setToken",
        JSON.parse(localStorage.getItem("user_token") || "{}") || {}
      );
    },
    logout: ({ commit }) => {
      localStorage.removeItem("user_token");
    },

    login: async ({ commit }, { infoLogin }) => {
      await axios
        .post(`http://localhost:8022/api/auth`, {
          email: infoLogin.email,
          password: infoLogin.password,
        })
        .then((result) => {
          commit("setToken", result.data);
          localStorage.setItem("user_token", JSON.stringify(result.data));
          axios.defaults.headers.common["Authorization"] =
            "Bearer " + result.data.token;
          router.push("/");
        })
        .catch((err) => {
          alert(err);
        });
    },
    signup: async ({ commit }, { infoSignup }) => {
      await axios
        .post(`http://localhost:8022/api/auth/register`, {
          email: infoSignup.email,
          fullName: infoSignup.fullName,
          password: infoSignup.password,
        })
        .then((result) => {
          router.push("/login");
        })
        .catch((err) => {
          alert(err);
        });
    },
  },
};
