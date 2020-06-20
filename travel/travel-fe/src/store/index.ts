import { authStore } from "@/service/authStore";
import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";
import VueAxios from "vue-axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userToken: JSON.parse(localStorage.getItem("user_token") || "{}") || {},
    places: [],
    postCurrent: {},
    commentCurrent: {},
    posts: [],
    user:[],
    provinces: [],
    saveplace:[],
    saveimage: null
  },
  mutations: {
    places(state, places) {
      state.places = places;
    },
    posts(state, posts) {
      state.posts = posts;
    },
    review(state, value) {
      state.postCurrent = value;
    },
    comment(state, value) {
      state.commentCurrent = value;
    },
    province(state, value) {
      state.provinces = value;
    },
    user(state, value) {
      state.user = value;
    },
    saveplace(state, value) {
      state.saveplace = value;
    },
    saveimage(state, value) {
      state.saveimage = value;
    },
  },
  actions: {
    async getAllPlaces({ commit }) {
      await axios.get("http://localhost:8022/api/place").then((res) => {
        commit("places", res.data);
      });
    },

    review: async ({ commit }, { post }) => {
      await axios
        .post(`http://localhost:8022/api/post/create`, {
          content: post.content,
          idUser: post.idUser,
          idPlace: post.idPlace,
        })
        .then((result) => {
          commit("review", result.data);
        })
        .catch((err) => {
          alert(err);
        });
    },
    comment: async ({ commit }, { comment }) => {
      await axios
        .post(`http://localhost:8022/api/comment/create`, {
          content: comment.content,
          idUser: comment.idUser,
          idPost: comment.idPost,
        })
        .then((result) => {
          commit("comment", result.data);
        })
        .catch((err) => {
          alert(err);
        });
    },
    savePlace: async ({ commit }, { place }) => {
      await axios
        .post(`http://localhost:8022/api/place/create`, 
        {
         name: place.name,
         address:place.address,
         content:place.content,
         idProvince:place.idProvince,
         idImage:place.idImage
        })
        .then((result) => {
          commit("saveplace", result.data);
        })
        .catch((err) => {
          alert(err);
        });
    },
    saveImage: async ({ commit }, { formData }) => {
      await axios
        .post(`http://localhost:8022/api/place/uploadImage`, 
        formData,
        {
          headers: {
              'Content-Type': 'multipart/form-data'
          }
        })
        .then((result) => {
          commit("saveimage", result.data);
        })
        .catch((err) => {
          alert(err);
        });
    },
    async getAllPosts({ commit }) {
      await axios.get("http://localhost:8022/api/post").then((res) => {
        commit("posts", res.data);
      });
    },
    async getAllProvince({ commit }) {
      await axios.get("http://localhost:8022/api/province").then((res) => {
        commit("province", res.data);
      });
    },
    async getAllUsers({ commit }) {
      await axios.get("http://localhost:8022/api/user").then((res) => {
        commit("user", res.data);
      });
    },
    async deleteplace({ commit }, {data}) {
      await axios.delete("http://localhost:8022/api/place/del",data).then((res) => {
        return res.data;
      });
    },
    
  },
  modules: {
    auth: authStore,
  },
});
