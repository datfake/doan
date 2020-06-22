import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Home from "../views/Home.vue";
import Admin from "../views/Admin.vue";
import Login from "../views/Login.vue";
import Signup from "../views/Signup.vue";
import CreatePost from "../views/CreatePost.vue";
import ListPost from "../views/ListPost.vue";
import ListUser from "../views/ListUser.vue";
import store from "../store";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin,
  },
  {
    path: '/createplace',
    name: 'newsitem',
    component: CreatePost,
  },
  {
    path: '/listpost',
    name: 'newsitem',
    component: ListPost,
  },
  {
    path: '/listuser',
    name: 'newsitem',
    component: ListUser,
  }
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});
router.beforeEach(async (to, from, next) => {
  await store.dispatch("fetchToken");
  if (store.state.userToken.token && to.name === "login") {
    next("./");
  }
  next();
});
export default router;
