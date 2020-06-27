<template>
  <div class="app">
    <!-- <div id="preloader-active">
            <div class="preloader d-flex align-items-center justify-content-center">
                <div class="preloader-inner position-relative">
                    <div class="preloader-circle"></div>
                    <div class="preloader-img pere-text">
                        <img :src="require('../assets/img/logo/loder.jpg')" alt="">
                    </div>
                </div>
            </div>
    </div>-->
    <!-- Preloader Start -->
    <header>
      <!-- Header Start -->
      <div class="header-area header-transparent">
        <div class="main-header">
          <div class="header-bottom header-sticky">
            <div class="container-fluid">
              <div class="row align-items-center">
                <!-- Logo -->
                <div class="col-xl-2 col-lg-2 col-md-1">
                  <div class="logo">
                    <a href="index.html">
                      <img :src="require('../assets/img/logo/logo.png')" alt />
                    </a>
                  </div>
                </div>
                <div class="col-xl-10 col-lg-10 col-md-8">
                  <!-- Main-menu -->
                  <div class="main-menu f-right d-none d-lg-block">
                    <nav>
                      <ul id="navigation">
                        <li class="login" v-if="getToken.roleid==2">
                          <a @click="admin">Quản Trị</a>
                        </li>
                        <li>
                          <a @click="home">Trang Chủ</a>
                        </li>
                        <li>
                          <a href="about.html">Địa điểm du lịch</a>
                        </li>
                        <!-- <li><a href="catagori.html">Catagories</a></li>
                                            <li><a href="listing.html">Listing</a></li>
                                            <li><a href="#">Page</a>
                                                <ul class="submenu">
                                                    <li><a href="blog.html">Blog</a></li>
                                                    <li><a href="blog_details.html">Blog Details</a></li>
                                                    <li><a href="elements.html">Element</a></li>
                                                    <li><a href="listing_details.html">Listing details</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="contact.html">Contact</a></li>
                        <li class="add-list"><a href="listing_details.html"><i class="ti-plus"></i> add Listing</a></li>-->
                        <li class="login" v-if="getToken.token">
                          <a href="#">
                            <i class="ti-user"></i>
                            {{getToken.fullName}}
                          </a>
                        </li>
                        <li class="login" v-else>
                          <a href="/login">
                            <i class="ti-user"></i>Đăng Nhập hoặc Đăng Ký
                          </a>
                        </li>
                        <li class="login" v-if="getToken.token">
                          <a href="/" @click="logout">Đăng Xuất</a>
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>
                <!-- Mobile Menu -->
                <div class="col-12">
                  <div class="mobile_menu d-block d-lg-none"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Header End -->
    </header>
    <main>
      <!-- Hero Area Start-->
      <div
        class="slider-area hero-overly"
        :style="{'background-image': 'url(' + require('../assets/img/hero/h1_hero.jpg') + ')'}"
      >
        <div class="single-slider hero-overly slider-height d-flex align-items-center">
          <div class="container">
            <div class="row justify-content-center">
              <div class="col-xl-8 col-lg-9">
                <!-- Hero Caption -->
                <div class="hero__caption">
                  <!-- <span>Explore the city</span>
                  <h1>Discover Great Places</h1>-->
                  <span>Nơi tìm kiếm những địa điểm du lịch tuyệt vời nhất cho bạn</span>
                  <!-- <h1>Discover Great Places</h1> -->
                </div>
                <!--Hero form -->
                <!-- <form action="#" class="search-box">
                  <div class="input-form">
                    <input type="text" placeholder="Bạn muốn tìm kiếm gì?" />
                  </div>
                  <div class="select-form">
                                    <div class="select-itms">
                                        <select name="select" id="select1">
                                            <option value="">All Catagories</option>
                                            <option value="">Catagories One</option>
                                            <option value="">Catagories Two</option>
                                            <option value="">Catagories Three</option>
                                            <option value="">Catagories Four</option>
                                        </select>
                                    </div>
                  </div>
                  <div class="search-form">
                    <a href="#">Tìm Kiếm</a>
                  </div>
                </form>-->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--Hero Area End-->
      <!-- Popular Locations Start -->
    </main>
  </div>
</template>

<script>
export default {
  name: "header",
  data() {
    return {
      userToken: {}
    };
  },
  created: async function() {
    await this.$store.dispatch("fetchToken");
    this.userToken = this.$store.state.userToken;
  },
  methods: {
    moveLogin() {
      this.$router.push("/login");
    },
    logout() {
      confirm("Bạn có chắc muốn đăng xuất?");
      this.$store.dispatch("auth/logout");
    },
    home() {
      this.$router.push("/");
    },
    admin() {
      this.$router.push("/admin");
    }
  },
  computed: {
    getToken() {
      return JSON.parse(localStorage.getItem("user_token") || "{}") || {};
    }
  }
};
</script>

<style scoped>
/*mobile & tablet */
@media (max-width: 1023px) {
  .hide-on-mobile-tablet {
    display: none;
  }
}

/* tablet */
@media (min-width: 740px) and (max-width: 1023px) {
  .hide-on-tablet {
    display: none;
  }
}

@media (max-width: 739px) {
  .hide-on-mobile {
    display: none;
  }
}
</style>